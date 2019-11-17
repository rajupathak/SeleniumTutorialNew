package selenium.selfstudy.com;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.base.com.Base;

public class BrokenListTest extends Base {

	@Test
	public void veirfyBrokenLinkTest() throws MalformedURLException, IOException {
		Base.initialize("http://facebook.com", "chrome");
		List<WebElement> allLinkList = driver.findElements(By.tagName("a"));
		allLinkList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total number of anchor and image link --->" + allLinkList.size());

		List<WebElement> totalActiveLink = new ArrayList<WebElement>();
		for (int i = 0; i < allLinkList.size(); i++) {
			// System.out.println(allLinkList.get(i).getAttribute("href"));

			if (allLinkList.get(i).getAttribute("href") != null
					&& (!allLinkList.get(i).getAttribute("href").contains("javascript"))) {
				totalActiveLink.add(allLinkList.get(i));

			}

		}
		System.out.println("Total number of valid anchor and image  link --->" + totalActiveLink.size());

		for (int j = 0; j < totalActiveLink.size(); j++) {

			HttpURLConnection con = (HttpURLConnection) new URL(totalActiveLink.get(j).getAttribute("href"))
					.openConnection();
			System.out.println(con);
			con.connect();

			String message = con.getResponseMessage();
			System.out.println(message);
			con.disconnect();
			System.out.println(totalActiveLink.get(j).getAttribute("href") + "->>>" + message);

		}

	}

	@AfterMethod
	public static void tearDown() {
		Base.tearDown();
	}
}
