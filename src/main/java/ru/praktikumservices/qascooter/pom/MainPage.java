package ru.praktikumservices.qascooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikumservices.qascooter.ui.HasTextCondition;

import java.time.Duration;


public class MainPage extends BasePage {

    //Время ожидания текста в оккардионе
    private static final long textWaitTime = 1000;
    //Вопросы о важном
    private static final By importantQuestions = By.className("Home_FAQ__3uVm4");
    //Кнопка Заказать сверху страницы
    private static final By orderHeaderButtonFirstClass = By.className("Header_Nav__AGCXC");
    private static final By orderHeaderButtonSecondClass = By.className("Button_Button__ra12g");

    //Кнопка Заказать внизу страницы
    private static final By orderButtonClass = By.className("Home_FinishButton__1_cWm");
    private static final By orderButtonTag = By.tagName("button");
    // Аккордион кнопки с вопросами
    private static final By accHeadingMoney = By.id("accordion__heading-0");
    private static final By accHeadingSeveral = By.id("accordion__heading-1");
    private static final By accHeadingTime = By.id("accordion__heading-2");
    private static final By accHeadingToday = By.id("accordion__heading-3");
    private static final By accHeadingExtend = By.id("accordion__heading-4");
    private static final By accHeadingCharge = By.id("accordion__heading-5");
    private static final By accHeadingCancel = By.id("accordion__heading-6");
    private static final By accHeadingMkad = By.id("accordion__heading-7");

    // Аккордион панели с ответами
    private static final By accPanelMoney = By.id("accordion__panel-0");
    private static final By accPanelSeveral = By.id("accordion__panel-1");
    private static final By accPanelTime = By.id("accordion__panel-2");
    private static final By accPanelToday = By.id("accordion__panel-3");
    private static final By accPanelExtend = By.id("accordion__panel-4");
    private static final By accPanelCharge = By.id("accordion__panel-5");
    private static final By accPanelCancel = By.id("accordion__panel-6");
    private static final By accPanelMkad = By.id("accordion__panel-7");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Скрол до раздела "Вопросы о важном"
    public void scrollDown() {
        WebElement element = driver.findElement(importantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Клик по вопросу по первому заголовку
    public void clickAccordionHeadingMoneyButton() {
        driver.findElement(accHeadingMoney).click();
    }

    // Получение текста ответа по первой панеле
    public String getAccordionPanelMoneyText() {
        return driver.findElement(accPanelMoney).getText();
    }

    // Получение ответа на вопрос по первой панеле
    public String getAccordionMoneyAnswer() {
        clickAccordionHeadingMoneyButton();
        waitText(accPanelMoney);
        return getAccordionPanelMoneyText();
    }

    // Клик по вопросу по второму заголовку
    public void clickAccordionHeadingSeveralButton() {
        driver.findElement(accHeadingSeveral).click();
    }

    // Получение текста ответа по второй панеле
    public String getAccordionPanelSeveralText() {
        return driver.findElement(accPanelSeveral).getText();
    }

    // Получение ответа на вопрос по второй панеле
    public String getAccordionSeveralAnswer() {
        clickAccordionHeadingSeveralButton();
        waitText(accPanelSeveral);
        return getAccordionPanelSeveralText();
    }

    // Клик по вопросу по третьему заголовку
    public void clickAccordionHeadingTimeButton() {
        driver.findElement(accHeadingTime).click();
    }

    // Получение текста ответа по третьей панеле
    public String getAccordionPanelTimeText() {
        return driver.findElement(accPanelTime).getText();
    }

    // Получение ответа на вопрос по третьей панеле
    public String getAccordionTimeAnswer() {
        clickAccordionHeadingTimeButton();
        waitText(accPanelTime);
        return getAccordionPanelTimeText();
    }

    // Клик по вопросу по четвертому заголовку
    public void clickAccordionHeadingTodayButton() {
        driver.findElement(accHeadingToday).click();
    }

    // Получение текста ответа по четвертой панеле
    public String getAccordionPanelTodayText() {
        return driver.findElement(accPanelToday).getText();
    }

    // Получение ответа на вопрос по четвертой панеле
    public String getAccordionTodayAnswer() {
        clickAccordionHeadingTodayButton();
        waitText(accPanelToday);
        return getAccordionPanelTodayText();
    }

    // Клик по вопросу по пятому заголовку
    public void clickAccordionHeadingExtendButton() {
        driver.findElement(accHeadingExtend).click();
    }

    // Получение текста ответа по пятой панеле
    public String getAccordionPanelExtendText() {
        return driver.findElement(accPanelExtend).getText();
    }

    // Получение ответа на вопрос по пятой панеле
    public String getAccordionExtendAnswer() {
        clickAccordionHeadingExtendButton();
        waitText(accPanelExtend);
        return getAccordionPanelExtendText();
    }

    // Клик по вопросу по шестому заголовку
    public void clickAccordionHeadingChargeButton() {
        driver.findElement(accHeadingCharge).click();
    }

    // Получение текста ответа по шестой панеле
    public String getAccordionPanelChargeText() {
        return driver.findElement(accPanelCharge).getText();
    }

    // Получение ответа на вопрос по шестой панеле
    public String getAccordionChargeAnswer() {
        clickAccordionHeadingChargeButton();
        waitText(accPanelCharge);
        return getAccordionPanelChargeText();
    }


    // Клик по вопросу по седьмому заголовку
    public void clickAccordionHeadingCancelButton() {
        driver.findElement(accHeadingCancel).click();
    }

    // Получение текста ответа по седьмой панеле
    public String getAccordionPanelCancelText() {
        return driver.findElement(accPanelCancel).getText();
    }

    // Получение ответа на вопрос по седьмой панеле
    public String getAccordionCancelAnswer() {
        clickAccordionHeadingCancelButton();
        waitText(accPanelCancel);
        return getAccordionPanelCancelText();
    }

    // Клик по вопросу по восьмому заголовку
    public void clickAccordionHeadingMkadButton() {
        driver.findElement(accHeadingMkad).click();
    }

    // Получение текста ответа по восьмой панеле
    public String getAccordionPanelMkadText() {
        return driver.findElement(accPanelMkad).getText();
    }

    // Получение ответа на вопрос по восьмой панеле
    public String getAccordionMkadAnswer() {
        clickAccordionHeadingMkadButton();
        waitText(accPanelMkad);
        return getAccordionPanelMkadText();
    }


    // Кнопка "Заказать" вверху страницы
    public void clickHeaderOrderButton() {
        WebElement headerButton = driver.findElement(orderHeaderButtonFirstClass).findElement(orderHeaderButtonSecondClass);
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

    //Ожидание появления текста в элементе
    private void waitText(By locator) {
        new WebDriverWait(driver, Duration.ofMillis(textWaitTime)).until(new HasTextCondition(locator));
    }
}
