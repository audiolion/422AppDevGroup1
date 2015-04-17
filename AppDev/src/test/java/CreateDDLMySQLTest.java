package test;
import static org.junit.Assert.*;

import java.io.File;

import main.CreateDDLMySQL;
import main.EdgeConvertFileParser;
import main.EdgeField;
import main.EdgeTable;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class CreateDDLMySQLTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	EdgeConvertFileParser parser;
	CreateDDLMySQL defaultCons;
	CreateDDLMySQL arrayArrayCons;
	
	@Before
	public void setUp() throws Exception {
		parser = new EdgeConvertFileParser(new File("Courses.edg"));
		defaultCons = new CreateDDLMySQL();
		EdgeTable[] inputTables = parser.getEdgeTables();
		for(EdgeTable table : inputTables){
			table.makeArrays();
		}
		EdgeField[] inputFields = parser.getEdgeFields();
		arrayArrayCons = new CreateDDLMySQL(inputTables, inputFields);
	}

	@Test
	public void testGetDatabaseName() {
		defaultCons.generateDatabaseName();
		assertTrue(defaultCons.getDatabaseName().equals("MySQLDB"));
		arrayArrayCons.generateDatabaseName();
		assertTrue(arrayArrayCons.getDatabaseName().equals("MySQLDB"));
	}

	@Test
	public void testGetProductName() {
		assertTrue(defaultCons.getProductName().equals("MySQL"));
		assertTrue(arrayArrayCons.getProductName().equals("MySQL"));
	}

	@Test
	public void testGetSQLString() {
		assertEquals(arrayArrayCons.getSQLString().length(), 269);
	}
	
	
	@Test
	public void testGetSQLStringDefaultCons() {
		thrown.expect(Exception.class);
		defaultCons.getSQLString();
	}
	
	@Test
	public void testCreateDDLDefaultCons() {
		thrown.expect(Exception.class);
		defaultCons.createDDL();
	}

	@Test
	public void testCreateDDLMySQL() {
		assertNotNull(defaultCons);
		assertNotNull(arrayArrayCons);
	}

	@Test
	public void testGenerateDatabaseName() {
		assertTrue(defaultCons.generateDatabaseName().equals("MySQLDB"));
		assertTrue(arrayArrayCons.generateDatabaseName().equals("MySQLDB"));
	}
}
