package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewContactPage extends BasePage {

    @FindBy(xpath = ".//a[@title='Создать контактное лицо']")
    private WebElement createContactButton;

    public NewContactPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewContactPage clickButtonCreateNewContact() {
        wait5Sec.until(ExpectedConditions.visibilityOf(createContactButton));
        createContactButton.click();
        return new CreateNewContactPage(driver);

    }

}
