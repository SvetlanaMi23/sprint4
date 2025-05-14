package ru.praktikumservices.qascooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.praktikumservices.qascooter.pom.MainPage;
import ru.praktikumservices.qascooter.pom.OrderPage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTest {

    private WebDriver driver;
    private String firstName;
    private String lastName;
    private String address;
    private String metro;
    private String phone;
    private String date;
    private String rentalPeriod;
    private String color;
    private String comment;

    // Конструктор для параметризированного теста
    public OrderPageTest(String firstName, String lastName, String address, String metro, String phone,
                         String date, String rentalPeriod, String color, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Before
    public void init() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //Неявное ожидание
    }


    // Метод для параметризации данных
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Иван", "Иванов", "Ленина, 10", "Динамо", "88009997755", "12.05.2025", "двое суток", "black", "После 15:00"},
                {"Анна", "Сидорова", "Мира, 75", "ВДНХ", "899912345678", "13.05.2025", "сутки", "grey", "Позвоните заранее"},
        };
    }

    @Test
    public void testOrderFlow() throws InterruptedException {
        // Инициализация драйвера
        driver.get("https://qa-scooter.praktikum-services.ru/order");

        // Создание страницы оформления заказа
        OrderPage orderPage = new OrderPage(driver);

        // Заполнение первой формы
        orderPage.fillStepOneForm(firstName, lastName, address, metro, phone);

        // Заполнение второй формы
        orderPage.fillStepTwoForm(date, rentalPeriod, color, comment);

        // Подтверждение заказа
        orderPage.confirmOrder();

        // Проверка успешного оформления
        assertTrue(orderPage.isOrderConfirmed());

    }

    @Test
    public void navigationAfterClickHeaderOrderButtonTest() {
        // Перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickHeaderOrderButton();

        String expectedUrl = "https://qa-scooter.praktikum-services.ru/order";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void navigationAfterClickMainOrderButtonTest() {
        // Перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.scrollOderButtonDown();
        mainPage.clickMainOrderButton();

        String expectedUrl = "https://qa-scooter.praktikum-services.ru/order";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }


    @After
    public void teardown() {
        // Закрыли браузер
        driver.quit();
    }
}




