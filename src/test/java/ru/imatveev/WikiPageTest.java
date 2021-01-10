package ru.imatveev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class WikiPageTest {
    private WebDriver driver;
    private WikiPage page;

    @BeforeMethod
    public void setUp() {
        //set path to driver
        System.setProperty("webdriver.gecko.driver", "/home/ivan/Downloads/geckodriver");
        //create new driver
        driver = new FirefoxDriver();
        //add timeout for every elements searching
        driver.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS);
        //open browser's url
        driver.get("https://www.wikipedia.org/");
    }

    @Test
    public void searchTest() {
        String searchingWord = "History";
        page = new WikiPage(driver);
        page.textRequest(searchingWord)
                .search();

        assertEquals(page.getHeadingText(), searchingWord);
    }

    @AfterMethod
    public void close() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
