package ge.tbc.testautomation;

import ge.tbc.testautomation.data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class NavigationTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(Constants.ULTIMATEQA_AUTOMATION_URL);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority=1)
    public void goToServicesAndBack() {
        driver.findElement(By.linkText(Constants.SERVICES_LINK_TEXT)).click();
        wait.until(ExpectedConditions.urlToBe(Constants.ULTIMATEQA_CONSULTING_URL));
        Assert.assertEquals(driver.getCurrentUrl(), Constants.ULTIMATEQA_CONSULTING_URL);

        driver.navigate().back();
        wait.until(ExpectedConditions.urlToBe(Constants.ULTIMATEQA_AUTOMATION_URL));
        Assert.assertEquals(driver.getCurrentUrl(), Constants.ULTIMATEQA_AUTOMATION_URL);
    }
}