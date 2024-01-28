
package datadrivertest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations. Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotDemo {

           static WebDriver driver;

           @BeforeMethod
           void setup() {
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
               
               driver.get("https://google.com");
           }

           @AfterMethod
           void close() {
              driver.quit();
           }

           @Test
           void screenShot() {
        	   ScreenShot.takeScreenShot(driver);

           }
}