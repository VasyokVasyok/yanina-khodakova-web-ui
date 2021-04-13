package org.example;

import org.example.utils.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    WebElement contragB = driver.findElement(By.xpath(".//a[@class='unclickable']/span[text()='Контрагенты']"));
    WebElement contactB = driver.findElement(By.xpath(".//a[@href='/contact/']/span"));

    WebElement projB = driver.findElement(By.xpath(".//span[text()='Проекты']"));
    WebElement allProjB = driver.findElement(By.xpath(".//span[text()='Все проекты']"));


    public NewContactPage redirectToNewContactPage() {
        Action.moveCursorToNavigationTab(contragB, driver);
        contactB.click();
        return new NewContactPage(driver);
    }

    public AllProjectPage redirectToAllProjectPage() {
        Action.moveCursorToNavigationTab(projB, driver);
        allProjB.click();
        return new AllProjectPage(driver);
    }

}