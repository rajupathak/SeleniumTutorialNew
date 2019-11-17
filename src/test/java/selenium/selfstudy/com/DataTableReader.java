package selenium.selfstudy.com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.base.com.Base;
import selenium.util.com.Xls_Reader;

public class DataTableReader extends Base {

	Base obj = new Base();
	Xls_Reader readerObj = new Xls_Reader(
			"C:\\Users\\rajepath\\Desktop\\NetAct Docs\\SeleniumWorkSpace\\selfstudy.com\\TestData\\TestData.xlsx");

	@Test
	public void readDataTableTest() {

		obj.initialize("https://www.w3schools.com/html/html_tables.asp","chrome");

		// Total number of row in datatable

		String xpath_company_firstHalf = "//table[@id='customers']/tbody/tr[";

		String xpath_company_secondHalf = "]/td[1]";

		String xpath_Contact_firstHalf = "//table[@id='customers']/tbody/tr[";

		String xpath_Contact_secondHalf = "]/td[2]";

		String xpath_Country_firstHalf = "//table[@id='customers']/tbody/tr[";

		String xpath_Country_secondHalf = "]/td[3]";

		List<WebElement> totalRow = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		System.out.println(totalRow.size());
		if (!readerObj.isSheetExist("TableData")) {
			readerObj.addSheet("TableData");
			readerObj.addColumn("TableData", "Comapny");
			readerObj.addColumn("TableData", "Conatct");
			readerObj.addColumn("TableData", "Country");
			
		}
		System.out.println("Comapny" + " " + "Conatct" + " " + "Country");
		for (int i = 2; i <= totalRow.size(); i++) {

			String commpany_Xpath = xpath_company_firstHalf + i + xpath_company_secondHalf;

			String company_Name = driver.findElement(By.xpath(commpany_Xpath)).getText();

			readerObj.setCellData("TableData", "Comapny", i, company_Name);
			String Contact_Xpath = xpath_Contact_firstHalf + i + xpath_Contact_secondHalf;
			String Contact_Name = driver.findElement(By.xpath(Contact_Xpath)).getText();
			readerObj.setCellData("TableData", "Conatct", i, Contact_Name);
			String Country_Xpath = xpath_Country_firstHalf + i + xpath_Country_secondHalf;
			String Country_Name = driver.findElement(By.xpath(Country_Xpath)).getText();
			readerObj.setCellData("TableData", "Country", i, Country_Name);
			System.out.println(company_Name + " " + Contact_Name + " " + Country_Name);

		}

	}

}
