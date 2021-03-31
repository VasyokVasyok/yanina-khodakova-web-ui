package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Класс Start.java
 *
 * Содержит тест-кейс "CheckIn"
 *
 * */

public class CheckIn {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://loverepublic.ru/";
    private static final String LOGIN = "vasyokvasyok333@yandex.ru";
    private static final String PASSWORD = "QwertyQwerty12345";

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOGIN_PAGE_URL);

        driver.findElement(By.xpath(".//a[@id='dialog-auth-top-link']")).click();
        driver.findElement(By.xpath("//a[@class='btn width-100 end dialog-link dialog-register-link']")).click();
        driver.findElement(By.id("REGISTER_EMAIL")).sendKeys(LOGIN);

        driver.findElement(By.id("REGISTER_PASSWORD")).click();
        driver.findElement(By.id("REGISTER_PASSWORD")).sendKeys(PASSWORD);

        driver.findElement(By.id("REGISTER_CONFIRM_PASSWORD")).click();
        driver.findElement(By.id("REGISTER_CONFIRM_PASSWORD")).sendKeys(PASSWORD);

        driver.findElement(By.cssSelector(".block:nth-child(5) > label")).click();

        driver.findElement(By.cssSelector("#dialog-register-form > .block:nth-child(6) > label")).click();

        driver.findElement(By.name("register_submit_button")).click();

        driver.findElement(By.cssSelector(".logout-link"));

        driver.quit();
    }
}
