package ru.praktikumservices.qascooter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikumservices.qascooter.pom.MainPage;

import java.util.function.Function;


@RunWith(Parameterized.class) // Аннотация для параметризованных тестов
public class AccordionTest extends BasePageTest {
    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final String expectedText;
    private final Function<MainPage, String> actualFunctionText;
    private final String assertMessage;

    // Создаем конструктор и инициализируем поля класса в нем
    public AccordionTest(String expectedText, Function<MainPage, String> actualFunctionText,
                         String assertMessage, int typeDriver) {
        super(typeDriver);
        this.expectedText = expectedText;
        this.actualFunctionText = actualFunctionText;
        this.assertMessage = assertMessage;
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
                {moneyTest, (Function<MainPage, String>) MainPage::getAccordionMoneyAnswer, "AccordionMoneyAnswer is failed", 0},
                {severalText, (Function<MainPage, String>) MainPage::getAccordionSeveralAnswer, "AccordionSeveralAnswer is failed", 0},
                {timeText, (Function<MainPage, String>) MainPage::getAccordionTimeAnswer, "AccordionTimeAnswer is failed", 0},
                {todayText, (Function<MainPage, String>) MainPage::getAccordionTodayAnswer, "AccordionTodayAnswer is failed", 0},
                {extendText, (Function<MainPage, String>) MainPage::getAccordionExtendAnswer, "AccordionExtendAnswer is failed", 0},
                {chargeText, (Function<MainPage, String>) MainPage::getAccordionChargeAnswer, "AccordionChargeAnswer is failed", 0},
                {cancelText, (Function<MainPage, String>) MainPage::getAccordionCancelAnswer, "AccordionCancelAnswer is failed", 0},
                {mkadText, (Function<MainPage, String>) MainPage::getAccordionMkadAnswer, "AccordionMkadAnswer is failed", 0},

                {moneyTest, (Function<MainPage, String>) MainPage::getAccordionMoneyAnswer, "AccordionMoneyAnswer is failed", 1},
                {severalText, (Function<MainPage, String>) MainPage::getAccordionSeveralAnswer, "AccordionSeveralAnswer is failed", 1},
                {timeText, (Function<MainPage, String>) MainPage::getAccordionTimeAnswer, "AccordionTimeAnswer is failed", 1},
                {todayText, (Function<MainPage, String>) MainPage::getAccordionTodayAnswer, "AccordionTodayAnswer is failed", 1},
                {extendText, (Function<MainPage, String>) MainPage::getAccordionExtendAnswer, "AccordionExtendAnswer is failed", 1},
                {chargeText, (Function<MainPage, String>) MainPage::getAccordionChargeAnswer, "AccordionChargeAnswer is failed", 1},
                {cancelText, (Function<MainPage, String>) MainPage::getAccordionCancelAnswer, "AccordionCancelAnswer is failed", 1},
                {mkadText, (Function<MainPage, String>) MainPage::getAccordionMkadAnswer, "AccordionMkadAnswer is failed", 1}
        };
    }

    //сравниваем открывающийся текст в аккордионе
    @Test
    public void checkAccordionAnswer() {
        driver.get(URL);
        MainPage mainPage = new MainPage(driver);
        initPage(mainPage);
        mainPage.scrollDown(); //Скролл до вопросов о важном

        Assert.assertEquals(getDriverNameMsg() + "; " + assertMessage, expectedText, actualFunctionText.apply(mainPage));
    }
}
