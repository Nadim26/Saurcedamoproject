package datadrivertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemoLogin {
	
		public WebDriver driver;

		@BeforeMethod
		public void setup() {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");		
			this.driver = new ChromeDriver(options);
			this.driver.get("https://www.saucedemo.com/");		
		}
		
		@Test(dataProviderClass= UserDataProvider.class ,  dataProvider = "userData")
		public void LogInTesst(String username, String password) throws InterruptedException {
			driver.findElement(By.id("user-name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[1]/div")).click();
			Thread.sleep(2000);
			
			String actualLogoutTest = driver.findElement(By.id("logout_sidebar_link")).getText();
			String expectedLogoutText = "Logout";
			Assert.assertEquals(actualLogoutTest, expectedLogoutText);
			driver.findElement(By.id("logout_sidebar_link")).click();
		}
		@Test(dataProviderClass= UserDataProvider.class ,  dataProvider = "userData")
		public void aboutpageTest(String username, String password) throws InterruptedException {
			driver.findElement(By.id("user-name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[1]/div")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("about_sidebar_link")).click();
			String actualLogoutTest = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[1]/div[1]/div/div[4]/div[1]/a/button")).getText();
			String expectedLogoutText = "Try it free";
			Assert.assertEquals(actualLogoutTest, expectedLogoutText);
			
		}
		@Test(dataProviderClass= UserDataProvider.class ,  dataProvider = "userData")
		public void Filteropton(String username, String password) throws InterruptedException {
			driver.findElement(By.id("user-name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]")).click();
			String actualLogoutTest = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
			String expectedLogoutText = "Sauce Labs Backpack";
			Assert.assertEquals(actualLogoutTest, expectedLogoutText);
			
		}
		@Test(dataProviderClass= UserDataProvider.class ,  dataProvider = "userData")
		public void Addtocard(String username, String password) throws InterruptedException {
			driver.findElement(By.id("user-name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
			String actualLogoutTest = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[1]")).getText();
			String expectedLogoutText = "QTY";
			Assert.assertEquals(actualLogoutTest, expectedLogoutText);
//			driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
//			String actualLogoutTest1 = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
//			String expectedLogoutText1 = "1";
//			Assert.assertEquals(actualLogoutTest1, expectedLogoutText1);
		}
		@Test(dataProviderClass= UserDataProvider.class ,  dataProvider = "userData")
		public void productdetails(String username, String password) throws InterruptedException {
			driver.findElement(By.id("user-name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
			Thread.sleep(2000);

			String actualLogoutTest = driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).getText();
			String expectedLogoutText = "Back to products";
			Assert.assertEquals(actualLogoutTest, expectedLogoutText);

//			driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
//			driver.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]")).click();
//			Thread.sleep(2000);
			
//			String actualLogoutTest1 = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
//			String expectedLogoutText1 = "1";
//			Assert.assertEquals(actualLogoutTest1, expectedLogoutText1);
		}
		
		
	@AfterMethod
	public void close(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()) {
			ScreenShot.takeScreenShot(driver);
		}
		
		driver.close();
	}		
}
