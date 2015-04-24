package org.jis.generator;

import static org.junit.Assert.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;

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
		 * Test 1. eine beliebige Instanz von BufferedImage 
		 */
		assertEquals(bi, generator.rotateImage(bi, 0.0));
		
		/*
		 * Test 2. null einbuchen
		 */
	    assertEquals(null, generator.rotateImage(null, 0.0));
	}
	
	/**
	 * Aufgabe 2.e , expected IllegalArgumentException
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testIllegalArgumentException() {
		generator.rotateImage(bi, 1.0);
	}

}
