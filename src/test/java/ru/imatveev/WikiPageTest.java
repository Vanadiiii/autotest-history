package ru.imatveev;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static org.testng.Assert.assertEquals;

@Listeners({ScreenShooter.class})
public class WikiPageTest {
    private final WikiPage page = new WikiPage();

    @BeforeClass
    public void setUp() {
        //add baseUrl of selenide.Configuration.class
        baseUrl = "https://www.wikipedia.org/";
        //chose browser in selenide.Configiguration.class
        browser = "chrome";
        //set browser options
        if (browser.equals("chrome") || browser.equals("opera")) {
            Configuration.browserCapabilities.setCapability(
                    "goog:chromeOptions", Map.of(
                            "args", List.of("--remote-debugging-port=9222")
                    )
            );
        }
        //add timeout
        Configuration.timeout = 5000;
    }

    @Test
    public void searchTest() {
        String searchingWord = "History";
        page.openPage()
                .textRequest(searchingWord)
                .search();
        assertEquals(page.getHeadingText(), searchingWord);
    }
}
