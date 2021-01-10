package ru.imatveev;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.name;

public class WikiPage {
    private final SelenideElement searchField = $(name("search"));
    private final SelenideElement button = $(".pure-button.pure-button-primary-progressive");
    private final SelenideElement heading = $(id("firstHeading"));

    public WikiPage openPage() {
        open("");
        return this;
    }

    public WikiPage textRequest(String request) {
        searchField.setValue(request);
        return this;
    }

    public WikiPage search() {
        button.click();
        return this;
    }

    public String getHeadingText() {
        return heading.getText();
    }

}
