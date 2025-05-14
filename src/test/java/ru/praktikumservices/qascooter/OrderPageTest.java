package ru.praktikumservices.qascooter;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikumservices.qascooter.pom.MainPage;
import ru.praktikumservices.qascooter.pom.OrderPage;

import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTest extends BasePageTest {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final String orderUrl = "https://qa-scooter.praktikum-services.ru/order";

    // Конструктор для параметризированного теста
    public OrderPageTest(String firstName, String lastName, String address, String metro, String phone,
                         String date, String rentalPeriod, String color, String comment, int typeDriver) {
        super(typeDriver);
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

    // Метод для параметризации данных
    @Parameterized.Parameters
    public static Object[][] data() {
        String name1 = "Иван";
        String lastName1 = "Иванов";
        String address1 = "Ленина, 10";
        String metro1 = "Динамо";
        String phone1 = "88009997755";
        String data1 = "12.05.2025";
        String period1 = "двое суток";
        String color1 = "black";
        String comment1 = "После 15:00";

        String name2 = "Анна";
        String lastName2 = "Сидорова";
        String address2 = "Мира, 75";
        String metro2 = "ВДНХ";
        String phone2 = "899912345678";
        String data2 = "13.05.2025";
        String period2 = "сутки";
        String color2 = "grey";
        String comment2 = "Позвоните заранее";

        return new Object[][]{
                {name1, lastName1, address1, metro1, phone1, data1, period1, color1, comment1, 0},
                {name2, lastName2, address2, metro2, phone2, data2, period2, color2, comment2, 0},

                {name1, lastName1, address1, metro1, phone1, data1, period1, color1, comment1, 1},
                {name2, lastName2, address2, metro2, phone2, data2, period2, color2, comment2, 1},
        };
    }

    @Test
    public void testOrderFlow() {
        // Инициализация драйвера
        driver.get(orderUrl);

        // Создание страницы оформления заказа
        OrderPage orderPage = new OrderPage(driver);

        // Заполнение первой формы
        orderPage.fillStepOneForm(firstName, lastName, address, metro, phone);

        // Заполнение второй формы
        orderPage.fillStepTwoForm(date, rentalPeriod, color, comment);

        // Подтверждение заказа
        orderPage.confirmOrder();

        // Проверка успешного оформления
        assertTrue(getDriverNameMsg(), orderPage.isOrderConfirmed());

    }

    @Test
    public void navigationAfterClickHeaderOrderButtonTest() {
        navigationAfterClickOrderButtonsTest(MainPage::clickHeaderOrderButton);
    }

    @Test
    public void navigationAfterClickMainOrderButtonTest() {
        navigationAfterClickOrderButtonsTest(mainPage -> {
            mainPage.scrollOderButtonDown();
            mainPage.clickMainOrderButton();
        });
    }

    private void navigationAfterClickOrderButtonsTest(Consumer<MainPage> clickConsumer) {
        // Перешли на страницу тестового приложения
        driver.get(url);

        MainPage mainPage = new MainPage(driver);
        clickConsumer.accept(mainPage);

        String actualUrl = driver.getCurrentUrl();
        assertEquals(getDriverNameMsg(), orderUrl, actualUrl);
    }


    @After
    public void teardown() {
        // Закрыли браузер
        driver.quit();
    }
}
