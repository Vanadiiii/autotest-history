package ru.imatveev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class WikiPage {
    private final WebDriver driver;

    public WikiPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    private final By searchField = name("search");
    private final By button = cssSelector(".pure-button.pure-button-primary-progressive");
    private final By heading = id("firstHeading");

    public WikiPage textRequest(String request) {
        driver.findElement(searchField).sendKeys(request);
        return this;
    }

    public WikiPage search() {
        driver.findElement(button).click();
        return this;
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

}
