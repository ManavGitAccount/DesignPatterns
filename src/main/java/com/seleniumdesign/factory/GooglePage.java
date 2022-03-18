package com.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class GooglePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public GooglePage(final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
    public abstract void launchSite();
    public abstract void search(String keyword);
    public abstract int getResultCount();
}
