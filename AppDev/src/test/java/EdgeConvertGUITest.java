package test;
import static org.junit.Assert.*;
import main.EdgeConvertGUI;

import org.junit.Before;
import org.junit.Test;


public class EdgeConvertGUITest {

	EdgeConvertGUI testObject;
	
	@Before
	public void setUp() throws Exception {
		testObject = new EdgeConvertGUI();
	}

	@Test
	public void testEdgeConvertGUI() {
		assertNotNull(testObject);
	}

	@Test
	public void testShowGUI() {
		try{
			testObject.showGUI();
		}catch(Exception e){
			fail("exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void testSetReadSuccess() {
		testObject.setReadSuccess(false);
		assertEquals(testObject.getReadSuccess(), false);
	}

	@Test
	public void testGetReadSuccess() {
		assertEquals(testObject.getReadSuccess(), false);
	}

}
