package Labsession18_08;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class 
Booking{
    public static void clickEvent(WebDriver driver, String xpath, String Keys) throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        if(!Keys.isEmpty()){
            element.clear();
            element.sendKeys(Keys);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://phptravels.net/");
        Thread.sleep(1500);
        // Hotels
        clickEvent(driver, "//ul[@id='tab']/li[2]/button", "");
        // city
        clickEvent(driver,"//span[@id='select2-hotels_city-container']", "");
        WebElement city = driver.findElement(By.xpath("//body/span[@class='select2-container select2-container--default select2-container--open']/span[@class='select2-dropdown select2-dropdown--below']/span[@class='select2-results select2--fadein']/ul[@id='select2-hotels_city-results']/div[@class='most--popular-hotels']/div[1]"));
city.click();        Thread.sleep(500);
        city.sendKeys(Keys.ENTER);
        // checkin
        clickEvent(driver, "//input[@id='checkin']", "25-08-2025");
        // checkout
        clickEvent(driver, "//input[@id='checkout']","26-08-2025");
        // travellers
        clickEvent(driver, "//form[@id='hotels-search']//div[@class='dropdown dropdown-contain show active']","");
        // rooms
        clickEvent(driver, "//input[@id='hotels_rooms']","2");
        // adults
        clickEvent(driver, "//input[@id='hotels_adults']","");
        // search
        
        clickEvent(driver, "//form[@id='hotels-search']//button[@type='submit']","");
        // check hotel
       
        clickEvent(driver, "//li[2]//div[1]//div[1]//div[1]//div[2]//div[1]//div[2]//div[2]//a[1]","");
        // book now
        Thread.sleep(4000);
        clickEvent(driver, "//button[@class='btn btn-primary rounded-1 waves-effect']","");
        Thread.sleep(1000);
        // Enter personal information
        clickEvent(driver, "//input[@id='p-first-name']","Manisha");
        clickEvent(driver, "//input[@id='p-last-name']","Dhank");
        clickEvent(driver, "//input[@id='p-email']","manisha@xyz.com");
        clickEvent(driver, "//input[@id='p-phone']","9273293747");
        clickEvent(driver, "//input[@id='p-address']","Jaipur, Rajasthan, India");
//        clickEvent(driver, "//div[@class='dropdown-menu show']//input[@aria-label='Search']","India");

        // Enter traveller information
        clickEvent(driver, "//input[@name='firstname_1']", "Manisha");
        clickEvent(driver, "//input[@name='lastname_1']", "Dhank");
        Thread.sleep(500);
        clickEvent(driver, "//input[@name='firstname_2']", "Dhruv");
        clickEvent(driver, "//input[@name='lastname_2']", "Mangla");

        // select payment option
        clickEvent(driver, "//input[@id='gateway_bank_transfer']", "");
        // check agreement
        clickEvent(driver, "//input[@id='agreechb']", "");
        // confirm booking
        clickEvent(driver, "//div[@class='btn-box mt-3']", "");




    }
}