package org.jis.generator;

import static org.junit.Assert.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RotateImageTest { 
	
	private Generator generator;
	private File file = new File("src/test/resources/picture.jpg");
	private BufferedImage bi;
	private BufferedImage rotatedBi;
	private int picWidth;
	private int picHeight;

	@Before
	public void setUp() throws Exception {
		generator = new Generator(null, 0);
		bi = ImageIO.read(file);
		picWidth = bi.getWidth();
		picHeight = bi.getHeight();
	}

	/**
	 * Aufgabe 2.d Null or No-change
	 */
	@Test
	public void testNullOrNochange() {
		/*
		 *  eine beliebige Instanz von BufferedImage 
		 */
		rotatedBi = generator.rotateImage(bi, 0.0);
		assertEquals(bi, rotatedBi);
	}
	
	/**
	 * Aufgabe 2.e , expected IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		generator.rotateImage(bi, 1.0);
	}
	
	/**
	 * Aufgabe 2.f, NullPointerException
	 */
	@Test (expected = NullPointerException.class)
	public void testNullPointerException() {
		generator.rotateImage(null, 1.0);
	}
	
	/**
	 * Aufgabe 2.g, exchange width and height in 90 Grad and 270 Grad
	 */
	@Test
	public void testRotate90Degree() {
		/*
		 * 90 Grad
		 */
		rotatedBi = generator.rotateImage(bi, (Math.PI / 2));
		assertEquals(picWidth, rotatedBi.getHeight());
		assertEquals(picHeight, rotatedBi.getWidth());
	}
	
	@Test
	public void testRotate270Degree() {
		/*
		 * 270 Grad
		 */
		rotatedBi = generator.rotateImage(bi, (Math.PI / 2 + Math.PI));
		assertEquals(picWidth, rotatedBi.getHeight());
		assertEquals(picHeight, rotatedBi.getWidth());
	}
	
	@After
	public void tearDown() {
		SimpleDateFormat timestampFormat= new SimpleDateFormat("HHmmss_SSS");
		Date timestamp = new Date(System.currentTimeMillis());
		String timestampStr = timestampFormat.format(timestamp);
		
		String fileName = "rotatedPicture_" + timestampStr + ".jpg";
		String path = "target/testDate/";
		File folder = new File(path);
		File output = new File(path + fileName);
		try {
			if (!folder.exists()) {
				folder.mkdirs();
			}
			if (rotatedBi == null) {
				ImageIO.write(bi, "jpg", output);
			} else {
				ImageIO.write(rotatedBi, "jpg", output);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
