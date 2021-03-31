package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Класс Start.java
 *
 * Содержит тест-кейс "Search Product"
 *
 * */

public class SearchingProduct {

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
        driver.findElement(By.xpath(".//input[@id='USER_LOGIN']")).sendKeys(LOGIN);
        driver.findElement(By.xpath(".//input[@id='USER_PASSWORD']")).sendKeys(PASSWORD);
        driver.findElement(By.xpath(".//button[@id='top-auth-form-submit']")).click();

        driver.findElement(By.xpath(".//div[@class='header__search']/div[@class='header__search-icon js-show-hide-search']")).click();

        driver.findElement(By.xpath(".//input[@class='input-text']")).sendKeys("1152059350-1");
        driver.findElement(By.xpath(".//input[@class='input-text']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(".//img[@src='https://imgcdn.loverepublic.ru/upload/images/11520/thumb/375_9999/1152059350_1.jpg']")).click();
        driver.findElement(By.xpath(".//span[text()='1152059350-1']"));

        driver.quit();
    }
}
