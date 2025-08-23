package LabSession14_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	public static WebDriver driver;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		try {
		System.setProperty("webdriver.edge.driver", "C:/Users/Manisha/Downloads/edgedriver_win64/msedgedriver.exe");

        // Create EdgeDriver instance

        driver = new EdgeDriver();
		String url="https://rahulshettyacademy.com/AutomationPractice";
		driver.get(url);
		driver.manage().window().maximize();
		
		//Actions class is used to stimulate the mouse reted activities
		
		Actions act=new Actions(driver);

		WebElement mouseHover= driver.findElement(By.xpath("//button[@id='mousehover']"));

		act.moveToElement(mouseHover).perform();

		Thread.sleep(4000);

		WebElement top= driver.findElement(By.xpath("//a[@href='#top']"));

		act.click(top).perform();
		Thread.sleep(1000);
		
		if(url.contains("top")) {
			System.out.println("Top is there");
			
		}else {
			System.out.println("Failed");
		}
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}

