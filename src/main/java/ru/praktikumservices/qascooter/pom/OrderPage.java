package ru.praktikumservices.qascooter.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

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
    private final By blackColorCheckbox = By.id("black");
    private final By greyColorCheckbox = By.id("grey");
    private final By orderSubmitButton = By.xpath("(//button[text()='Заказать'])[last()]");
    private final By confirmButton = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Да']");

    private final By orderSuccessHeader = By.className("Order_ModalHeader__3FDaJ");


    //Методы первой формы
    public void fillStepOneForm(String firstName, String lastName, String address, String metro, String phone) {
        driver.findElement(firstNameInput).sendKeys(firstName); // Находим и заполняем поле Имя
        driver.findElement(lastNameInput).sendKeys(lastName); // Находим и заполняем поле Фамилия
        driver.findElement(addressInput).sendKeys(address); // Находим и заполняем поле Адрес
        // Поле Метро
        WebElement metroField = driver.findElement(metroInput);
        metroField.click();  // Кликаем по полю, чтобы открыть выпадающий список
        metroField.sendKeys(metro);  // Вводим название станции (если это требуется)
        metroField.sendKeys(Keys.DOWN, Keys.ENTER);  // Выбираем нужный элемент из списка

        driver.findElement(phoneInput).sendKeys(phone);// Находим и заполняем поле Телефон
        driver.findElement(nextButton).click();
    }

    // Методы второй формы
    public void fillStepTwoForm(String date, String rentalPeriod, String color, String comment) throws InterruptedException {
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(dateInput).sendKeys(Keys.ENTER);

        driver.findElement(rentalPeriodDropdown).click();
        driver.findElement(By.xpath(String.format("//div[@class='Dropdown-option' and text()='%s']", rentalPeriod))).click();

        if (color.equalsIgnoreCase("black") || color.equalsIgnoreCase("both")) {
            driver.findElement(blackColorCheckbox).click();
        }
        if (color.equalsIgnoreCase("grey") || color.equalsIgnoreCase("both")) {
            driver.findElement(greyColorCheckbox).click();
        }

        driver.findElement(commentInput).sendKeys(comment);
        driver.findElement(orderSubmitButton).click();
    }

    //Метод подтверждения заказа
    public void confirmOrder() {
        driver.findElement(confirmButton).click();
    }

    // Метод успешного оформления заказа
    public boolean isOrderConfirmed() {
        return driver.findElement(orderSuccessHeader).getText().contains("Заказ оформлен");
    }
}
