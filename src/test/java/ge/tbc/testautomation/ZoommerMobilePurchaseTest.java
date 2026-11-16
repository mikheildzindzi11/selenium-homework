package ge.tbc.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ZoommerMobilePurchaseTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://zoommer.ge/");
    }

    @Test(priority=1, description="Choosing mobiles")
    public void closingPopUp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popUpClose = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()=\"გასაგებია\"]"))));
        popUpClose.click();
    }

    @Test(priority=2, description="Going to mobile page")
    public void goToMobileSection(){
        WebElement clickMobileSection = driver.findElement(By.xpath("//h4[text()=\"მობილურები\"]"));
        clickMobileSection.click();
    }

    @Test(priority=3, description="going to mobile page")
    public void goingToPhonePage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickMobile = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href$='-p54840']")));
        clickMobile.click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("apple-iphone-18-pro-e-sim-only"));
    }

    @Test(priority=4, description="continue buying")
    public void checkingBuyService() throws InterruptedException {
        WebElement buyButton = driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium filled-btn false css-1pgnchw\"] "));
        buyButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath(" //div[@id='portal']//h4[text()=\"ავტორიზაცია\"]")).getText(), "ავტორიზაცია");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
