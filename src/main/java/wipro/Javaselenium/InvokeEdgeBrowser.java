package wipro.Javaselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InvokeEdgeBrowser {

	public static void main(String[] args) {
		// Set path to EdgeDriver executable

        System.setProperty("webdriver.edge.driver", "C:/Users/Manisha/Downloads/edgedriver_win64/msedgedriver.exe");

        // Create EdgeDriver instance

        WebDriver driver = new EdgeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}

}
