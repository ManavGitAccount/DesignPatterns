package com.seleniumdesign.test.executeAround;

import com.seleniumdesign.executearoundmethod.MainPage;
import com.seleniumdesign.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage(){
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest(){
        this.mainPage.goTo();

        this.mainPage.onFrameA(a -> a.setFirstName("fn1"));
        this.mainPage.onFrameB(b -> b.setFirstName("fn2"));
        this.mainPage.onFrameA(a -> a.setLastName("fn3"));

    }
}
