package test;
import main.EdgeField;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EdgeFieldTest {

        EdgeField testObj;
	@Before
	public void setUp() throws Exception {
            testObj = new EdgeField("1|testName");
	}

	@Test
	public void testEdgeField() {
		assertNotNull("verify object was created",testObj);
	}

	@Test
	public void testGetNumFigure() {
		assertEquals("check if num is correct",1,testObj.getNumFigure());
	}

	@Test
	public void testGetName() {
		assertEquals("check if name is correct","testName",testObj.getName());
	}

	@Test
	public void testGetTableID() {
		assertEquals("inital table ID should be 0",0,testObj.getTableID());
	}

	@Test
	public void testSetTableID() {
                testObj.setTableID(1);
		assertEquals("table ID should be what you set it to",1,testObj.getTableID());
	}

	@Test
	public void testGetTableBound() {
		assertEquals("initial table bound should be 0",0,testObj.getTableBound());
	}

	@Test
	public void testSetTableBound() {
		 testObj.setTableBound(1);
		assertEquals("table bound should be what you set it to",1,testObj.getTableBound());
	}

	@Test
	public void testGetFieldBound() {
		assertEquals("initial filed bound should be 0",0,testObj.getFieldBound());
	}

	@Test
	public void testSetFieldBound() {
		testObj.setFieldBound(1);
		assertEquals("field bound should be what you set it to",1,testObj.getFieldBound());
	}

	@Test
	public void testGetDisallowNull() {
		assertEquals("disallow null should be defaul false",false,testObj.getDisallowNull());
	}

	@Test
	public void testSetDisallowNull() {
		testObj.setDisallowNull(true);
                assertEquals("Make sure disallow null is what you set it to",true,testObj.getDisallowNull());
	}

	@Test
	public void testGetIsPrimaryKey() {
		assertEquals("primary should be defaul false",false,testObj.getIsPrimaryKey());
	}

	@Test
	public void testSetIsPrimaryKey() {
		testObj.setIsPrimaryKey(true);
                assertEquals("Make sure isprimarykey is what you set it to",true,testObj.getIsPrimaryKey());
	}

	@Test
	public void testGetDefaultValue() {
		assertEquals("default value shoiuld be \"\"","",testObj.getDefaultValue());
	}

	@Test
	public void testSetDefaultValue() {
		testObj.setDefaultValue("test");
                assertEquals("default value should be what you set it to","test",testObj.getDefaultValue());
	}

	@Test
	public void testGetVarcharValue() {
		assertEquals("varchat value should be equal to the conatant",1,testObj.getVarcharValue());
	}

	@Test
	public void testSetVarcharValue() {
		testObj.setVarcharValue(2);
                assertEquals("varchar value should be what you set it to",2,testObj.getVarcharValue());
	}

	@Test
	public void testGetDataType() {
		assertEquals("datatype should start off as 0",0,testObj.getDataType());
	}

	@Test
	public void testSetDataType() {
		testObj.setDataType(2);
                assertEquals("data type should be what you set it to",2,testObj.getDataType());
	}



}
