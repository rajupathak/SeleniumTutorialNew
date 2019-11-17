package selenium.util.com;

import java.util.ArrayList;

public class ExcelReadUtil {

	static Xls_Reader readerObj;

	public static ArrayList<Object[]> getDataFromExcelSheet() {

		ArrayList<Object[]> data = new ArrayList<>();

		try {
			readerObj = new Xls_Reader(
					"C:\\Users\\rajepath\\Desktop\\NetAct Docs\\SeleniumWorkSpace\\selfstudy.com\\TestData\\NetFlixCredentials.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}

		int rowCount = readerObj.getRowCount("loginData");

		for (int row = 2; row <= rowCount; row++) {
			String userName = readerObj.getCellData("loginData", "userName", row);

			String passWord = readerObj.getCellData("loginData", "passWord", row);
			Object[] arr = { userName, passWord };
			data.add(arr);
		}

		return data;
	}

}
