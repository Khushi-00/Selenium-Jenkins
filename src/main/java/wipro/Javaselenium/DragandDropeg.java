package wipro.Javaselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropeg {

	public static WebDriver driver;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		try {
		System.setProperty("webdriver.edge.driver", "C:/Users/Manisha/Downloads/edgedriver_win64/msedgedriver.exe");

        // Create EdgeDriver instance

        driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		driver.manage().window().maximize();
		
		//Actions class is used to stimulate the mouse reted activities
		
		Actions act=new Actions(driver);
		
		WebElement from= driver.findElement(By.id("column-a"));
		WebElement to = driver.findElement(By.id("column-b"));
			
		act.dragAndDrop(from,to).perform();
		
		Thread.sleep(2000);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
