package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{
    private WebElement inputLogin = driver.findElement(By.id("prependedInput"));
    private WebElement inputPassword = driver.findElement(By.id("prependedInput2"));
    private WebElement submitButton = driver.findElement(By.id("_submit"));

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public HomePage login (String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        submitButton.click();
        return new HomePage(driver);
    }

}
