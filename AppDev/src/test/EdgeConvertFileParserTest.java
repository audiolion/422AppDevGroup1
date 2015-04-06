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
	public void testConstructor() {
		assertNotNull(testObject);
	}
	
	@Test
	public void testgetEdgeFields(){
		assertNotNull(testObject.getEdgeFields());
	}
	
	@Test
	public void testgetEdgeTables(){
		assertNotNull(testObject.getEdgeTables());
	}

	@Test
	public void testEdgeConvertFileParser() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseEdgeFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseSaveFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEdgeTables() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEdgeFields() {
		fail("Not yet implemented");
	}

	@Test
	public void testOpenFile() {
		fail("Not yet implemented");
	}

}
