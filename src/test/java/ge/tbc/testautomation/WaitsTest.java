package ge.tbc.testautomation;

import ge.tbc.testautomation.data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void waitForDisappearance() {
        driver.get(Constants.DYNAMIC_CONTROLS_URL);

        WebElement enableButton = driver.findElement(
                By.xpath("//button[text()='" + Constants.ENABLE_BUTTON_TEXT + "']"));
        enableButton.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(Constants.LOADING_INDICATOR_ID)));

        Assert.assertEquals(enableButton.getText(), Constants.DISABLE_BUTTON_TEXT);

        WebElement input = driver.findElement(By.cssSelector("#input-example input"));
        input.sendKeys(Constants.ACCESS_GRANTED_TEXT);
    }

    @Test(priority = 2)
    public void waitForText() {
        driver.get(Constants.PROGRESS_BAR_URL);

        driver.findElement(By.id(Constants.PROGRESS_BAR_BUTTON_ID)).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id(Constants.PROGRESS_BAR_ID), Constants.PROGRESS_COMPLETE_TEXT));

        WebElement button = driver.findElement(By.id(Constants.PROGRESS_BAR_BUTTON_ID));
        System.out.println(button.getText());
        Assert.assertEquals(button.getText(), Constants.RESET_BUTTON_TEXT);
    }
}