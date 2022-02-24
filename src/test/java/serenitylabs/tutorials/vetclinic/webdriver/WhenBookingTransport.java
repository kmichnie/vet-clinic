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
        driver.get("https://www.thetrainline.com/");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
    public void should_be_able_to_check_trip_options() {

        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();

        WebElement fromLocation = driver.findElement(By.id("from.search"));
        fromLocation.sendKeys("Warsaw");
        fromLocation.sendKeys(Keys.ENTER);


        WebElement destinationLocation = driver.findElement(By.id("to.search"));
        destinationLocation.sendKeys("Berlin");
        fromLocation.sendKeys(Keys.ENTER);

        WebElement openDepartureDatePicker = driver.findElement(By.id("page.journeySearchForm.outbound.title"));
        openDepartureDatePicker.click();

        new Select(driver.findElement(By.cssSelector("fieldset[data-test='outbound-datepicker'] select[name='hours']"))).selectByIndex(10);
        new Select(driver.findElement(By.cssSelector("fieldset[data-test='outbound-datepicker'] select[name='minutes']"))).selectByIndex(2);

        WebElement getTimesAndTickets = driver.findElement(By.cssSelector("button[type='submit']"));
        getTimesAndTickets.click();

    }
}
