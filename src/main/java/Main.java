import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = new JULogger(Main.class.getName()).myLogger;

    private static final String type = "webdriver.chrome.driver";
    private static final String path = "./src/main/resources/chromedriver_win32/chromedriver.exe";
    private static final String siteAddress = "http://prestashop.qatestlab.com.ua/ru/";
    private static final String xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a";
    private static final String idElementForWait = "email";
    private static final String xpathTextElement = "//*[@id=\"login_form\"]/h3";

    public static void main (String[] args) {

        System.setProperty(type, path);

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(new ChromeDriver()).register(new EventHandler(LOGGER));

        eventDriver.manage().window().maximize();
        eventDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        eventDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        eventDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        eventDriver.get(siteAddress);
        eventDriver.getCurrentUrl();
        eventDriver.findElement(By.xpath(xpath)).click();
        eventDriver.findElement(By.xpath(xpathTextElement)).getText();

        new WebDriverWait(eventDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(idElementForWait)));

        LOGGER.info("Test log");

        eventDriver.close();
        eventDriver.quit();
    }
}