import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.junit.Assert.assertTrue;

public class GoogleSearchTest {

    static By videolinkLocator = By.xpath("//h3[contains(text(), 'YouTube: Inic' )]");
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Downloads\\chromedriver-win64\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();


        driver.get("https://www.google.com");


        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Youtube");

        searchBox.submit();

        Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(2))
                .ignoring(NoSuchElementException.class);

        WebElement video = fwait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(videolinkLocator);
            }
        });
        assertTrue(driver.findElement(videolinkLocator).isDisplayed());
        driver.findElement(videolinkLocator).click();

        driver.quit();
    }
}
