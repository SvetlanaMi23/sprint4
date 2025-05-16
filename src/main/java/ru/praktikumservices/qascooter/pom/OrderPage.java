package ru.praktikumservices.qascooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends BasePage {

    // Первая форма
    private static final By FIRST_NAME_INPUT = By.xpath("//input[@placeholder='* Имя']");
    private static final By LAST_NAME_INPUT = By.xpath("//input[@placeholder='* Фамилия']");
    private static final By ADDRESS_INPUT = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private static final By METRO_INPUT = By.className("select-search__input");
    private static final By PHONE_INPUT = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By NEXT_BUTTON = By.xpath("//button[text()='Далее']");


    // Вторая форма
    private static final By DATE_INPUT = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private static final By RENTAL_PERIOD_DROPDOWN = By.className("Dropdown-control");
    private static final By COMMENT_INPUT = By.xpath("//input[@placeholder='Комментарий для курьера']");

    private static final String BLACK_COLOR = "black";
    private static final By BLACK_COLOR_CHECKBOX = By.id(BLACK_COLOR);
    private static final String GREY_COLOR = "grey";
    private static final By GREY_COLOR_CHECKBOX = By.id(GREY_COLOR);
    private static final By ORDER_SUBMIT_BUTTON = By.xpath("(//button[text()='Заказать'])[last()]");
    private static final By CONFIRM_BUTTON = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Да']");
    private static final By ORDER_SUCCESS_HEADER = By.className("Order_ModalHeader__3FDaJ");
    private static final String RENT_PERIOD_XPATH = "//div[@class='Dropdown-option' and text()='%s']";

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    //Методы первой формы
    //метод заполняет поле Имя
    public void setFirstName(String name) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(name);
    }

    //метод заполняет поле Фамилия
    public void setLastName(String name) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(name);
    }

    //метод заполняет поле Адресс
    public void setAddress(String address) {
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
    }

    //метод заполняет поле Метро
    public void setMetro(String metro) {
        WebElement metroField = driver.findElement(METRO_INPUT);
        metroField.sendKeys(metro);  // Вводим название станции (если это требуется)
        metroField.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    //метод заполняет поле Телефон
    public void setPhone(String phone) {
        driver.findElement(PHONE_INPUT).sendKeys(phone);
    }

    //метод находит кнопку "Далее"
    public void clickNext() {
        driver.findElement(NEXT_BUTTON).click();
    }

    //метод кликает по кнопке "Далее" после заполнения всех полей
    public void fillStepOneForm(String firstName, String lastName, String address, String metro, String phone) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setMetro(metro);
        setPhone(phone);
        clickNext();
    }

    // Методы второй формы
    // Поле Дата
    private void setDate(String date) {
        driver.findElement(DATE_INPUT).sendKeys(date); // Находим и заполняем поле Дата
        driver.findElement(DATE_INPUT).sendKeys(Keys.ENTER); // Находим и кликаем Enter
    }

    // Поле Период аренды
    private void setRentalPeriod(String rentalPeriod) {
        driver.findElement(RENTAL_PERIOD_DROPDOWN).click(); // Находим поле с выпадающим списком Периода аренды
        driver.findElement(By.xpath(String.format(RENT_PERIOD_XPATH, rentalPeriod))).click(); // Выбираем из выпадающего списка период и нажимаем
    }

    // Поле Цвет
    private void setColor(String color) {
        if (color.equalsIgnoreCase(BLACK_COLOR) || color.equalsIgnoreCase("both")) {
            driver.findElement(BLACK_COLOR_CHECKBOX).click();
        }
        if (color.equalsIgnoreCase(GREY_COLOR) || color.equalsIgnoreCase("both")) {
            driver.findElement(GREY_COLOR_CHECKBOX).click();
        }
    }

    // Поле Комментарий
    private void setComment(String comment) {
        driver.findElement(COMMENT_INPUT).sendKeys(comment); // Находим и заполняем поле Комментарий
    }

    // Кнопка Заказать
    public void clickOrder() {
        driver.findElement(ORDER_SUBMIT_BUTTON).click(); // Находим нижнюю кнопку Заказать и кликаем на нее
    }

    //метод кликает по нижней кнопке Заказать после заполнения всех полей
    public void fillStepTwoForm(String date, String rentalPeriod, String color, String comment) {
        setDate(date);
        setRentalPeriod(rentalPeriod);
        setColor(color);
        setComment(comment);
        clickOrder();
    }

    //Метод подтверждения заказа
    // Находим кнопку Да и кликаем на нее
    public void confirmOrder() {
        driver.findElement(CONFIRM_BUTTON).click();
    }

    // Метод успешного оформления заказа
    // Находим надпись Заказ оформлен и сравниваем текст
    public boolean isOrderConfirmed() {
        return driver.findElement(ORDER_SUCCESS_HEADER).getText().contains("Заказ оформлен");
    }
}
