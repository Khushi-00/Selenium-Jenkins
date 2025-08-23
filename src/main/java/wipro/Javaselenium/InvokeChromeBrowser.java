package wipro.Javaselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeChromeBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions chromeoptions=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromeoptions);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


	}

}
