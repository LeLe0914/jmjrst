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

	@Test
	public void test() {	
		System.out.println(bi.getHeight() + " " + bi.getWidth());
	}

}
