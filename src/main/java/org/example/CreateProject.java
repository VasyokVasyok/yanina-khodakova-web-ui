package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Класс Start.java
 *
 * Содержит тест-кейс "Create Contact Person"
 *
 * */

public class CreateProject {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";

    public static void main (String [] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOGIN_PAGE_URL);

        driver.findElement(By.cssSelector("input[id='prependedInput']")).sendKeys(STUDENT_LOGIN);
        driver.findElement(By.id("prependedInput2")).sendKeys(STUDENT_PASSWORD);
        driver.findElement(By.xpath("//button[@name='_submit']")).click();

        WebDriverWait waitFiveSec = new WebDriverWait(driver, 5);

        Actions actions = new Actions(driver);
        WebElement buttonProj = driver.findElement(By.xpath(".//span[text()='Проекты']"));
        actions.moveToElement(buttonProj).build().perform();
        driver.findElement(By.xpath(".//span[text()='Все проекты']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Создать проект")));
        driver.findElement(By.linkText("Создать проект")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h5/span[text()='Основная информация']")));
        driver.findElement(By.xpath(".//input[@data-name='field__name']")).click();
        driver.findElement(By.xpath(".//input[@data-name='field__name']")).sendKeys("hodakova1");

        driver.findElement(By.xpath(".//span[text()='Укажите организацию']")).click();
        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//li[@class='select2-results-dept-0 select2-result select2-result-selectable']/div[text()='1234']")));
        driver.findElement(By.xpath(".//li[@class='select2-results-dept-0 select2-result select2-result-selectable']/div[text()='1234']")).click();

        Select butPod = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        butPod.selectByVisibleText("Research & Development");

        Select butCur = new Select(driver.findElement(By.name("crm_project[curator]")));
        butCur.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select butGr = new Select(driver.findElement(By.name("crm_project[rp]")));
        butGr.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select butAdm = new Select(driver.findElement(By.name("crm_project[administrator]")));
        butAdm.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select butMan = new Select(driver.findElement(By.name("crm_project[manager]")));
        butMan.selectByVisibleText("Applanatest Applanatest Applanatest");

        actions.moveToElement(driver.findElement(By.xpath(".//div[contains(@id, 'contactMain')]"))).build().perform();
        driver.findElement(By.xpath(".//div[contains(@id, 'contactMain')]")).click();
        driver.findElement(By.xpath(".//option[text()='A B']")).click();

        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".grid-header:nth-child(1) .grid-header-cell-createdAt .grid-header-cell__label")));
        driver.findElement(By.cssSelector(".grid-header:nth-child(1) .grid-header-cell-createdAt .grid-header-cell__label")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='btn dropdown-toggle ']")));
        driver.findElement(By.xpath(".//button[@class='btn dropdown-toggle ']")).click();
        driver.findElement(By.cssSelector(".grid-header:nth-child(1) .grid-header-cell-createdAt .grid-header-cell__label")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='btn dropdown-toggle ']")));
        driver.findElement(By.xpath(".//button[@class='btn dropdown-toggle ']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=100]")));
        driver.findElement(By.xpath("//a[text()=100]")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".//div[@class='grid-container']/table/tbody/tr/td[text()='nina123456789']")));
        driver.findElement(By.xpath(".//div[@class='grid-container']/table/tbody/tr/td[text()='hodakova1']"));

        driver.quit();
    }
}
