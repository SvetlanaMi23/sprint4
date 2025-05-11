package org.example.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleWebTest {

    @Test
    public void testNonExistingOrderNotFound(){
        WebDriver driver = new ChromeDriver();
        //открываем главную страницу
        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(By.cssSelector(".Button_Button__ra12g")).click();

        //закрываем браузер
        driver.quit();
        }
    }

