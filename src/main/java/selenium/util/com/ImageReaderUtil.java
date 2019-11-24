package selenium.util.com;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReaderUtil {

	public static int readImageSize(File path) throws IOException {

		BufferedImage buffredImage = ImageIO.read(path);
		DataBuffer dataBuffer = buffredImage.getData().getDataBuffer();
		int sizeofImage = dataBuffer.getSize();
		return sizeofImage;

	}

}
