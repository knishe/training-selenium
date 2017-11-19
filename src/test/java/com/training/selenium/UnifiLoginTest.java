package com.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Nishanthan Krishnakumar
 * @version 1.0
 */
public class UnifiLoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void someMethod(){
        System.setProperty("webdriver.chrome.driver","/Users/knishe/dev/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testFacebook() throws InterruptedException {
        driver.get("https://unifi.com.my/unifi-en/index.page");
        driver.findElement(By.xpath("//*[@id=\"btn_notice\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"webLoginBtn\"]/img")).click();

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"username\"]")));
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"subscribe\"]")).click();
    }

    @AfterMethod
    public void postAction(){
        driver.quit();
    }
}
