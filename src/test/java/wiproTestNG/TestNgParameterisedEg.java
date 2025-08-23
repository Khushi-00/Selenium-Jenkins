package wiproTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgParameterisedEg {
	
	
	@Parameters({ "browser", "platform" })
	@Test
	public void testparameters(String browser, String platform) {
		try {
		if (browser.equals("chrome")  && platform.equals("widnows")) {
	
			ChromeOptions chromeOptions = new ChromeOptions();
 
			WebDriverManager.chromedriver().setup();
 
			WebDriver driver = new ChromeDriver(chromeOptions);
 
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
		}else {
			System.setProperty("webdriver.edge.driver", "C:/Users/Manisha/Downloads/edgedriver_win64/msedgedriver.exe");
		    // Create EdgeDriver instance
		    WebDriver driver = new EdgeDriver();
		    // Open a webpage
		    driver.get("https://www.google.com");
		}}catch(Exception e) {
			System.out.println(e);
			
		}

	

	}}
