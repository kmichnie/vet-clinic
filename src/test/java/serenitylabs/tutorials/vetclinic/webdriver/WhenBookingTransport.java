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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

        WebElement setDepartureDate = driver.findElement(By.id("page.journeySearchForm.outbound.title3-7"));
        setDepartureDate.click();

        new Select(driver.findElement(By.cssSelector("fieldset[data-test='outbound-datepicker'] select[name='hours']"))).selectByIndex(10);
        new Select(driver.findElement(By.cssSelector("fieldset[data-test='outbound-datepicker'] select[name='minutes']"))).selectByIndex(2);

        WebElement getAvailableTravelOptions = driver.findElement(By.cssSelector("button[type='submit']"));
        getAvailableTravelOptions.click();

        // $$("div [data-test='eu-matrix-date']")
        // $x("//*[@data-test='eu-matrix-date']//span[text()='Mon']")
        WebElement shortDayName = driver.findElement(By.xpath("//*[@data-test='eu-matrix-date']//span[text()='Mon']"));
        WebElement dayOfMonth = driver.findElement(By.xpath("//*[@data-test='eu-matrix-date']//span[text()='7']"));
        WebElement shortMonthName = driver.findElement(By.xpath("//*[@data-test='eu-matrix-date']//span[text()='Mar']"));
        WebElement year = driver.findElement(By.xpath("//*[@data-test='eu-matrix-date']//span[text()='2022']"));


        assertThat(shortDayName.getText(), equalTo("Mon"));
        assertThat(dayOfMonth.getText(), equalTo("7"));
        assertThat(shortMonthName.getText(), equalTo("Mar"));
        assertThat(year.getText(), equalTo("2022"));



    }
}
