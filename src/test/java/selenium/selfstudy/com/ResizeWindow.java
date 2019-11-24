package selenium.selfstudy.com;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import selenium.base.com.Base;

public class ResizeWindow extends Base {

	@Test
	public void verifyResizeBrowserWindowTest() {
		Base.initialize("http://www.facebook.com", "CHrome");
		Point p=driver.manage().window().getPosition();
		System.out.println("X co-ordinate" +p.getX());
		
		System.out.println("Y co-ordinate" +p.getY());
		Dimension d= new Dimension(10, 15);
		driver.manage().window().setSize(d);
	}

}
