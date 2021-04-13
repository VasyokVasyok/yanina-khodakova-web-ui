package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllContactPage extends BasePage {

    @FindBy(xpath = ".//button[@class='btn dropdown-toggle ']")
    private WebElement numberOfVisiblyElements;

    @FindBy(xpath = ".//div[@class='btn-group open']/ul/li/a[@data-size='100']")
    private WebElement optionOneHundredVisiblyElements;

    @FindBy(xpath = ".//a[@class='grid-header-cell__link']/span[text()='Создан в']")
    private WebElement buttonCreated;

    @FindBy(xpath = ".//td[text()='ЯнинаХОДакова Василиса']")
    private WebElement savedContact;

    public AllContactPage(WebDriver driver) {
        super(driver);
    }

    public void checkSavingNewContact() {
        wait5Sec.until(ExpectedConditions.visibilityOf(numberOfVisiblyElements));
        numberOfVisiblyElements.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(optionOneHundredVisiblyElements));
        optionOneHundredVisiblyElements.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(numberOfVisiblyElements));
        buttonCreated.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(numberOfVisiblyElements));
        buttonCreated.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(numberOfVisiblyElements));
        String message = savedContact.getText();
        assertTrue(message.contains("ЯнинаХОДакова Василиса"));
    }
}
