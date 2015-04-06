package test;
import static org.junit.Assert.*;
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
	public void testgetNumFigure(){
		assertEquals(testObject.getNumFigure(), 1);
	}
	
	@Test
	public void testgetName(){
		assertEquals(testObject.getName(), "testTable");
	}
	
	@Test
	public void testaddRelatedTable(){
		int initialLength = testObject.getRelatedTablesArray().length;
		testObject.addRelatedTable(16);
		int updatedLength = testObject.getRelatedTablesArray().length;
		assertEquals(initialLength+1, updatedLength);
	}
	
	@Test
	public void testaddNativeField(){
		int initialLength = testObject.getNativeFieldsArray().length;
		testObject.addNativeField(17);
		int updatedLength = testObject.getNativeFieldsArray().length;
		assertEquals(initialLength+1, updatedLength);
	}
	
	@Test
	public void testsetRelatedField(){
		testObject.setRelatedField(0, 1);
		int[] test = testObject.getRelatedFieldsArray();
		assertEquals(test[0], 1);
	}

	@Test
	public void testEdgeTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumFigure() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddRelatedTable() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRelatedTablesArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRelatedFieldsArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRelatedField() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNativeFieldsArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNativeField() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveFieldUp() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveFieldDown() {
		fail("Not yet implemented");
	}

	@Test
	public void testMakeArrays() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
