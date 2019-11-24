package selenium.selfstudy.com;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import selenium.base.com.Base;

public class DiffrentDataForDiffrentMethodTest extends Base {

	@Test(dataProvider = "dataprovider", priority = 1)

	public void verifyDiffrentDataTest(String userName, String passWord) {
		Base.initialize("https://www.netflix.com/in/login", "chrome");

		WebElement name = driver.findElement(By.name("userLoginId"));
		name.sendKeys(userName);

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(passWord);
	}

	@Test(dataProvider = "dataprovider", priority = 2 )
	public void verifySameDataTest(String userName, String passWord) {
		Base.initialize("https://www.netflix.com/in/login", "chrome");

		WebElement name = driver.findElement(By.name("userLoginId"));
		name.sendKeys(userName);

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(passWord);
	}

	@DataProvider(name = "dataprovider")
	public Object[][] createData(Method name) {
	
		if (name.getName().equals("verifyDiffrentDataTest")) {
			return new Object[][] { { "John1", "Smith1" }, { "Javin1", "Paul1" }, { "James1", "Gosling1" }, };
		}

		if (name.getName().equals("verifySameDataTest")) {
			return new Object[][]{{"John","Smith"},{"Javin","Paul"},{"James","Gosling"},};
		}
		return null;
		

	}

}
