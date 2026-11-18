package ge.tbc.testautomation;

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
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class IframeFormTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testdriver.ai/playground/iframe/");
    }

    @Test(priority=1, description="practicing iframe")
    public void iframeTest(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = driver.findElement(By.cssSelector("iframe[src='/playground/frames/contact.html']"));
        driver.switchTo().frame(iframe);

        // filling iframe form
        driver.findElement(By.id("name")).sendKeys("testname");
        driver.findElement(By.id("email")).sendKeys("testemail@gmail.com");
        driver.findElement(By.id("message")).sendKeys("testing message");
        WebElement send = driver.findElement(By.xpath("//button[text()=\"Send message\"]"));
        js.executeScript("arguments[0].click();", send);

        // filling nested iframe form
        WebElement nestedIframe = driver.findElement(By.cssSelector("[src='/playground/frames/newsletter.html']"));
        driver.switchTo().frame(nestedIframe);
        driver.findElement(By.xpath("//input[@id=\"newsletter-email\"]")).sendKeys("testemail@gmail.com");
        WebElement subscribe = driver.findElement(By.xpath("//button[text()=\"Subscribe\"]"));
        js.executeScript("arguments[0].click();", subscribe);

        // switching back
        driver.switchTo().defaultContent();

        // find success messages
        WebElement message1 = driver.findElement(By.xpath("//div[@id=\"confirmations\"]"));


        // assert success messages
        Assert.assertTrue(message1.getText().contains("Subscribed testemail@gmail.com to the newsletter."));
        Assert.assertTrue(message1.getText().contains("Message sent. Thanks, testname! We'll reply to testemail@gmail.com."));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
