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
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
/**
 *
 * @author Student
 */
public class EdgeConvertXMLParser extends fileParser{
    
    Document XMLDoc;
    public EdgeConvertXMLParser(File file){
        super(file);
        openXML(file);
    }
    
    private void parseXML(){
        XMLDoc.normalizeDocument();
        NodeList nList = XMLDoc.getElementsByTagName("figure");
        EdgeTable table;
        int fieldCount = 0;
        EdgeField field;
        for(int i = 0;i<nList.getLength();i++){
          
            Node fig = nList.item(i);
            NodeList attList = fig.getChildNodes();
            NamedNodeMap aList = fig.getAttributes();
            String id = aList.getNamedItem("id").getTextContent();
            table = new EdgeTable( id + DELIM + aList.getNamedItem("name").getTextContent());//table name
            alTables.add(table);
            for(int j = 0;j<attList.getLength();j++){
                Node att = attList.item(j);
                if(att.getNodeName().equals("attributes")){
                    NodeList attributeList = att.getChildNodes();
                    fieldCount = 0;
                    for(int x =0;x<attributeList.getLength();x++){
                        Node attribute = attributeList.item(x);
                        if(attribute.getNodeName().equals("attribute")){
                            field = new EdgeField(id+DELIM+attribute.getTextContent());
                            alFields.add(field);
                            table.addNativeField(i);
                            
                        }
                    }
                   
                }
                
            }
         
            
        }
           makeArrays();
    }
    
    
    
    private void openXML(File file){
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            XMLDoc = dBuilder.parse(file);
            parseXML();
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
}
