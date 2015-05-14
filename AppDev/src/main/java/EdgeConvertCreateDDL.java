package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public abstract class EdgeConvertCreateDDL {
   static String[] products = {"MySQL"};
   protected EdgeTable[] tables; //master copy of EdgeTable objects
   protected EdgeField[] fields; //master copy of EdgeField objects
   protected int[] numBoundTables;
   protected int maxBound;
   protected StringBuffer sb;
   protected int selected;
   
   public EdgeConvertCreateDDL(EdgeTable[] tables, EdgeField[] fields) {
      this.tables = tables;
      this.fields = fields;
      initialize();
   } //EdgeConvertCreateDDL(EdgeTable[], EdgeField[])
   
   public EdgeConvertCreateDDL() { //default constructor with empty arg list for to allow output dir to be set before there are table and field objects
      
   } //EdgeConvertCreateDDL()

   public void initialize() {
      numBoundTables = new int[tables.length];
      maxBound = 0;
      sb = new StringBuffer();
      for (int i = 0; i < tables.length; i++) { //step through list of tables
         int numBound = 0; //initialize counter for number of bound tables
         //for each works a little cleaner then havingto dela with two seperate iteration variablse
         for (int val : tables[i].getRelatedFieldsArray()) { //step through related fields list 
             //elimnate if statement  
             numBound += val != 0?1:0; //count the number of non-zero related fields
         }
         numBoundTables[i] = numBound;
         maxBound = numBound > maxBound?numBound:maxBound; 
         //elimnate if statment
      }
   }
   
   protected EdgeTable getTable(int numFigure) {
       //for loop to foreach works better and cleaner
       for(EdgeTable edgTab: tables){
           if(numFigure == edgTab.getNumFigure())
               return edgTab;
       }
       return null;
      
   }
   
   protected EdgeField getField(int numFigure) {
        //for loop to foreach works better and cleaner
       for(EdgeField edgField: fields){
           if(numFigure == edgField.getNumFigure())
               return edgField;
       }
       return null;
      
   }

   //not sure what this stuff is doing?
   public abstract String getDatabaseName();

   public abstract String getProductName();
   
   public abstract String getSQLString();
   
   public abstract void createDDL();
   
}//EdgeConvertCreateDDL
