package ru.praktikumservices.qascooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private final WebDriver driver;

    //Вопросы о важном
    private static final By importantQuestions = By.className("Home_FAQ__3uVm4");
    //Кнопка Заказать сверху страницы
    private static final By orderHeaderButtonClass1 = By.className("Header_Nav__AGCXC");
    private static final By orderHeaderButtonClass2 = By.className("Button_Button__ra12g");

    //Кнопка Заказать внизу страницы
    private static final By orderButtonClass = By.className("Home_FinishButton__1_cWm");

    private static final By orderButtonTag = By.tagName("button");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Скрол до раздела "Вопросы о важном"
    public void scrollDown() {
        WebElement element = driver.findElement(importantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickAccordionHeadingButton(String idHeading) {
        By accordionHeading = By.id(idHeading);
        driver.findElement(accordionHeading).click();
    }

    public String getAccordionPanelText(String idPanel) {
        By accordionPanel = By.id(idPanel);
        return driver.findElement(accordionPanel).getText();
    }

    // Кнопка "Заказать" вверху страницы
    public void clickHeaderOrderButton() {
        WebElement headerButton = driver.findElement(orderHeaderButtonClass1).findElement(orderHeaderButtonClass2);
        headerButton.click();
    }

    // Скрол до нижней кнопки "Заказать":
    public void scrollOderButtonDown() {
        WebElement element = driver.findElement(orderButtonClass).findElement(orderButtonTag);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Кнопка "Заказать" внизу страницы
    public void clickMainOrderButton() {
        WebElement mainButton = driver.findElement(orderButtonClass).findElement(orderButtonTag);
        mainButton.click();
    }
}
