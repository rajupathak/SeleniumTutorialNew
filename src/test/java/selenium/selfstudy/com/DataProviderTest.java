package selenium.selfstudy.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.base.com.Base;
import selenium.util.com.DataProviderUtil;

public class DataProviderTest extends Base {
	Base baseObject = new Base();

	@Test(dataProvider = "dataProvider", dataProviderClass = DataProviderUtil.class)

	public void loginWithDiffrentCredentials(String userName, String passWord) {

		baseObject.initialize("https://www.netflix.com/in/login", "chrome");

		WebElement name = driver.findElement(By.name("userLoginId"));
		name.sendKeys(userName);

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(passWord);
	}

}
