package test;

import base.SeleniumTestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import misc.Candidate;

import static pages.HeaderElements.*;
import static pages.FormFields.*;
import static org.testng.Assert.*;

public class HiringScenarioTestBase extends SeleniumTestBase {

    @BeforeMethod
    public void navigation() {
        getWebDriver().get("https://sflpro.com/");
    }

    @Test
    public void test() {
        String vacancyToApply = "GENERAL APPLICATION";
        String manualQaEngineerVacancyName = "Manual QA Engineer";
        String automationQaEngineerVacancyName = "Automation QA Engineer";
        SflHeader header = new SflHeader();
        header.clickOnHeaderElement(CAREERS);
        CareersMainPage careersPage = new CareersMainPage();
        assertEquals(careersPage.getVacancyCount(), header.getCareerCount());
        assertFalse(careersPage.vacancyExists(manualQaEngineerVacancyName), "No vacancy for "+manualQaEngineerVacancyName);
        assertTrue(careersPage.vacancyExists(automationQaEngineerVacancyName), "There is no vacancy for" + automationQaEngineerVacancyName);

        careersPage.clickApplyNow();
        VacancyDetailsPage vacancyPage = new VacancyDetailsPage();
        Candidate candidate = new Candidate("Pablo", "Escobar", "snifSnif@nose.com");
        vacancyPage.fillInputField(FIRST_NAME_FIELD, candidate.getName(), vacancyToApply);
        vacancyPage.fillInputField(LAST_NAME_FIELD, candidate.getLastName(), vacancyToApply);
        vacancyPage.fillInputField(EMAIL_FIELD, candidate.getEmail(), vacancyToApply);
        vacancyPage.uploadCvForJobRole(vacancyToApply);
        vacancyPage.clickSubmit(vacancyToApply);
        assertTrue(vacancyPage.isLoadingDisplayed(), "On submitting, the loading animation isn't displayed");
    }
}
