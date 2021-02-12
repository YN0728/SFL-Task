package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class JSScripts {

    public static void scrollTo(WebElement element) {
        Actions actions = new Actions(SFLWebDriver.getWebDriver());
        actions.moveToElement(element);
        actions.perform();
    }
}