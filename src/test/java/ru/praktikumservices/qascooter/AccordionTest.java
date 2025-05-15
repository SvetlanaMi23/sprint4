package ru.praktikumservices.qascooter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikumservices.qascooter.pom.MainPage;


@RunWith(Parameterized.class) // Аннотация для параметризованных тестов
public class AccordionTest extends BasePageTest {
    private static final String url = "https://qa-scooter.praktikum-services.ru/";
    private final String moneyTest;
    private final String severalText;
    private final String timeText;
    private final String todayText;
    private final String extendText;
    private final String chargeText;
    private final String cancelText;
    private final String mkadText;

    // Создаем конструктор и инициализируем поля класса в нем
    public AccordionTest(String moneyTest, String severalText, String timeText, String todayText, String extendText,
                         String chargeText, String cancelText, String mkadText, int typeDriver) {
        super(typeDriver);
        this.moneyTest = moneyTest;
        this.severalText = severalText;
        this.timeText = timeText;
        this.todayText = todayText;
        this.extendText = extendText;
        this.chargeText = chargeText;
        this.cancelText = cancelText;
        this.mkadText = mkadText;
    }

    @Parameterized.Parameters // Аннотация метода для параметров
    public static Object[][] getText() {
        String moneyTest = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String severalText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String timeText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String todayText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String extendText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String chargeText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String cancelText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String mkadText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

        return new Object[][]{
                {moneyTest, severalText, timeText, todayText, extendText, chargeText, cancelText, mkadText, 0},
                {moneyTest, severalText, timeText, todayText, extendText, chargeText, cancelText, mkadText, 1}
        };
    }

    @Test
    public void checkAccordionAnswer() {
        driver.get(url);
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollDown(); //Скролл до вопросов о важном

        //сравниваем открывающийся текст в аккордионе
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionMoneyAnswer(), moneyTest);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionSeveralAnswer(), severalText);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionTimeAnswer(), timeText);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionTodayAnswer(), todayText);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionExtendAnswer(), extendText);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionChargeAnswer(), chargeText);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionCancelAnswer(), cancelText);
        Assert.assertEquals(getDriverNameMsg(), mainPage.getAccordionMkadAnswer(), mkadText);
    }
}
