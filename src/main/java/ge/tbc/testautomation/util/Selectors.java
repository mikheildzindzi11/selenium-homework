package ge.tbc.testautomation.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public final class Selectors {

    private Selectors() {
    }

    public static <T> void universalSelector(T element, String visibleText) {
        if (element instanceof Select) {
            ((Select) element).selectByVisibleText(visibleText);
        } else if (element instanceof WebElement) {
            WebElement container = (WebElement) element;
            WebElement option = container.findElement(
                    By.xpath(".//*[normalize-space(text())='" + visibleText + "']"));
            option.click();
        } else {
            throw new IllegalArgumentException(
                    "universalSelector only supports Select or WebElement, got: "
                            + (element == null ? "null" : element.getClass()));
        }
    }
}