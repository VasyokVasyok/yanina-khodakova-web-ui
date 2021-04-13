package org.example;

import org.example.utils.Action;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateNewProjPage extends BasePage {

    @FindBy(xpath = ".//h5/span[text()='Основная информация']")
    WebElement title;

    @FindBy(xpath = ".//input[@data-name='field__name']")
    WebElement inputNameProj;

    @FindBy(xpath = ".//span[text()='Укажите организацию']")
    WebElement comboBoxOrg;

    @FindBy(xpath = ".//li[@class='select2-results-dept-0 select2-result select2-result-selectable']/div[text()='1234']")
    WebElement optionComboBoxOrg;

    @FindBy(xpath = ".//select[@name='crm_project[businessUnit]']")
    WebElement selectPodr;
    @FindBy(xpath = ".//option[text()= 'Research & Development']")
    WebElement selectResPodr;

    @FindBy(name = "crm_project[curator]")
    WebElement selectCurator;
    @FindBy(xpath = ".//select[@name='crm_project[curator]']/option[text()= 'Applanatest Applanatest Applanatest']")
    WebElement selectResCurator;

    @FindBy(name = "crm_project[rp]")
    WebElement selectGr;
    @FindBy(xpath = ".//select[@name='crm_project[rp]']/option[text()= 'Applanatest Applanatest Applanatest']")
    WebElement selectResGr;

    @FindBy(name = "crm_project[administrator]")
    WebElement selectAdm;
    @FindBy(xpath = ".//select[@name='crm_project[administrator]']/option[text()= 'Applanatest Applanatest Applanatest']")
    WebElement selectResAdm;

    @FindBy(name = "crm_project[manager]")
    WebElement selectManager;
    @FindBy(xpath = ".//select[@name='crm_project[manager]']/option[text()= 'Applanatest Applanatest Applanatest']")
    WebElement selectResManager;

    @FindBy(xpath = ".//div[contains(@id, 'contactMain')]")
    WebElement contactMain;

    @FindBy(xpath = ".//option[text()='A B']")
    WebElement optionContactMain;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    WebElement buttonSubmit;

    public CreateNewProjPage(WebDriver driver) {
        super(driver);
    }

    public AllProjectPage enterDataOfProj(String nameProj) {
        wait5Sec.until(ExpectedConditions.visibilityOf(title));
        inputNameProj.click();
        inputNameProj.sendKeys(nameProj);
        comboBoxOrg.click();
        optionComboBoxOrg.click();

        selectPodr.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(selectResPodr));
        selectResPodr.click();

        selectCurator.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(selectResCurator));
        selectResCurator.click();

        selectGr.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(selectResGr));
        selectResGr.click();

        selectAdm.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(selectResAdm));
        selectResAdm.click();

        selectManager.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(selectResManager));
        selectResManager.click();

        Action.moveCursorToNavigationTab(contactMain, driver);
        contactMain.click();
        optionContactMain.click();
        buttonSubmit.click();
        return new AllProjectPage(driver);
    }
}
