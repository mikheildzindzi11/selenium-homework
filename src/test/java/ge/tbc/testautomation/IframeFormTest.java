package ge.tbc.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = driver.findElement(By.cssSelector("iframe[src='/playground/frames/contact.html']"));
        driver.switchTo().frame(iframe);

        // filling iframe form
        driver.findElement(By.id("name")).sendKeys("testname");
        driver.findElement(By.id("email")).sendKeys("testemail@gmail.com");
        driver.findElement(By.id("message")).sendKeys("testing message");
        driver.findElement(By.xpath("//button[text()=\"Send message\"]")).click();

        // filling nested iframe form
        WebElement nestedIframe = driver.findElement(By.cssSelector("src='/playground/frames/newsletter.html'"));
        driver.switchTo().frame(nestedIframe);
        driver.findElement(By.id("newsletter-email")).sendKeys("testemail@gmail.com");
        driver.findElement(By.xpath("Subscribe")).click();

        // switching back
        driver.switchTo().defaultContent();

        // find success messages
        WebElement message1 = driver.findElement(By.className(".pg-alert pg-alert-success"));
        WebElement message2 = driver.findElement(By.className(".pg-alert pg-alert-success"));

        // assert success messages
        Assert.assertTrue(message1.getText().contains("Subscribed"));
        Assert.assertTrue(message2.getText().contains("Message send. "));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
