package com.seleniumdesign.factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleEnglish extends GooglePage{



    @FindBy(name="q")
    private WebElement searchBox;

    @FindBy(css = "style + center > input[name=btnK]")
    private WebElement searchBtn;


    @FindBy(css="div.rc")
    private List<WebElement> results;


    public GoogleEnglish(final WebDriver driver){
        super(driver);
    }


    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com");
    }

    @Override
    public void search(String keyword) {
        for(char ch : keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch+"");
        }
        this.wait.until((d) -> this.searchBtn.isDisplayed());
        this.searchBtn.click();
    }

    @Override
    public int getResultCount() {
        this.wait.until((d) -> this.results.size() > 1);
        return this.results.size();
    }
}
