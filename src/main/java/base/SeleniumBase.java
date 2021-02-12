package base;

public class SeleniumBase {

    public SFLWebDriver getWebDriver(){
        return SFLWebDriver.getWebDriver();
    }

    public SFLWait getWait(){
        return SFLWait.getInstance();
    }
}
