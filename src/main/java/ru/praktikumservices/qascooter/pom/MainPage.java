package ru.praktikumservices.qascooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikumservices.qascooter.ui.HasTextCondition;

import java.time.Duration;


public class MainPage extends BasePage {

    //Время ожидания текста в оккардионе
    private static final long TEXT_WAIT_TIME = 1000;
    private static final long CLICK_WAIT_TIME = 300;
    //Вопросы о важном
    private static final By IMPORTANT_QUESTIONS = By.className("Home_FAQ__3uVm4");
    //Кнопка Заказать сверху страницы
    private static final By ORDER_HEADER_BUTTON_FIRST_CLASS = By.className("Header_Nav__AGCXC");
    private static final By ORDER_HEADER_BUTTON_SECOND_CLASS = By.className("Button_Button__ra12g");

    //Кнопка Заказать внизу страницы
    private static final By ORDER_BUTTON_CLASS = By.className("Home_FinishButton__1_cWm");
    private static final By ORDER_BUTTON_TAG = By.tagName("button");
    // Аккордион кнопки с вопросами
    private static final By ACC_HEADING_MONEY = By.id("accordion__heading-0");
    private static final By ACC_HEADING_SEVERAL = By.id("accordion__heading-1");
    private static final By ACC_HEADING_TIME = By.id("accordion__heading-2");
    private static final By ACC_HEADING_TODAY = By.id("accordion__heading-3");
    private static final By ACC_HEADING_EXTEND = By.id("accordion__heading-4");
    private static final By ACC_HEADING_CHARGE = By.id("accordion__heading-5");
    private static final By ACC_HEADING_CANCEL = By.id("accordion__heading-6");
    private static final By ACC_HEADING_MKAD = By.id("accordion__heading-7");

    // Аккордион панели с ответами
    private static final By ACC_PANEL_MONEY = By.id("accordion__panel-0");
    private static final By ACC_PANEL_SEVERAL = By.id("accordion__panel-1");
    private static final By ACC_PANEL_TIME = By.id("accordion__panel-2");
    private static final By ACC_PANEL_TODAY = By.id("accordion__panel-3");
    private static final By ACC_PANEL_EXTEND = By.id("accordion__panel-4");
    private static final By ACC_PANEL_CHARGE = By.id("accordion__panel-5");
    private static final By ACC_PANEL_CANCEL = By.id("accordion__panel-6");
    private static final By ACC_PANEL_MKAD = By.id("accordion__panel-7");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Скрол до раздела "Вопросы о важном"
    public void scrollDown() {
        WebElement element = driver.findElement(IMPORTANT_QUESTIONS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Клик по вопросу по первому заголовку
    public void clickAccordionHeadingMoneyButton() {
        driver.findElement(ACC_HEADING_MONEY).click();
    }

    // Получение текста ответа по первой панеле
    public String getAccordionPanelMoneyText() {

        return driver.findElement(ACC_PANEL_MONEY).getText();
    }

    // Получение ответа на вопрос по первой панеле
    public String getAccordionMoneyAnswer() {
        waitBeforeClick(ACC_HEADING_MONEY);
        clickAccordionHeadingMoneyButton();
        waitText(ACC_PANEL_MONEY);
        return getAccordionPanelMoneyText();
    }

    // Клик по вопросу по второму заголовку
    public void clickAccordionHeadingSeveralButton() {
        driver.findElement(ACC_HEADING_SEVERAL).click();
    }

    // Получение текста ответа по второй панеле
    public String getAccordionPanelSeveralText() {

        return driver.findElement(ACC_PANEL_SEVERAL).getText();
    }

    // Получение ответа на вопрос по второй панеле
    public String getAccordionSeveralAnswer() {
        waitBeforeClick(ACC_HEADING_SEVERAL);
        clickAccordionHeadingSeveralButton();
        waitText(ACC_PANEL_SEVERAL);
        return getAccordionPanelSeveralText();
    }

    // Клик по вопросу по третьему заголовку
    public void clickAccordionHeadingTimeButton() {
        driver.findElement(ACC_HEADING_TIME).click();
    }

    // Получение текста ответа по третьей панеле
    public String getAccordionPanelTimeText() {
        return driver.findElement(ACC_PANEL_TIME).getText();
    }

    // Получение ответа на вопрос по третьей панеле
    public String getAccordionTimeAnswer() {
        waitBeforeClick(ACC_HEADING_TIME);
        clickAccordionHeadingTimeButton();
        waitText(ACC_PANEL_TIME);
        return getAccordionPanelTimeText();
    }

    // Клик по вопросу по четвертому заголовку
    public void clickAccordionHeadingTodayButton() {
        driver.findElement(ACC_HEADING_TODAY).click();
    }

    // Получение текста ответа по четвертой панеле
    public String getAccordionPanelTodayText() {
        return driver.findElement(ACC_PANEL_TODAY).getText();
    }

    // Получение ответа на вопрос по четвертой панеле
    public String getAccordionTodayAnswer() {
        waitBeforeClick(ACC_HEADING_TODAY);
        clickAccordionHeadingTodayButton();
        waitText(ACC_PANEL_TODAY);
        return getAccordionPanelTodayText();
    }

    // Клик по вопросу по пятому заголовку
    public void clickAccordionHeadingExtendButton() {
        driver.findElement(ACC_HEADING_EXTEND).click();
    }

    // Получение текста ответа по пятой панеле
    public String getAccordionPanelExtendText() {
        return driver.findElement(ACC_PANEL_EXTEND).getText();
    }

    // Получение ответа на вопрос по пятой панеле
    public String getAccordionExtendAnswer() {
        waitBeforeClick(ACC_HEADING_EXTEND);
        clickAccordionHeadingExtendButton();
        waitText(ACC_PANEL_EXTEND);
        return getAccordionPanelExtendText();
    }

    // Клик по вопросу по шестому заголовку
    public void clickAccordionHeadingChargeButton() {
        driver.findElement(ACC_HEADING_CHARGE).click();
    }

    // Получение текста ответа по шестой панеле
    public String getAccordionPanelChargeText() {
        return driver.findElement(ACC_PANEL_CHARGE).getText();
    }

    // Получение ответа на вопрос по шестой панеле
    public String getAccordionChargeAnswer() {
        waitBeforeClick(ACC_HEADING_CHARGE);
        clickAccordionHeadingChargeButton();
        waitText(ACC_PANEL_CHARGE);
        return getAccordionPanelChargeText();
    }


    // Клик по вопросу по седьмому заголовку
    public void clickAccordionHeadingCancelButton() {
        driver.findElement(ACC_HEADING_CANCEL).click();
    }

    // Получение текста ответа по седьмой панеле
    public String getAccordionPanelCancelText() {
        return driver.findElement(ACC_PANEL_CANCEL).getText();
    }

    // Получение ответа на вопрос по седьмой панеле
    public String getAccordionCancelAnswer() {
        waitBeforeClick(ACC_HEADING_CANCEL);
        clickAccordionHeadingCancelButton();
        waitText(ACC_PANEL_CANCEL);
        return getAccordionPanelCancelText();
    }

    // Клик по вопросу по восьмому заголовку
    public void clickAccordionHeadingMkadButton() {
        driver.findElement(ACC_HEADING_MKAD).click();
    }

    // Получение текста ответа по восьмой панеле
    public String getAccordionPanelMkadText() {
        return driver.findElement(ACC_PANEL_MKAD).getText();
    }

    // Получение ответа на вопрос по восьмой панеле
    public String getAccordionMkadAnswer() {
        waitBeforeClick(ACC_HEADING_MKAD);
        clickAccordionHeadingMkadButton();
        waitText(ACC_PANEL_MKAD);
        return getAccordionPanelMkadText();
    }

    // Кнопка "Заказать" вверху страницы
    public void clickHeaderOrderButton() {
        WebElement headerButton = driver.findElement(ORDER_HEADER_BUTTON_FIRST_CLASS).findElement(ORDER_HEADER_BUTTON_SECOND_CLASS);
        headerButton.click();
    }

    // Скрол до нижней кнопки "Заказать":
    public void scrollOderButtonDown() {
        WebElement element = driver.findElement(ORDER_BUTTON_CLASS).findElement(ORDER_BUTTON_TAG);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Кнопка "Заказать" внизу страницы
    public void clickMainOrderButton() {
        WebElement mainButton = driver.findElement(ORDER_BUTTON_CLASS).findElement(ORDER_BUTTON_TAG);
        new WebDriverWait(driver, Duration.ofMillis(CLICK_WAIT_TIME)).until(ExpectedConditions.elementToBeClickable(mainButton));
        mainButton.click();
    }

    //Ожидание появления возможности сделать клик по кнопке в элементе
    private void waitBeforeClick(By locator) {
        new WebDriverWait(driver, Duration.ofMillis(CLICK_WAIT_TIME)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Ожидание появления текста в элементе
    private void waitText(By locator) {
        new WebDriverWait(driver, Duration.ofMillis(TEXT_WAIT_TIME)).until(new HasTextCondition(locator));
    }
}
