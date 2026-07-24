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

public class CommandsTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(Constants.DYNAMIC_CONTROLS_URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority=1)
    public void labelsTest() {
        WebElement heading = driver.findElement(By.cssSelector(".example h3"));
        Assert.assertEquals(heading.getText(), Constants.DYNAMIC_CONTROLS_HEADING);

        WebElement description = driver.findElement(By.cssSelector(".example p"));
        Assert.assertEquals(description.getText(), Constants.DYNAMIC_CONTROLS_DESCRIPTION);
    }
}