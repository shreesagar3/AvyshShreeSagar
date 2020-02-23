package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.Tesseract;

@SpringBootApplication
@RestController
@RequestMapping("/ocr")
public class TesseractApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesseractApplication.class, args);
		System.out.print("Spring Started Sucussfully...\n");
	}
	//Method for OCR
	@PostMapping()
	public ResponseEntity<String> OcrRequest(@RequestParam(name="file") MultipartFile file) throws Exception{

		String result = "";
		
		try {
			BufferedImage img = ImageIO.read(file.getInputStream());
			
	        Tesseract tesseract = new Tesseract();
	        
	        tesseract.setDatapath("/home/hackerman/Documents/workspace-spring-tool-suite-4-4.5.1.RELEASE/tessdata");
	        result = "";	     
	        
            tesseract.setLanguage("eng");
			result = tesseract.doOCR(img);	        
		} catch (IOException e) {
			throw new Exception("Some Error Dude");
		}
		return ResponseEntity.ok(result);						
	}


}
