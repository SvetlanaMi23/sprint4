package ru.praktikumservices.qascooter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikumservices.qascooter.pom.MainPage;


@RunWith(Parameterized.class) // Аннотация для параметризованных тестов
public class AccordionTest extends BasePageTest {
    private static final String url = "https://qa-scooter.praktikum-services.ru/";
    private final String textMoney;
    private final String textSeveral;
    private final String textTime;
    private final String textToday;
    private final String textExtend;
    private final String textCharge;
    private final String textCancel;
    private final String textMkad;

    // Создаем конструктор и инициализируем поля класса в нем
    public AccordionTest(String textMoney, String textSeveral, String textTime, String textToday, String textExtend,
                         String textCharge, String textCancel, String textMkad, int typeDriver) {
        super(typeDriver);
        this.textMoney = textMoney;
        this.textSeveral = textSeveral;
        this.textTime = textTime;
        this.textToday = textToday;
        this.textExtend = textExtend;
        this.textCharge = textCharge;
        this.textCancel = textCancel;
        this.textMkad = textMkad;
    }

    @Parameterized.Parameters // Аннотация метода для параметров
    public static Object[][] getText() {
        String textMoney = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String textSeveral = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String textTime = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String textToday = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String textExtend = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String textCharge = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String textCancel = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String textMkad = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        return new Object[][]{
                {textMoney, textSeveral, textTime, textToday, textExtend, textCharge, textCancel, textMkad, 0},
                {textMoney, textSeveral, textTime, textToday, textExtend, textCharge, textCancel, textMkad, 1}
        };
    }

    @Test
    public void checkAccordionAnswer() {
        driver.get(url);
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollDown(); //Скролл до вопросов о важном

        //сравниваем открывающийся текст в аккордионе
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionMoneyAnswer(), textMoney);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionSeveralAnswer(), textSeveral);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionTimeAnswer(), textTime);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionTodayAnswer(), textToday);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionExtendAnswer(), textExtend);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionChargeAnswer(), textCharge);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionCancelAnswer(), textCancel);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionMkadAnswer(), textMkad);
    }
}
