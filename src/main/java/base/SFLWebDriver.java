package base;

import org.openqa.selenium.chrome.ChromeDriver;

public class SFLWebDriver extends ChromeDriver {

    private static SFLWebDriver instance;

    private SFLWebDriver() {

    }

    private static void setProperty(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
    }

    public static SFLWebDriver getWebDriver() {
        if(instance == null) {
            synchronized (SFLWebDriver.class) {
                if (instance == null) {
                    setProperty();
                    instance = new SFLWebDriver();
                }
            }
        }
        return instance;
    }
}
