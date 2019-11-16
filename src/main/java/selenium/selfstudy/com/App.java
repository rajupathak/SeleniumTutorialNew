package selenium.selfstudy.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App {
	private WebDriver driver;

	@BeforeClass
	public void initializeDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void verifyLoginTest() throws InterruptedException {

		driver.manage().window().maximize();
		driver.get("https://online.actitime.com/nokia/user/submit_tt.do");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// Enter Credentials:

		WebElement userName = driver.findElement(By.name("username"));
		userName.clear();
		userName.sendKeys("rajupthk01@gmail.com");

		WebElement password = driver.findElement(By.name("pwd"));
		password.clear();
		password.sendKeys("pass123");

		// Click on login button

		driver.findElement(By.xpath("//a[@id='loginButton']")).click();

		String expactedPageTitle = "actiTIME - Login";
		String actaulpageTitle = driver.getTitle();

		Assert.assertEquals(actaulpageTitle, expactedPageTitle, "Page title not matched after login");
		Thread.sleep(500);

	}

	@Test(priority = 2)
	public void veridyAddNewTask() throws InterruptedException {

		// Click on New Button
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement newButton = wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//nobr/span[@id='addTasksLink']"))));

		newButton.click();
		Thread.sleep(500);
		// Wait for popup to load
		boolean element = driver.findElement(By.xpath("//div[text()='                Create New Tasks            ']"))
				.isDisplayed();
		try {
			if (element) {

			}
		} catch (Exception e) {
			System.out.println("element not displayed");
		}
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			// driver.quit();
		}
	}
}
