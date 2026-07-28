package ge.tbc.testautomation;

import ge.tbc.testautomation.data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class LocatorsTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority=1)
    public void unorderedListTest() {
        driver.get(Constants.JQUERY_UI_SLIDER_URL);

        WebElement effectsAside = driver.findElement(By.xpath(
                "//aside[.//h3[contains(@class, '" + Constants.WIDGET_TITLE_CLASS + "') "
                        + "and normalize-space(text())='" + Constants.EFFECTS_TITLE_TEXT + "']]"));

        List<WebElement> listItems = effectsAside.findElements(By.cssSelector("ul li"));

        List<WebElement> filteredItems = listItems.stream()
                .filter(li -> li.getText().contains(Constants.FILTER_LETTER))
                .collect(Collectors.toList());

        filteredItems.parallelStream().forEach(li -> {
            WebElement link = li.findElement(By.tagName("a"));
            String href = link.getAttribute(Constants.HREF_ATTRIBUTE);
            if (href.contains(Constants.ANIMATE_KEYWORD)) {
                return;
            }
            System.out.println(href);
        });
    }

    @Test(priority=2)
    public void buttonsTest() {
        driver.get(Constants.ADD_REMOVE_ELEMENTS_URL);

        WebElement addElementButton = driver.findElement(
                By.xpath("//button[text()='" + Constants.ADD_ELEMENT_BUTTON_TEXT + "']"));
        for (int i = 0; i < 3; i++) {
            addElementButton.click();
        }

        WebElement lastDeleteButton = driver.findElement(By.cssSelector("#elements button:last-of-type"));
        Assert.assertEquals(lastDeleteButton.getAttribute(Constants.CLASS_ATTRIBUTE), Constants.ADDED_MANUALLY_CLASS);

        List<WebElement> deleteButtons = driver.findElements(
                By.cssSelector("button[onclick^='" + Constants.DELETE_ONCLICK_PREFIX + "']"));
        WebElement lastByOnclick = deleteButtons.stream().reduce((first, second) -> second).orElseThrow();
        Assert.assertEquals(lastByOnclick.getAttribute(Constants.ONCLICK_ATTRIBUTE), Constants.DELETE_ELEMENT_ONCLICK_VALUE);
    }

    @Test(priority=3)
    public void challengingDomTest() {
        driver.get(Constants.CHALLENGING_DOM_URL);

        String xpath = String.format("//td[text()='%s']/preceding-sibling::td[1]", Constants.TARGET_IPSUM_VALUE);
        WebElement loremCell = driver.findElement(By.xpath(xpath));

        System.out.println(loremCell.getText());
    }
}