package ge.tbc.testautomation;

import ge.tbc.testautomation.data.Constants;
import ge.tbc.testautomation.util.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FormsTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void customDropDownTest() {
        driver.get(Constants.CUSTOM_DROPDOWN_BASE_URL);
        driver.findElement(By.cssSelector(Constants.DEMO2_LINK_SELECTOR)).click();

        WebElement dropdownMenu = driver.findElement(By.cssSelector(Constants.CUSTOM_DROPDOWN_MENU_SELECTOR));
        Assert.assertFalse(dropdownMenu.isDisplayed(), "Dropdown menu should not be visible before clicking it");

        driver.findElement(By.cssSelector(Constants.CUSTOM_DROPDOWN_TOGGLE_SELECTOR)).click();
        wait.until(ExpectedConditions.visibilityOf(dropdownMenu));
        Assert.assertTrue(dropdownMenu.isDisplayed(), "Dropdown menu should be visible after clicking it");

        Selectors.universalSelector(dropdownMenu, Constants.GITHUB_OPTION_TEXT);
    }

    @Test(priority = 2)
    public void nativeDropDownTest() {
        driver.get(Constants.REGISTER_PAGE_URL);

        List<WebElement> genderRadios = driver.findElements(By.cssSelector("input[type='radio']"));
        genderRadios.get(0).click();

        List<WebElement> selects = driver.findElements(By.tagName("select"));
        WebElement modelSelectElement = selects.stream()
                .filter(select -> select.findElements(By.tagName("option")).stream()
                        .anyMatch(option -> option.getText().trim().equals(Constants.MODEL_OPTION_TEXT)))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Could not find a <select> containing option: " + Constants.MODEL_OPTION_TEXT));

        Selectors.universalSelector(new Select(modelSelectElement), Constants.MODEL_OPTION_TEXT);

        List<WebElement> textLikeInputs = driver.findElements(By.cssSelector(
                "input[type='text'], input[type='email'], input[type='tel'], "
                        + "input[type='password'], input:not([type])"));
        for (WebElement input : textLikeInputs) {
            String type = input.getAttribute("type");
            if ("email".equals(type)) {
                input.sendKeys(Constants.DUMMY_EMAIL_VALUE);
            } else {
                input.sendKeys(Constants.DUMMY_TEXT_VALUE);
            }
        }

        driver.findElement(By.cssSelector("input[type='submit'], button[type='submit']")).click();
    }
}