package base;

import org.testng.annotations.AfterMethod;

public class SeleniumTestBase extends SeleniumBase{

    @AfterMethod
    public void tearDown() {
        getWebDriver().quit();
    }
}
