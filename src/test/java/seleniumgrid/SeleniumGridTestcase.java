package seleniumgrid;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class SeleniumGridTestcase extends HelperClass {
 
	
	
	@Test
	public void login() {
	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

	    WebElement Username = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.name("username"))
	    );
	    Username.sendKeys("Admin");

	    WebElement Password = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.name("password"))
	    );
	    Password.sendKeys("admin123");

	    WebElement LoginButton = wait.until(
	        ExpectedConditions.elementToBeClickable(By.tagName("button"))
	    );
	    LoginButton.click();
	}

}