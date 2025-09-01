package com.wipro.capestone;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class DemoblazeTests {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    WebDriverWait wait;

    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Extent Report setup
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent-report-" + browser + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    
    @Test(priority = 1)
    public void productSearchAndFilter() {
        test = extent.createTest("Product Search and Filter");
        driver.get("https://www.demoblaze.com/");
        Assert.assertTrue(driver.getTitle().contains("STORE"), "Home page not loaded");
        test.pass("Home page loaded successfully");
    }

    @Test(priority = 2)
    public void productDetailsAndAddToCart() {
        test = extent.createTest("Product Details and Add to Cart");

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Laptops"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sony vaio i5"))).click();

        String price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".price-container"))).getText();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart"))).click();

        // Handle alert after adding to cart
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        test.pass("Product added to cart with price: " + price);
    }

    @Test(priority = 3)
    public void checkoutProcess() {
        test = extent.createTest("Checkout Process");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Test User");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Delhi");
        driver.findElement(By.id("card")).sendKeys("1234567890123456");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("2025");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Purchase']"))).click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"))).isDisplayed());

        test.pass("Checkout completed successfully");
    }

    @Test(priority = 4)
    public void userAccountManagement() {
        test = extent.createTest("User Account Management");

        // Ensure we are on the homepage
        driver.get("https://www.demoblaze.com/");
        
        // Wait until the Sign up link is clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signupLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("signin2")));
        signupLink.click();

        // Fill in sign-up form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username"))).sendKeys("testuser123");
        driver.findElement(By.id("sign-password")).sendKeys("pass123");
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        test.pass("User registration simulated (Demoblaze has limited account features)");
    }

    @AfterMethod
    public void captureResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "screenshots/" + result.getName() + ".png";
            Files.createDirectories(new File("screenshots").toPath());
            Files.copy(screenshot.toPath(), new File(path).toPath());
            test.fail("Test failed: " + result.getThrowable(),
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
    }
}
