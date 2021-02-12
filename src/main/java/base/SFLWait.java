package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFLWait {

    private static int timeOut = 30;
    private static SFLWebDriver driver = SFLWebDriver.getWebDriver();

    private static SFLWait instance = null;
    private WebDriverWait wait;


    private SFLWait() {
      wait = new WebDriverWait(driver, timeOut);
    }

    public static SFLWait getInstance() {
        if (instance == null) {
            synchronized (SFLWait.class) {
                if (instance == null) {
                    instance = new SFLWait();
                }
            }
        }
        return instance;
    }

    public WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
