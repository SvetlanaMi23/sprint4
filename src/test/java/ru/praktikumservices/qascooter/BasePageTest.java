package ru.praktikumservices.qascooter;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.praktikumservices.qascooter.pom.BasePage;

import java.time.Duration;

public class BasePageTest {

    protected WebDriver driver;
    private final int typeDriver;

    public BasePageTest(int typeDriver) {
        this.typeDriver = typeDriver;
    }

    @Before
    public void createDriver() {
        String[] arguments = new String[]{"--no-sandbox", "--headless", "--window-size=1200,800", "--disable-dev-shm-usage"};
        if (typeDriver == 0) {
            // Создаем драйвер для браузера Firefox
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments(arguments);
            driver = new FirefoxDriver(firefoxOptions);
        } else {
            // Создаем драйвер для браузера Chrome
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(arguments);
            driver = new ChromeDriver(chromeOptions);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Неявное ожидание
    }

    protected void initPage(BasePage page) {
        page.clickAcceptCookieButton();
    }

    protected String getDriverNameMsg() {
        return "Error on driver name: " + (typeDriver == 0 ? "FireFox" : "Chrome");
    }

    @After
    public void teardown() {
        // Закрыли браузер
        driver.quit();
    }
}
