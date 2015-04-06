package test;
import static org.junit.Assert.*;

import java.io.File;

import main.ExampleFileFilter;

import org.junit.Before;
import org.junit.Test;


public class ExampleFileFilterTest {

	ExampleFileFilter defaultCons;
	ExampleFileFilter stringCons;
	ExampleFileFilter stringDescCons;
	ExampleFileFilter strArrayCons;
	ExampleFileFilter strArrayDescCons;
	File edg;
	File text;
	File bogus;
	
	@Before
	public void setUp() throws Exception {
		defaultCons = new ExampleFileFilter();
		stringCons = new ExampleFileFilter(new String("edg"));
		stringDescCons = new ExampleFileFilter(new String("edg"),"EDG files");
		strArrayCons = new ExampleFileFilter(new String[]{"edg","txt"});
		strArrayDescCons = new ExampleFileFilter(new String[]{"edg","txt"}, "EDG & TXT files");
		
		edg = new File("Courses.edg");
		text = new File("test.txt");
		bogus = new File("test.bogus");
	}

	@Test
	public void testExampleFileFilter() {
		assertNotNull(defaultCons);
	}

	@Test
	public void testExampleFileFilterString() {
		assertNotNull(stringCons);
	}

	@Test
	public void testExampleFileFilterStringString() {
		assertNotNull(stringCons);
	}

	@Test
	public void testExampleFileFilterStringArray() {
		assertNotNull(strArrayCons);
	}

	@Test
	public void testExampleFileFilterStringArrayString() {
		assertNotNull(strArrayDescCons);
	}

	@Test
	public void testAcceptFile() {
		assertTrue(defaultCons.accept(edg));
		assertTrue(stringCons.accept(edg));
		assertTrue(stringDescCons.accept(edg));
		assertTrue(strArrayCons.accept(edg));
		assertTrue(strArrayDescCons.accept(edg));
		
		assertTrue(strArrayCons.accept(text));
		assertTrue(strArrayDescCons.accept(text));
		
		assertTrue(defaultCons.accept(bogus));
		assertFalse(stringCons.accept(bogus));
		assertFalse(stringDescCons.accept(bogus));
		assertFalse(strArrayCons.accept(bogus));
		assertFalse(strArrayDescCons.accept(bogus));
	}

	@Test
	public void testGetExtension() {
		assertTrue(defaultCons.getExtension(bogus).equals("bogus"));
		assertTrue(stringCons.getExtension(bogus).equals("bogus"));
		assertTrue(stringDescCons.getExtension(bogus).equals("bogus"));
		assertTrue(strArrayCons.getExtension(bogus).equals("bogus"));
		assertTrue(strArrayDescCons.getExtension(bogus).equals("bogus"));
	}

	@Test
	public void testAddExtension() {
		defaultCons.addExtension("bogus");
		stringCons.addExtension("bogus");
		stringDescCons.addExtension("bogus");
		strArrayCons.addExtension("bogus");
		strArrayDescCons.addExtension("bogus");
		
		assertTrue(defaultCons.accept(bogus));
		assertTrue(stringCons.accept(bogus));
		assertTrue(stringDescCons.accept(bogus));
		assertTrue(strArrayCons.accept(bogus));
		assertTrue(strArrayDescCons.accept(bogus));
	}

	@Test
	public void testGetDescription() {
		assertTrue(defaultCons.getDescription().equals("()"));
		assertTrue(stringCons.getDescription().equals("(.edg)"));
		assertTrue(stringDescCons.getDescription().equals("EDG files (.edg)"));
		assertTrue(strArrayCons.getDescription().equals("(.txt, .edg)"));
		assertTrue(strArrayDescCons.getDescription().equals("EDG & TXT files (.txt, .edg)"));
	}

	@Test
	public void testSetDescription() {
		defaultCons.setDescription("Yolo");
		assertTrue(defaultCons.getDescription().equals("Yolo ()"));
	}
	
	@Test
	public void testSetExtensionListInDescription() {
		defaultCons.setExtensionListInDescription(true);
		assertTrue(defaultCons.isExtensionListInDescription());
	}

	@Test
	public void testIsExtensionListInDescription() {
		assertFalse(defaultCons.isExtensionListInDescription());
		assertFalse(stringCons.isExtensionListInDescription());
		assertTrue(stringDescCons.isExtensionListInDescription());
		assertFalse(strArrayCons.isExtensionListInDescription());
		assertTrue(strArrayDescCons.isExtensionListInDescription());
	}
}
