package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utils.Action;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.example.common.Configuration.*;

/*
 * Класс LoginPageTest.java
 *
 * Содержит тест-кейс "Create Contact Person"
 * и тест-кейс "Create New Project".
 *
 * */

public class LoginPageTest extends BaseTest {


    @Test
    public void newContactTest() {
        new LoginPage(driver)
                .login(STUDENT_LOGIN, STUDENT_PASSWORD)
                .redirectToNewContactPage()
                .clickButtonCreateNewContact()
                .enteringContactInfo(LAST_NAME, FIRST_NAME, JOB)
                .checkSavingNewContact();
    }

    @Test
    public void newProjectTest() {
        new LoginPage(driver)
                .login(STUDENT_LOGIN, STUDENT_PASSWORD)
                .redirectToAllProjectPage()
                .redirectToCreatingProjPage()
                .enterDataOfProj(NAME_PROJ)
                .checkSavingResult(NAME_PROJ);
    }
}