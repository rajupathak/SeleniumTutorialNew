package selenium.selfstudy.com;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import selenium.base.com.Base;
import selenium.util.com.ImageReaderUtil;

public class ImageComparison extends Base {

	@Test
	public void verifyImageComparisonTest() throws IOException {

		Base.initialize("https://www.netflix.com/in/", "chrome");

		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShot, new File("outputImage.jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		File inputImage = new File("inputImage.jpg");

		File outPutImage = new File("outputImage.jpg");

		int sizeOfImputImage = ImageReaderUtil.readImageSize(inputImage);
		System.out.println(sizeOfImputImage);
		int sizeOfoutPutImage = ImageReaderUtil.readImageSize(outPutImage);
		System.out.println(sizeOfoutPutImage);
		Assert.assertEquals(sizeOfoutPutImage, sizeOfImputImage, "Size of Image is not same");
	}

	@AfterMethod
	public static void tearDown() {
		Base.tearDown();
	}
}
