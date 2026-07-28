package ge.tbc.testautomation;

import ge.tbc.testautomation.data.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ScrollTest {

    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void scrollTest() {
        driver.get(Constants.TECHLISTIC_WEBTABLE_ARTICLE_URL);

        // 1) scroll through and collect every code example
        List<WebElement> codeBlocks = driver.findElements(By.cssSelector("pre, code"));
        Map<String, String> codeExamplesBySection = new LinkedHashMap<>();
        int unlabeledCount = 0;

        for (WebElement codeBlock : codeBlocks) {
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", codeBlock);

            List<WebElement> precedingHeadings = codeBlock.findElements(
                    By.xpath("preceding::*[self::h2 or self::h3 or self::h4][1]"));
            String sectionName = precedingHeadings.isEmpty()
                    ? "section-" + (++unlabeledCount)
                    : precedingHeadings.get(0).getText().trim();

            codeExamplesBySection.put(sectionName, codeBlock.getText());
        }

        Assert.assertTrue(codeExamplesBySection.size() > 0, "Expected at least one code example to be captured");
        System.out.println("Captured " + codeExamplesBySection.size() + " code example(s)");

        // 2) scroll to "Popular Tutorials"
        WebElement popularTutorialsHeading = driver.findElement(By.xpath(
                "//*[self::h2 or self::h3 or self::h4][contains(., '"
                        + Constants.POPULAR_TUTORIALS_HEADING_TEXT + "')]"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", popularTutorialsHeading);

        WebElement popularTutorialsWidget = popularTutorialsHeading.findElement(By.xpath("./.."));
        List<WebElement> tutorialLinks = popularTutorialsWidget.findElements(By.tagName("a"));

        Map<String, String> tutorialLinksByLabel = new LinkedHashMap<>();
        for (WebElement link : tutorialLinks) {
            String label = link.getText().trim();
            String href = link.getAttribute(Constants.HREF_ATTRIBUTE);
            if (!label.isEmpty() && href != null) {
                tutorialLinksByLabel.put(label, href);
            }
        }
        System.out.println(tutorialLinksByLabel);

        // 3) scroll to the bottom of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}