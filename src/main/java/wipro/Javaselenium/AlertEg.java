package wipro.Javaselenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertEg {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		ChromeOptions chromeoptions=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromeoptions);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		//click on simple alert

		WebElement simplealert = driver.findElement(By.cssSelector("button[onclick='jsAlert()']"));
	        
		simplealert.click();
		
		Thread.sleep(2000);
		
		Alert alt = driver.switchTo().alert();
		
		//click ok button
		
		alt.accept();
		
		Thread.sleep(2000);
		
		
		
		
		// click on confirm alert

		WebElement confirm = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));

		confirm.click();

		Thread.sleep(2000);

		Alert alt1 = driver.switchTo().alert();

		// click ok button

		alt1.dismiss();

		Thread.sleep(2000);
		
		
		// click on prompt alert

		WebElement prompt = driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));

		prompt.click();

		Thread.sleep(2000);

		Alert alt2 = driver.switchTo().alert();
		
		alt2.sendKeys("Hello");
		
		Thread.sleep(2000);


		// click ok button

		alt2.accept();

		Thread.sleep(2000);
		
		
		
		
		

	}

}
