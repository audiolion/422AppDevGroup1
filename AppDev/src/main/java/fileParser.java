/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class fileParser {
    public File parseFile;
   public FileReader fr;
   public BufferedReader br;
   public String currentLine;
   public ArrayList alTables, alFields, alConnectors;
   public EdgeTable[] tables;
   public EdgeField[] fields;
   public EdgeField tempField;
   public EdgeConnector[] connectors;
   public String style;
   public String text;
   public String tableName;
   public String fieldName;
   public boolean isEntity, isAttribute, isUnderlined = false;
   public int numFigure, numConnector, numFields, numTables, numNativeRelatedFields;
   public int endPoint1, endPoint2;
   public int numLine;
   public String endStyle1, endStyle2;
   public static final String EDGE_ID = "EDGE Diagram File"; //first line of .edg files should be this
   public static final String SAVE_ID = "EdgeConvert Save File"; //first line of save files should be this
   public static final String DELIM = "|";
   
   public fileParser(File constructorFile) {
      numFigure = 0;
      numConnector = 0;
      alTables = new ArrayList();
      alFields = new ArrayList();
      alConnectors = new ArrayList();
      isEntity = false;
      isAttribute = false;
      parseFile = constructorFile;
      numLine = 0;
      
   }
   
    public EdgeTable[] getEdgeTables() {
      return tables;
   }
   
   public EdgeField[] getEdgeFields() {
      return fields;
   }
    
}
