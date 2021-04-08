package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLoveRep {

    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://loverepublic.ru/";
    private static final String LOGIN = "vasyokvasyok333@yandex.ru";
    private static final String PASSWORD = "QwertyQwerty12345";

    @Test
    public void searchingProductTest() {
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

    @Test
    public void checkAddingClothesInBasketTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOGIN_PAGE_URL);
        WebDriverWait waitFiveSec = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath(".//a[@id='dialog-auth-top-link']")).click();
        driver.findElement(By.xpath(".//input[@id='USER_LOGIN']")).sendKeys(LOGIN);
        driver.findElement(By.xpath(".//input[@id='USER_PASSWORD']")).sendKeys(PASSWORD);
        driver.findElement(By.xpath(".//button[@id='top-auth-form-submit']")).click();

        driver.findElement(By.xpath(".//div[@class='header__search']/div[@class='header__search-icon js-show-hide-search']")).click();

        driver.findElement(By.xpath(".//input[@class='input-text']")).sendKeys("1152059350-1");
        driver.findElement(By.xpath(".//input[@class='input-text']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(".//img[@src='https://imgcdn.loverepublic.ru/upload/images/11520/thumb/375_9999/1152059350_1.jpg']")).click();
        driver.findElement(By.xpath(".//span[text()='1152059350-1']"));

        Actions action = new Actions(driver);
        WebElement b = driver.findElement(By.xpath(".//li/label/input[@id='offer-198209']/parent::label"));
        action.moveToElement(b).build().perform();

        driver.findElement(By.xpath(".//li/label/input[@id='offer-198209']/parent::label")).click();
        driver.findElement(By.xpath(".//div[@class='block units-row']/div[@class='unit-50']/button[text()='В корзину']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dialog-info']")));
        driver.findElement(By.xpath(".//a[text()='Оформить заказ']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h2[text()='Проверьте состав заказа']")));
        driver.findElement(By.xpath(".//td[text()='1152059350']"));

        driver.quit();
    }

    @Test
    public void checkINTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOGIN_PAGE_URL);

        driver.findElement(By.xpath(".//a[@id='dialog-auth-top-link']")).click();
        driver.findElement(By.xpath("//a[@class='btn width-100 end dialog-link dialog-register-link']")).click();
        driver.findElement(By.id("REGISTER_EMAIL")).sendKeys("yanina-hodakova@tm-serv.com");

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

    @Test
    public void changeNameTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(LOGIN_PAGE_URL);
        WebDriverWait waitFiveSec = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath(".//a[@id='dialog-auth-top-link']")).click();
        driver.findElement(By.xpath(".//input[@id='USER_LOGIN']")).sendKeys(LOGIN);
        driver.findElement(By.xpath(".//input[@id='USER_PASSWORD']")).sendKeys(PASSWORD);
        driver.findElement(By.xpath(".//button[@id='top-auth-form-submit']")).click();

        Actions action = new Actions(driver);
        WebElement b = driver.findElement(By.xpath(".//a[text()='Мой профиль']"));
        action.moveToElement(b).build().perform();

        driver.findElement(By.xpath(".//a[text()='Мой профиль']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//h1[text()='Мой профиль']")));
        driver.findElement(By.xpath(".//input[@id='NAME']")).clear();
        driver.findElement(By.xpath(".//input[@id='NAME']")).sendKeys("Васёк");
        driver.findElement(By.xpath(".//input[@id='LAST_NAME']")).clear();
        driver.findElement(By.xpath(".//input[@id='LAST_NAME']")).sendKeys("Васек");
        driver.findElement(By.xpath(".//button[@name='save']")).click();

        waitFiveSec.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//font[text()='Изменения сохранены']")));
        driver.findElement(By.xpath(".//font[text()='Изменения сохранены']"));

        driver.quit();
    }
}
