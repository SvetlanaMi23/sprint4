package ru.praktikumservices.qascooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private static final By COOKIE_BUTTON = By.id("rcc-confirm-button");

    private final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAcceptCookieButton() {
        driver.findElement(COOKIE_BUTTON).click();
    }
}