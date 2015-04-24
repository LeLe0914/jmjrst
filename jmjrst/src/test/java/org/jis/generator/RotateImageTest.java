package org.jis.generator;

import static org.junit.Assert.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class RotateImageTest { 
	
	private Generator generator;
	private File file = new File("src/test/resources/picture.jpg");
	private BufferedImage bi;

	@Before
	public void setUp() throws Exception {
		generator = new Generator(null, 0);
		bi = ImageIO.read(file);
	}

	/**
	 * Aufgabe 2.d Null or No-change
	 */
	@Test
	public void testNullOrNochange() {
		/*
		 *  eine beliebige Instanz von BufferedImage 
		 */
		assertEquals(bi, generator.rotateImage(bi, 0.0));
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
	public void testExchangeWidthAndHeight() {
		int picWidth = bi.getWidth();
		int picHeight = bi.getHeight();
		BufferedImage rotatedBi;
		System.out.println(picWidth + " " + picHeight);
		
		/*
		 * 90 Grad
		 */
		rotatedBi = generator.rotateImage(bi, (Math.PI / 2));
		assertEquals(picWidth, rotatedBi.getHeight());
		assertEquals(picHeight, rotatedBi.getWidth());
		
		/*
		 * 270 Grad
		 */
		rotatedBi = generator.rotateImage(bi, (Math.PI / 2 + Math.PI));
		assertEquals(picWidth, rotatedBi.getHeight());
		assertEquals(picHeight, rotatedBi.getWidth());
	}

}
