import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class Mercurytours_AutomadeTest {

    WebDriver driver = new ChromeDriver();
    By registerLinkLocator = By.linkText("REGISTER");
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");

    By usernameLocator = By.id("email");
    By passwordlocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
    By enviarBtnLocator = By.name("submit");
    By userLocator = By.name("userName");
    By passLocator = By.name("password");
    By submitLocator = By.name("submit");
    By homepageLocator = By.xpath("(//a[@href='index.php'])[1]"); //
    By successRegisterLocator = By.cssSelector("body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(1) > font > b");

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Usuario\\Downloads\\chromedriver-win64\\chromedriver.exe");

        Mercurytours_AutomadeTest test = new Mercurytours_AutomadeTest();
        test.starTest();

    }
    public void starTest() throws InterruptedException {

        driver.get("https://demo.guru99.com/test/newtours/register.php");

        registerUser();
        sigIn();
    }

    public void registerUser() throws InterruptedException {
        driver.findElement(registerLinkLocator).click();

            Thread.sleep(2000);


        if (driver.findElement(registerPageLocator).isDisplayed()){
            driver.findElement(usernameLocator).sendKeys("pruebaadmin");
            driver.findElement(passwordlocator).sendKeys("pass1");
            driver.findElement(confirmPasswordLocator).sendKeys("pass1");

            driver.findElement(enviarBtnLocator).click();
        }

        List <WebElement> fonts = driver.findElements(By.tagName("font"));

        assertEquals("Note: Your user name is pruebaadmin.",fonts.get(5).getText());
        driver.findElement(homepageLocator).click();
    }

    private void sigIn() {

        if (driver.findElement(userLocator).isDisplayed()){
            driver.findElement(userLocator).sendKeys("pruebaadmin");
            driver.findElement(passLocator).sendKeys("pass1");
            driver.findElement(submitLocator).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List <WebElement> fonts = driver.findElements(By.tagName("font"));

            assertEquals("Thank you for Loggin.",driver.findElement(successRegisterLocator).getText());
        }
        else {
            System.out.println("Username textbox was not present");
        }
        driver.quit();
    }
}
