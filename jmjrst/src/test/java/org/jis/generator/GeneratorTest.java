package org.jis.generator;

import static org.junit.Assert.*;

import java.io.Console;
import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;

import org.jis.Main;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GeneratorTest {
	
	private Generator generator;
	private File file;
	private String path;

	@Before
	public void setUp() throws Exception {
		generator = new Generator(Main.getInstance(), 0);
	}

	/**
	 * Test function rotate()
	 */
	@Test (expected = IllegalArgumentException.class)
	public void parameterNull() {
		generator.rotate(null);
		generator.generateSingle(null, null);
	}
	

}
