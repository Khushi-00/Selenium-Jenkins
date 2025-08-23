package wipro.Javaselenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadEg {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeOptions chromeoptions=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromeoptions);
		driver.get("https://the-internet.herokuapp.com/download");

		driver.manage().window().maximize();
		
		WebElement  filedownload= driver.findElement(By.xpath("//a[@href='download/test-file.txt']"));
		filedownload.click();
		
		
		//download the text file
		
		File f= new File("C:\\Users\\Manisha\\Downloads\\test-file.txt");
		
		//check whether the file is existing in folder or not
		
		if(f.exists()) {
			
			System.out.println("The file is present");
			
			}else {
				System.out.println("The file is not present");
			}
		Thread.sleep(2000);
	}

}
