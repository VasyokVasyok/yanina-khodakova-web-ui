package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Класс Start.java
 *
 * Содержит тест-кейс "Create Contact Person"
 *
 * */

public class Start {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String STUDENT_LOGIN = "Applanatest";
    private static final String STUDENT_PASSWORD = "Student2020!";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //разворот окна браузера на весь экран
        driver.get(LOGIN_PAGE_URL);

        driver.findElement(By.cssSelector("input[id='prependedInput']")).sendKeys(STUDENT_LOGIN);
        driver.findElement(By.id("prependedInput2")).sendKeys(STUDENT_PASSWORD);
        driver.findElement(By.xpath("//button[@name='_submit']")).click();

        Actions action = new Actions(driver);
        WebElement buttonContrag = driver.findElement(By.xpath(".//a[@class='unclickable']/span[text()='Контрагенты']"));
        action.moveToElement(buttonContrag).build().perform();
        driver.findElement(By.xpath(".//a[@href='/contact/']/span")).click();

        WebDriverWait waitFiveSec = new WebDriverWait(driver, 5);
        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@title='Создать контактное лицо']")));
        driver.findElement(By.xpath(".//a[@title='Создать контактное лицо']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//input[@name='crm_contact[lastName]']")));
        driver.findElement(By.xpath(".//input[@name='crm_contact[lastName]']")).sendKeys("ЯнинаХОдакова");
        driver.findElement(By.xpath(".//input[@name='crm_contact[firstName]']")).sendKeys("Василиса");

        driver.findElement(By.xpath(".//span[@class='select2-chosen']")).click();
        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//ul[@class='select2-results']/li/div[text()='1234']")));
        driver.findElement(By.xpath(".//ul[@class='select2-results']/li/div[text()='1234']")).click();

        driver.findElement(By.xpath(".//input[@name='crm_contact[jobTitle]']")).sendKeys("QA engineer");

        driver.findElement(By.xpath(".//button[@class='btn btn-success action-button']")).click();
        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='btn dropdown-toggle ']")));
        driver.findElement(By.xpath(".//button[@class='btn dropdown-toggle ']")).click();
        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@class='btn-group open']/ul/li/a[@data-size='100']")));
        driver.findElement(By.xpath(".//div[@class='btn-group open']/ul/li/a[@data-size='100']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='btn dropdown-toggle ']")));

        driver.findElement(By.xpath(".//a[@class='grid-header-cell__link']/span[text()='Создан в']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='btn dropdown-toggle ']")));
        driver.findElement(By.xpath(".//a[@class='grid-header-cell__link']/span[text()='Создан в']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='btn dropdown-toggle ']")));
        driver.findElement(By.xpath(".//td[text()=\"ЯнинаХОдакова Василиса\"]"));

        driver.quit(); //закрыть браузер
    }
}
