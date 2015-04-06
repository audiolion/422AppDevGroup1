package test;
import static org.junit.Assert.*;

import java.io.File;

import main.EdgeConvertFileParser;
import main.EdgeTable;

import org.junit.Before;
import org.junit.Test;


public class EdgeTableTest {
EdgeTable testObject;
	
	@Before
	public void setUp() throws Exception{
		testObject = new EdgeTable("1|testTable");
	}
	
	@Test
	public void testEdgeTable() {
		assertNotNull(testObject);
	}

	@Test
	public void testGetNumFigure() {
		assertEquals(testObject.getNumFigure(), 1);
	}

	@Test
	public void testGetName() {
		assertEquals(testObject.getName(), "testTable");
	}

	@Test
	public void testAddRelatedTable() {
		int initialLength = testObject.getRelatedTablesArray().length;
		testObject.addRelatedTable(16);
		int updatedLength = testObject.getRelatedTablesArray().length;
		assertEquals(initialLength+1, updatedLength);
	}

	@Test
	public void testGetRelatedTablesArray() {
		assertNull(testObject.getRelatedTablesArray());
		testObject.addRelatedTable(13);
		assertEquals(testObject.getRelatedTablesArray().length, 1);
		assertEquals(testObject.getRelatedTablesArray()[0], 13);
	}

	@Test
	public void testGetRelatedFieldsArray() {
		assertNull(testObject.getRelatedFieldsArray());
		testObject.setRelatedField(1, 13);
		assertEquals(testObject.getRelatedFieldsArray().length, 1);
		assertEquals(testObject.getRelatedFieldsArray()[1], 13);
	}

	@Test
	public void testSetRelatedField() {
		testObject.setRelatedField(0, 1);
		int[] test = testObject.getRelatedFieldsArray();
		assertEquals(test[0], 1);
	}

	@Test
	public void testGetNativeFieldsArray() {
		assertNull(testObject.getNativeFieldsArray());
		testObject.addNativeField(1);
		assertEquals(testObject.getNativeFieldsArray().length, 1);
		assertEquals(testObject.getNativeFieldsArray()[0], 1);
	}

	@Test
	public void testAddNativeField() {
		int initialLength = testObject.getNativeFieldsArray().length;
		testObject.addNativeField(17);
		int updatedLength = testObject.getNativeFieldsArray().length;
		assertEquals(initialLength+1, updatedLength);
	}

	@Test
	public void testMoveFieldUp() {
		EdgeConvertFileParser test = new EdgeConvertFileParser(new File("Courses.edg"));
		
		EdgeTable[] tbs = test.getEdgeTables();
		tbs[0].addNativeField(1);
		tbs[0].addNativeField(2);
		tbs[0].setRelatedField(1, 2);
		tbs[0].setRelatedField(2, 1);
		tbs[0].makeArrays();
		tbs[0].moveFieldUp(1);
		assertEquals(tbs[0].getNativeFieldsArray()[0], 2);
	}

	@Test
	public void testMoveFieldDown() {
		EdgeConvertFileParser test = new EdgeConvertFileParser(new File("Courses.edg"));
		
		EdgeTable[] tbs = test.getEdgeTables();
		tbs[0].addNativeField(1);
		tbs[0].addNativeField(2);
		tbs[0].setRelatedField(1, 2);
		tbs[0].setRelatedField(2, 1);
		tbs[0].makeArrays();
		tbs[0].moveFieldDown(0);
		assertEquals(tbs[0].getNativeFieldsArray()[1], 1);
	}

	@Test
	public void testMakeArrays() {
		testObject.addNativeField(1);
		testObject.addNativeField(2);
		testObject.addRelatedTable(1);
		testObject.addRelatedTable(2);
		testObject.makeArrays();
		assertEquals(testObject.getRelatedFieldsArray().length, 2);
		assertEquals(testObject.getRelatedTablesArray().length, 2);
		assertEquals(testObject.getNativeFieldsArray().length, 2);
		
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
