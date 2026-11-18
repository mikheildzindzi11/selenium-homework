package ge.tbc.testautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowhandlingTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://chatgpt.com/");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://myauto.ge/");
    }

    @Test
    public void handlingWindow() throws InterruptedException {
        WebElement acceptCoookie = driver.findElement(By.xpath("//div[@id=\"cookiescript_accept\"]"));
        acceptCoookie.click();
        WebElement acceptPolicy = driver.findElement(By.xpath("//button[@aria-label=\"დახურვა\"]"));
        acceptPolicy.click();

        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs){
            driver.switchTo().window(tab);

            if (driver.getCurrentUrl().contains("https://chatgpt.com/")){
                break;
            }
        }


        Assert.assertEquals(driver.findElement(By.xpath("//span[@class=\"x1pj2y49\"]")).getText(), "Where should we begin?");

        for (String tab : allTabs){
            driver.switchTo().window(tab);

            if(driver.getCurrentUrl().contains("https://www.youtube.com/")){
                break;
            }
        }

        Assert.assertEquals(driver.findElement(By.xpath("//h2[@id=\"title-container\"]")).getText(), "Try searching to get started");

        String currentTab = driver.getWindowHandle();

        for (String tab : allTabs){
            if(!tab.equals(currentTab)){
                driver.switchTo().window(tab);
                driver.close();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
