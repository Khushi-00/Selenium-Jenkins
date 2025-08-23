package wipro.Javaselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDowneg {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		ChromeOptions chromeoptions=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromeoptions);
		driver.get("https://grotechminds.com/multiple-select/?");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement drdwn= driver.findElement(By.xpath("//select[@id = 'automobiles']"));

		Select sel=new Select(drdwn);
		
		//select by visible text
		
		sel.selectByVisibleText("Option1");
		
		Thread.sleep(2000);
		
		//select by value
		
		sel.selectByValue("Option2");
		
		Thread.sleep(2000);
		
		//select by index
		
		sel.selectByIndex(3);
		
		
	}

}
