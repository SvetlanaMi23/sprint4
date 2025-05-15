package ru.praktikumservices.qascooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends BasePage {

    // Первая форма
    private final By firstNameInput = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameInput = By.xpath("//input[@placeholder='* Фамилия']");
    private final By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroInput = By.className("select-search__input");
    private final By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath("//button[text()='Далее']");


    // Вторая форма
    private final By dateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By rentalPeriodDropdown = By.className("Dropdown-control");
    private final By commentInput = By.xpath("//input[@placeholder='Комментарий для курьера']");

    private final String blackColor = "black";
    private final By blackColorCheckbox = By.id(blackColor);
    private final String greyColor = "grey";
    private final By greyColorCheckbox = By.id(greyColor);
    private final By orderSubmitButton = By.xpath("(//button[text()='Заказать'])[last()]");
    private final By confirmButton = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Да']");
    private final By orderSuccessHeader = By.className("Order_ModalHeader__3FDaJ");
    private final String rentPeriodXpath = "//div[@class='Dropdown-option' and text()='%s']";

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    //Методы первой формы
    //метод заполняет поле Имя
    public void setFirstName(String name) {
        driver.findElement(firstNameInput).sendKeys(name);
    }

    //метод заполняет поле Фамилия
    public void setLastName(String name) {
        driver.findElement(lastNameInput).sendKeys(name);
    }

    //метод заполняет поле Адресс
    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    //метод заполняет поле Метро
    public void setMetro(String metro) {
        WebElement metroField = driver.findElement(metroInput);
        metroField.sendKeys(metro);  // Вводим название станции (если это требуется)
        metroField.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    //метод заполняет поле Телефон
    public void setPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    //метод находит кнопку "Далее"
    public void clickNext() {
        driver.findElement(nextButton).click();
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
        driver.findElement(dateInput).sendKeys(date); // Находим и заполняем поле Дата
        driver.findElement(dateInput).sendKeys(Keys.ENTER); // Находим и кликаем Enter
    }

    // Поле Период аренды
    private void setRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodDropdown).click(); // Находим поле с выпадающим списком Периода аренды
        driver.findElement(By.xpath(String.format(rentPeriodXpath, rentalPeriod))).click(); // Выбираем из выпадающего списка период и нажимаем
    }

    // Поле Цвет
    private void setColor(String color) {
        if (color.equalsIgnoreCase(blackColor) || color.equalsIgnoreCase("both")) {
            driver.findElement(blackColorCheckbox).click();
        }
        if (color.equalsIgnoreCase(greyColor) || color.equalsIgnoreCase("both")) {
            driver.findElement(greyColorCheckbox).click();
        }
    }

    // Поле Комментарий
    private void setComment(String comment) {
        driver.findElement(commentInput).sendKeys(comment); // Находим и заполняем поле Комментарий
    }

    // Кнопка Заказать
    public void clickOrder() {
        driver.findElement(orderSubmitButton).click(); // Находим нижнюю кнопку Заказать и кликаем на нее
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
        driver.findElement(confirmButton).click();
    }

    // Метод успешного оформления заказа
    // Находим надпись Заказ оформлен и сравниваем текст
    public boolean isOrderConfirmed() {
        return driver.findElement(orderSuccessHeader).getText().contains("Заказ оформлен");
    }
}
