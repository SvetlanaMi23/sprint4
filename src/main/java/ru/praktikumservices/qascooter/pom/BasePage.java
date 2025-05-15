package ru.praktikumservices.qascooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private final By cookieButton = By.id("rcc-confirm-button");

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAcceptCookieButton() {
        driver.findElement(cookieButton).click();
    }
}