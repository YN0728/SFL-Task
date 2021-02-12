package pages;

import base.JSScripts;
import base.SFLWebDriver;
import base.SeleniumBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CareersMainPage extends SeleniumBase {

    @FindBy(css = "[class='s-careers-title']")
    private List<WebElement> vacancies;
    @FindBy(css = "[class='s-btn-yellow']")
    private WebElement applyNow;

    public CareersMainPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public String getVacancyCount() {
        return String.valueOf(vacancies.size());
    }

    public Boolean vacancyExists(String vacancy) {
        return vacancies.stream().anyMatch(item -> item.getText().contains(vacancy));
    }

    public void clickApplyNow() {
        getWait().waitForElementToBeClickable(applyNow);
        JSScripts.scrollTo(applyNow);
        applyNow.click();
    }

}
