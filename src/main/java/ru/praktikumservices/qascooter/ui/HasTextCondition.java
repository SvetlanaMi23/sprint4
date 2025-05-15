package ru.praktikumservices.qascooter.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class HasTextCondition implements ExpectedCondition<Boolean> {

    private final By locator;

    public HasTextCondition(By locator) {
        this.locator = locator;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            return !driver.findElement(locator).getText().isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("element found by %s to have text \"%s\".", locator);
    }
}
