package wiproTestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.LoggerHelper;

public class TestNgTestCase {
	// Annotations we can control the flow of execution 
		 private static final org.apache.logging.log4j.Logger log = LoggerHelper.getLogger(TestNgTestCase.class);
		 @Test
		public void launchbrowser() {
			ChromeOptions chromeOptions = new ChromeOptions();
	 
			WebDriverManager.chromedriver().setup();
	 
			WebDriver driver = new ChromeDriver(chromeOptions);

	 
			driver.get("https://the-internet.herokuapp.com/windows");
			log.info("Invoking the browser");
			// maximize the window
			driver.manage().window().maximize();
		}
		@Test
		public void login() throws InterruptedException {

			ChromeOptions chromeOptions = new ChromeOptions();
	 
			WebDriverManager.chromedriver().setup();
	 
			WebDriver driver = new ChromeDriver(chromeOptions);
	 
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			// name locator 
			// enter text in username field 
			Thread.sleep(2000);
			log.info("Invoking the browser");
			WebElement username = driver.findElement(By.name("username"));
			log.info("Entering the username");
			username.sendKeys("Admin");
			Thread.sleep(2000);
			// enter text in password field
			WebElement password = driver.findElement
					(By.xpath("//input[@name = 'password']"));
			log.info("Entering the password");

			password.sendKeys("admin123");
			// click on login button
			Thread.sleep(2000);
			WebElement loginbutton = driver.findElement
					(By.xpath("//button[@type = 'submit']"));

			loginbutton.click();
			Thread.sleep(2000);
		
}}
