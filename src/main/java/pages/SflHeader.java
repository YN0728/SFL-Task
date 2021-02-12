package pages;

import base.SFLWebDriver;
import base.SeleniumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SflHeader extends SeleniumBase {

    @FindBy(css = "[id='menu-item-3337'] [class='job-count']")
    private WebElement careersCount;

    public SflHeader() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public String getCareerCount() {
        getWait().waitForElement(careersCount);
        return careersCount.getText();
    }

    public void clickOnHeaderElement(HeaderElements element) {
        getWait().waitForElement(element.getHeaderElementsBy());
        WebElement headerElement = getWebDriver().findElement(element.getHeaderElementsBy());
        headerElement.click();
    }
}