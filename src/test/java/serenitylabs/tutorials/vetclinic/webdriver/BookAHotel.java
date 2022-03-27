package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BookAHotel {
    WebDriver driver;
    LocalDate today = LocalDate.now();
    LocalDate plusThreeDays = today.plusDays(3);
    String dayOfMonth = String.valueOf(plusThreeDays.getDayOfMonth());

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.phptravels.net/hotels");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


    }

    @Test
    public void shouldBeAbleToBuyDress() {
        driver.findElement(By.id("select2-hotels_city-container")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys("Warsaw");
        driver.findElement(By.id("checkin")).click();

        List<WebElement> dates = driver.findElements(By.cssSelector(".datepicker-days .day.new"));
        //$x("//table[@class=' table-condensed']//td")





    }

}
