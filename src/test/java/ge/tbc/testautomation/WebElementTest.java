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

public class WebElementTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(Constants.DRAG_AND_DROP_URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority=1)
    public void dimensionsTest() {
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        Assert.assertEquals(columnA.getLocation().getY(), columnB.getLocation().getY());

        Assert.assertEquals(columnA.getAttribute(Constants.DRAGGABLE_ATTRIBUTE), Constants.DRAGGABLE_EXPECTED_VALUE);
        Assert.assertEquals(columnB.getAttribute(Constants.DRAGGABLE_ATTRIBUTE), Constants.DRAGGABLE_EXPECTED_VALUE);
    }

    @Test(priority=2)
    public void linkTest() {
        WebElement link = driver.findElement(By.linkText(Constants.ELEMENTAL_SELENIUM_LINK_TEXT));
        Assert.assertEquals(link.getAttribute(Constants.HREF_ATTRIBUTE), Constants.ELEMENTAL_SELENIUM_HREF);
    }
}
