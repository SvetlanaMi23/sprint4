package ru.praktikumservices.qascooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Скрол до раздела "Вопросы о важном"
    public void scrollDown() {
        WebElement element = driver.findElement(By.className("Home_FAQ__3uVm4"));
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
        WebElement headerButton = driver.findElement(By.className("Header_Nav__AGCXC")).findElement(By.className("Button_Button__ra12g"));
        headerButton.click();
    }

    // Скрол до нижней кнопки "Заказать":
    public void scrollOderButtonDown() {
        WebElement element = driver.findElement(By.className("Home_FinishButton__1_cWm")).findElement(By.tagName("button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Кнопка "Заказать" внизу страницы
    public void clickMainOrderButton() {
        WebElement mainButton = driver.findElement(By.className("Home_FinishButton__1_cWm")).findElement(By.tagName("button"));
        mainButton.click();
    }
}
