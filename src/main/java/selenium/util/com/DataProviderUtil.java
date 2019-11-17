package selenium.util.com;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

	@DataProvider(name = "dataProvider")
	public static Object[][] getData() {
		Object[][] arr = new Object[3][2];
		arr[0][0] = "Rajesh1";
		arr[0][1] = "Pathak1";
		arr[1][0] = "Rajesh2";
		arr[1][1] = "Pathak2";
		arr[2][0] = "Rajesh3";
		arr[2][1] = "Rajesh3";
		return arr;

	}
}
