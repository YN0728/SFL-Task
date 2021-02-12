package pages;

import org.openqa.selenium.By;

public enum FormFields {

    FIRST_NAME_FIELD(By.cssSelector("[name='Firstname']")),
    LAST_NAME_FIELD(By.cssSelector("[name='Lastname']")),
    EMAIL_FIELD(By.cssSelector("[name='E-mailaddress']")),
    CHOOSE_FILE_FIELD(By.cssSelector("[name='file-441']")),
    ;

    private By field;

    FormFields(By field) {
        this.field = field;
    }

    public By getFillInField() {
        return field;
    }
}