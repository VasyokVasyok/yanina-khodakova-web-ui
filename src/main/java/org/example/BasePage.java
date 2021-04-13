package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait5Sec;
    protected WebDriverWait wait30Sec;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait5Sec = new WebDriverWait(driver, 5);
        this.wait30Sec = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
}
