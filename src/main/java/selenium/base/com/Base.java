package selenium.base.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.util.com.WebEventListener;

public class Base {
	public static WebDriver driver;
	public static EventFiringWebDriver edriver;

	public static WebEventListener listnerobj = new WebEventListener();

	public static void initialize(String URL, String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		edriver = new EventFiringWebDriver(driver);
		edriver.register(listnerobj);
		driver = edriver;

		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}
}
