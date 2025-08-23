package wipro.Javaselenium;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEventsEg {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
		ChromeOptions chromeOption = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(chromeOption);
		driver.get("https://www.facebook.com/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//implicit wait is applied to all the elements within the web driver lifespan before it throws ElementNot Found Exception
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Action class is used to simulate the mouse related activities
		Actions act = new Actions(driver);
		
	
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		act.moveToElement(email).keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).build().perform();
		

		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		act.moveToElement(password).click().sendKeys("hi").release().build().perform();
		
		}catch(Exception e){
			System.out.println(e);
			
		}
		finally {
			driver.quit();
			
		}
	}
}

