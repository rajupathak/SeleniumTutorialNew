package selenium.selfstudy.com;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import selenium.base.com.Base;

public class MultiBrowserTesting extends Base {

	Base baseObject = new Base();

	@Test
	@Parameters("browsers")
	public void runTestInMultipleBrowser(String browserName) {

		baseObject.initialize("https://www.facebook.com/", browserName);

		Assert.assertEquals("Facebook – log in or sign up", driver.getTitle());

	}

	@AfterMethod
	public static void tearDown() {
		Base.tearDown();
	}

}
