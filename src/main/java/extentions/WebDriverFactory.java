package extentions;

import config.AppConfig;
import config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverFactory {
    public static WebDriver get() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverConfig.WAIT_TIMEOUT_DEFAULT, TimeUnit.SECONDS);
        driver.get(AppConfig.URL);
        return driver;
    }
}
