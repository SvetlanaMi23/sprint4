package ru.praktikumservices.qascooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikumservices.qascooter.pom.MainPage;


@RunWith(Parameterized.class) // Аннотация для параметризованных тестов
public class AccordionTest extends BasePageTest {

    private final String idHeading;
    private final String idPanel;
    private final String text;
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    // Создаем конструктор и инициализируем поля класса в нем
    public AccordionTest(String idHeading, String idPanel, String text, int typeDriver) {
        super(typeDriver);
        this.idHeading = idHeading;
        this.idPanel = idPanel;
        this.text = text;
    }

    @Parameterized.Parameters // Аннотация метода для параметров
    public static Object[][] getText() {

        String accHeading0 = "accordion__heading-0";
        String accHeading1 = "accordion__heading-1";
        String accHeading2 = "accordion__heading-2";
        String accHeading3 = "accordion__heading-3";
        String accHeading4 = "accordion__heading-4";
        String accHeading5 = "accordion__heading-5";
        String accHeading6 = "accordion__heading-6";
        String accHeading7 = "accordion__heading-7";
        String accPanel0 = "accordion__panel-0";
        String accPanel1 = "accordion__panel-1";
        String accPanel2 = "accordion__panel-2";
        String accPanel3 = "accordion__panel-3";
        String accPanel4 = "accordion__panel-4";
        String accPanel5 = "accordion__panel-5";
        String accPanel6 = "accordion__panel-6";
        String accPanel7 = "accordion__panel-7";
        String text0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String text1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String text2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String text3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String text4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String text5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String text6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String text7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        return new Object[][]{
                {accHeading0, accPanel0, text0, 0},
                {accHeading1, accPanel1, text1, 0},
                {accHeading2, accPanel2, text2, 0},
                {accHeading3, accPanel3, text3, 0},
                {accHeading4, accPanel4, text4, 0},
                {accHeading5, accPanel5, text5, 0},
                {accHeading6, accPanel6, text6, 0},
                {accHeading7, accPanel7, text7, 0},

                {accHeading0, accPanel0, text0, 1},
                {accHeading1, accPanel1, text1, 1},
                {accHeading2, accPanel2, text2, 1},
                {accHeading3, accPanel3, text3, 1},
                {accHeading4, accPanel4, text4, 1},
                {accHeading5, accPanel5, text5, 1},
                {accHeading6, accPanel6, text6, 1},
                {accHeading7, accPanel7, text7, 1}
        };
    }

    @Test
    public void checkAccordion() {
        // Перешли на страницу тестового приложения
        driver.get(url);

        MainPage mainPage = new MainPage(driver);

        mainPage.scrollDown(); //Скролл до вопросов о важном

        mainPage.clickAccordionHeadingButton(idHeading); // Нажимаем на вопросы аккордиона

        String result = mainPage.getAccordionPanelText(idPanel);

        Assert.assertEquals(getDriverNameMsg(), text, result); //сравниваем открывающийся текст в аккордионе

    }

    @After
    public void teardown() {
        // Закрыли браузер
        driver.quit();
    }
}
