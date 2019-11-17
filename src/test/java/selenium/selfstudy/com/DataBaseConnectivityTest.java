package selenium.selfstudy.com;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import selenium.base.com.Base;

/**
 * Unit test for simple App.
 * 
 */

public class DataBaseConnectivityTest {

	DBConnection object = new DBConnection();

	@Test(priority = 1)

	public void verifyEmployeeDetailAddition() throws SQLException {

		String query = "insert into Employee values ('Rajesh',101,'rajesh.pathak@nokia.com')";
		object.insertData(query);

	}

	@Test(priority = 2)
	public void getEmployeeDateils() throws SQLException {
		String query = "select * from Employee";
		ResultSet result = object.getData(query);

		while (result.next()) {
			System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3));

		}

	}

	
}
