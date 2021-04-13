package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.XMLFormatter;

public class CreateNewContactPage extends BasePage {

    @FindBy(xpath = ".//input[@name='crm_contact[lastName]']")
    private WebElement inputLastName;

    @FindBy(xpath = ".//input[@name='crm_contact[firstName]']")
    private WebElement inputFirstName;

    @FindBy(xpath = ".//span[@class='select2-chosen']")
    private WebElement comboBoxOrg;

    @FindBy(xpath = ".//ul[@class='select2-results']/li/div[text()='1234']")
    private WebElement resOfComboBoxOrg;

    @FindBy(xpath = ".//input[@name='crm_contact[jobTitle]']")
    private WebElement inputJob;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement buttonSuccess;

    public CreateNewContactPage(WebDriver driver) {
        super(driver);
    }

    public AllContactPage enteringContactInfo(String lastN, String firstN, String job) {
        wait5Sec.until(ExpectedConditions.visibilityOf(inputLastName));
        inputLastName.sendKeys(lastN);
        inputFirstName.sendKeys(firstN);
        comboBoxOrg.click();

        wait30Sec.until(ExpectedConditions.visibilityOf(resOfComboBoxOrg));
        resOfComboBoxOrg.click();
        inputJob.sendKeys(job);
        buttonSuccess.click();
        return new AllContactPage(driver);
    }
}
