package pages;

import org.openqa.selenium.By;

public enum HeaderElements {
    WORK(By.cssSelector("[id='menu-item-3521']")),
    ABOUT(By.cssSelector("[id='menu-item-3404']")),
    ENGINEERING(By.cssSelector("[id='menu-item-5634']")),
    BLOG(By.cssSelector("[id='menu-item-4835']")),
    CAREERS(By.cssSelector("[id='menu-item-3337']"));
    private By headerElementsBy;

    HeaderElements(By headerElementsBy) {
        this.headerElementsBy = headerElementsBy;
    }

    public By getHeaderElementsBy() {
        return headerElementsBy;
    }
}
