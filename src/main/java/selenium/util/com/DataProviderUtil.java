package selenium.util.com;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

	@DataProvider(name = "dataProvider")
	public static Iterator<Object[]> getData() {
		ArrayList<Object[]> obj = ExcelReadUtil.getDataFromExcelSheet();
		return obj.iterator();

	}
}
