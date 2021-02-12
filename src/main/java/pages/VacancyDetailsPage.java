package pages;

import base.JSScripts;
import base.SFLWebDriver;
import base.SeleniumBase;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static pages.FormFields.*;


public class VacancyDetailsPage extends SeleniumBase {

    @FindBy(css = "[class='ajax-loader is-active']")
    private WebElement activeLoading;
    @FindBy(css = "[class='ui-tabs-anchor']")
    private List<WebElement> jobRoles;
    @FindBy(css = "[class='s-send-resume'] [value='Submit']")
    private List<WebElement> submitButtons;

    public VacancyDetailsPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    private int getJobRoleIndex(String jobRoleName) {
        for (int i = 0; i < jobRoles.size(); i++) {
            if (jobRoles.get(i).getText().equals(jobRoleName)) {
                return i;
            }
        }
        throw new NoSuchElementException("Unknown job role: " + jobRoleName);
    }

    public void fillInputField(FormFields field, String value, String jobRole) {
        int roleIndex = getJobRoleIndex(jobRole);
        WebElement fieldToFill = getWebDriver().findElements(field.getFillInField()).get(roleIndex);
        JSScripts.scrollTo(fieldToFill);
        fieldToFill.sendKeys(value);
    }

    public void uploadCvForJobRole(String jobRole) {
        String fileRelativePath = "/src/files/Test_Assignment.pdf";
        String userDir = System.getProperty("user.dir");
        int roleIndex = getJobRoleIndex(jobRole);
        WebElement fieldToFill = getWebDriver().findElements(CHOOSE_FILE_FIELD.getFillInField()).get(roleIndex);
        JSScripts.scrollTo(fieldToFill);
        fieldToFill.sendKeys(userDir + fileRelativePath);
    }

    public void clickSubmit(String vacancy) {
        int roleIndex = getJobRoleIndex(vacancy);
        WebElement submitButton = submitButtons.get(roleIndex);
        submitButton.click();
    }

    public boolean isLoadingDisplayed() {
        return activeLoading != null;
    }

}
