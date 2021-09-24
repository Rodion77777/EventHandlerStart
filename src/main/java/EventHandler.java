import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EventHandler implements WebDriverEventListener {

    private Logger LOGGER;

    public EventHandler (Logger logger) {
        LOGGER = logger;
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        LOGGER.info("Accept alert.\n");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        LOGGER.fine("Alert is accepted successfully!\n");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        LOGGER.info("Dismiss alert.\n");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        LOGGER.fine("Alert is dismissed successfully!\n");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        LOGGER.log(Level.INFO, "Navigate to : {0}\n", s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        LOGGER.log(Level.FINE, "Current URL: {0}\n", s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        LOGGER.info("Navigate back.\n");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        LOGGER.log(Level.FINE, "Current URL: {0}\n", webDriver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        LOGGER.info("Navigate forward.\n");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        LOGGER.log(Level.FINE, "Current URL: {0}\n", webDriver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        LOGGER.info("Refresh page.\n");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        LOGGER.log(Level.FINE, "Current URL: {0}\n", webDriver.getCurrentUrl());
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        LOGGER.log(Level.INFO, "Find element by: {0}\n", by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        if (webElement != null) LOGGER.fine("Element successfully found.\n");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        LOGGER.log(Level.INFO, "Find element by: {0}\n", webElement);
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        LOGGER.fine("Clicked successfully.\n");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        String value = Arrays.stream(charSequences).map(CharSequence::toString).collect(Collectors.joining());
        LOGGER.log(Level.INFO, "Change value of {0}: {1}\n", new String[]{webElement.getTagName(), value});
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        LOGGER.log(Level.FINE, "Changed element: {0}\n", webElement);
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        LOGGER.log(Level.INFO, "Execute script: {0}\n", s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        LOGGER.fine("Script executed.\n");
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        LOGGER.log(Level.INFO, "Trying to retrieve text from element: {0}\n", webElement);
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        if (s != null) LOGGER.fine("Text successfully received!\n");
    }
}
