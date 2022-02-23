package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class WhenBookingTransport {

    WebDriver driver;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://transportnsw.info/");
    }

    @Test
    public void should_be_able_to_check_trip_options() {

        WebElement moreTravelOptions = driver.findElement(By.xpath("//button[text()='More options']"));
        moreTravelOptions.click();

        WebElement fromLocation = driver.findElement(By.id("tniFromTripLocation"));
        fromLocation.click();
        fromLocation.clear();
        fromLocation.sendKeys("Town Hall");
        fromLocation.sendKeys(Keys.ENTER);


        WebElement destinationLocation = driver.findElement(By.id("tniToTripLocation"));
        destinationLocation.sendKeys("Parramatta");

        WebElement pickProperDestination = driver.findElement(By.xpath("//*[contains(@class, 'ng-star-inserted')]//*[text() = 'Parramatta Station']"));
        pickProperDestination.click();



        WebElement openTimeSettings = driver.findElement(By.cssSelector("[aria-labelledby='icon-85'"));
        openTimeSettings.click();

        new Select(driver.findElement(By.id("search-select-date"))).selectByIndex(1);



    }
}
