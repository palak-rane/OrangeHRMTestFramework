package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver driver = null;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equals("ie")) {
                System.setProperty("webdriver.ie.driver", "drivers/IEdriverServer.exe");
                driver = new InternetExplorerDriver();
            }
        }
        return driver;
    }

    public static void LaunchUrl(String url) {
        driver.get(url);
    }

   // public static void CloseDriver() {
       // driver.close();

       /* public void waitElementToBeVisible(WebElement webElement)
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } */

}

