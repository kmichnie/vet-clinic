package serenitylabs.tutorials.vetclinic.webdriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WhenBookingTrainRailEurope {

    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.intercity.pl/en/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void shouldBeAbleToBookATrain() {
        //driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.findElement(By.id("stname-0")).sendKeys("Warszawa Centralna");
        driver.findElement(By.id("stname-1")).sendKeys("Szczecin Główny");


    }

}
