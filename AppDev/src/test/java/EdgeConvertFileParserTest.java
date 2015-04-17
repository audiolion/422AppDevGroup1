package test;

import static org.junit.Assert.*;

import java.io.File;

import main.EdgeConvertFileParser;

import org.junit.Before;
import org.junit.Test;


public class EdgeConvertFileParserTest {

EdgeConvertFileParser testObject;
	
	@Before
	public void setUp() throws Exception {
		testObject = new EdgeConvertFileParser(new File("Courses.edg"));
	}
	
	@Test
	public void testEdgeConvertFileParser() {
		assertNotNull(testObject);
	}

	@Test
	public void testGetEdgeTables() {
		assertNotNull(testObject.getEdgeTables());
	}

	@Test
	public void testGetEdgeFields() {
		assertNotNull(testObject.getEdgeFields());
	}

	@Test
	public void testOpenFile() {
		try{
			EdgeConvertFileParser test = new EdgeConvertFileParser(new File("Courses.edg"));
		}catch(Exception e){
			fail("Exception thrown: " + e.getMessage());
		}
	}

}
