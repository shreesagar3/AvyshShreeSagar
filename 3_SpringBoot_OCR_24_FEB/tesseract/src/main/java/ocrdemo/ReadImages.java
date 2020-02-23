package ocrdemo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class ReadImages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tesseract image = new Tesseract();
		image.setDatapath("/home/hackerman/Documents/workspace-spring-tool-suite-4-4.5.1.RELEASE/tessdata");
		try {
			String result = image.doOCR(new File("/home/hackerman/Downloads/image.jpeg"));
			System.out.println("Result are : "+result);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			System.out.println("Gadbad hai :" + e.getMessage());
		}
	}
}
