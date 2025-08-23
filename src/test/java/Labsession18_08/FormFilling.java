package Labsession18_08;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormFilling {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions chromeOption = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		//Maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstname.sendKeys("Manisha");
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.sendKeys("Dhank");
		WebElement gender = driver.findElement(By.xpath("//input[@id='sex-1']"));
		gender.click();
		WebElement experience = driver.findElement(By.xpath("//input[@id='exp-0']"));
		experience.click();
		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.sendKeys("18-08-2025");
		 driver.findElement(By.id("profession-1")).click();
	        // Select Automation Tool
	        driver.findElement(By.id("tool-2")).click();

		WebElement continents = driver.findElement(By.xpath("//select[@id='continents']"));
		continents.click();
		WebElement commands = driver.findElement(By.xpath("//option[normalize-space()='Browser Commands']"));
		commands.click();
		
		WebElement upload = driver.findElement(By.xpath("//input[@id='photo']"));
		upload.sendKeys("C:\\Users\\Manisha\\Downloads\\test-file.txt");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
		submit.click();
		Thread.sleep(2000);
		
	}

}