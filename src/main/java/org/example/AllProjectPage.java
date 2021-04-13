package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AllProjectPage extends BasePage {

    @FindBy(linkText = "Создать проект")
    WebElement butCreateNewProj;

    @FindBy(css = ".grid-header:nth-child(1) .grid-header-cell-createdAt .grid-header-cell__label")
    WebElement butSuccessCreate;

    @FindBy(xpath = ".//button[@class='btn dropdown-toggle ']")
    WebElement comboBoxNumberOfElements;

    @FindBy(xpath = "//a[text()=100]")
    WebElement option1HundredElement;

    @FindBy(xpath = ".//div[@class='grid-container']/table/tbody/tr/td[text()='ninochka1234567']")
    WebElement resultOfCreatingProj;


    public AllProjectPage(WebDriver driver) {
        super(driver);
    }

    public CreateNewProjPage redirectToCreatingProjPage() {
        wait5Sec.until(ExpectedConditions.visibilityOf(butCreateNewProj));
        butCreateNewProj.click();
        return new CreateNewProjPage(driver);
    }

    public void checkSavingResult (String nameProj) {
        wait5Sec.until(ExpectedConditions.visibilityOf(butSuccessCreate));
        butSuccessCreate.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(comboBoxNumberOfElements));
        comboBoxNumberOfElements.click();
        butSuccessCreate.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(comboBoxNumberOfElements));
        comboBoxNumberOfElements.click();
        wait5Sec.until(ExpectedConditions.visibilityOf(option1HundredElement));
        option1HundredElement.click();
        String name = resultOfCreatingProj.getText();
        assertTrue(name.contains(nameProj));
    }
}
