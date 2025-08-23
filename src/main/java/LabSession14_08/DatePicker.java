package LabSession14_08;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		ChromeOptions chromeoptions=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromeoptions);
driver.get("https://ui.shadcn.com/docs/components/date-picker");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		// Click date picker button
		Thread.sleep(2000);
        WebElement datePickerButton = driver.findElement(By.xpath("//[@id='date']"));
        datePickerButton.click();
		
        //Wait for and click the desired date
        Thread.sleep(2000);
        WebElement targetDate = driver.findElement(By.xpath("//button[@aria-label='Wednesday, August 20th, 2025']"));
		targetDate.click();
		
		Thread.sleep(2000);
		driver.quit();


	}

}
