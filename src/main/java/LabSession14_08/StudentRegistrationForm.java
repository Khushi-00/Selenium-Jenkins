package LabSession14_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentRegistrationForm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		

		ChromeOptions chromeoptions=new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(chromeoptions);
		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		// enter name
		
		WebElement username= driver.findElement(By.xpath("	//input[@id='name']"));
		username.sendKeys("Manisha");
		
		//enter email
		
		WebElement email= driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("oria0302002@gmail.com");
		
		// enter gender
		
		WebElement checkbox =driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
		checkbox.click();	
		Thread.sleep(2000);
		
		//enter mobile number
		
		WebElement num= driver.findElement(By.xpath("	//input[@id='mobile']"));
		num.sendKeys("909090909");
		
		//enter dob
		
		 WebElement dob = driver.findElement(By.xpath("//input[@id='dob']"));
	     dob.sendKeys("03-12-2002");
	     Thread.sleep(2000);
	    

	     //enter subject

		WebElement sub= driver.findElement(By.xpath("//input[@id='subjects']"));
		sub.sendKeys("Maths");
		
		//enter hobbies
		
		WebElement checkbox1 =driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		checkbox1.click();	
		Thread.sleep(2000);
		
		//upload pic
		
		WebElement uploadPicture = driver.findElement(By.id("picture"));
        uploadPicture.sendKeys("C:\\Users\\Manisha\\OneDrive\\Pictures\\Screenshot 2024-11-13 154746.png"); // Change path to your file
        Thread.sleep(2000);
		
        //engter address
        

		WebElement add= driver.findElement(By.xpath("//textarea[@id='picture']"));
		add.sendKeys("Sirsi road");
		
		//select state
		

		WebElement drdwn= driver.findElement(By.xpath("//select[@id='state']"));
		Select sel=new Select(drdwn);	
		sel.selectByVisibleText("Rajasthan");
		
		//select city
		

		WebElement drdwn1= driver.findElement(By.xpath("//select[@id='city']"));
		Select sel1=new Select(drdwn1);	
		sel1.selectByVisibleText("Agra");
		
		
		//click on login

		
		WebElement login= driver.findElement(By.xpath("//input[@value='Login']"));
		login.click();
		
		
		

	}

}

