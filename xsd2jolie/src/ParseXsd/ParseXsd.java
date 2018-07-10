/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParseXsd;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Queue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




/**
 *
 * @author maschio
 */
public class ParseXsd {
    public  static class  XsdType {
        private  static HashMap <String ,String >xsdJolieType = new  HashMap<>();
        private XsdType(){
           xsdJolieType.put("xs:string","string");
           xsdJolieType.put("xs:decimal","double");
           xsdJolieType.put("xs:date","string");
           xsdJolieType.put ("xs:integer","int");
		   xsdJolieType.put ("xs:date","string");
		   xsdJolieType.put( "xs:base64Binary", "raw" );
		   xsdJolieType.put( "xs:normalizedString","string");
		   xsdJolieType.put ("xs:dateTime","string");
        }
		
		public static String getJolieType(String xsdType ){
		  return xsdJolieType.get( xsdType );
		}
        
   }
    
    Document doc ;
	XsdType xsdType = new XsdType();
    public ParseXsd(Document doc){
       
        this.doc = doc;
		
        
      
    }
    public void parse(){
	Queue<Node> elementQueue = Collections.asLifoQueue( new ArrayDeque<Node>());
       NodeList nListComplex = doc.getElementsByTagName("xs:complexType");
	   for (int counter = 0; counter < nListComplex.getLength(); counter++) {
	             Node nNode = nListComplex.item(counter);
                elementQueue.add( nNode );
	   };
	   
	   NodeList nListSimple = doc.getElementsByTagName("xs:simpleType");
	   
	   for (int counter = 0; counter < nListSimple.getLength(); counter++) {
	             Node nNode = nListSimple.item(counter);
                elementQueue.add( nNode );
	   };
       while (elementQueue.size()> 0) {
                Node nNode = elementQueue.poll();

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
                    Element eElement = (Element) nNode;
					 NodeList nListRestriction =eElement.getElementsByTagName( "xs:restriction" );
					 if (nListRestriction.getLength()>0){
					  Element baseElement = (Element) nListRestriction.item( 0 ); 
					  System.out.println("type " + eElement.getAttribute("name")+": "+ xsdType.getJolieType( baseElement.getAttribute("base")) +"\n");
					 }else{
					    System.out.println("type " + eElement.getAttribute("name") + ":void{\n");
					 }
                }
                NodeList childList =  nNode.getChildNodes();

                for (int temp1 = 0; temp1 < childList.getLength(); temp1++) {
                     if (childList.item(temp1).getNodeName() == "xs:sequence"){
                         parseSequence(childList.item(temp1));
                     }
                       
                }
       
       }
      
    }
   private void parseSequence ( Node nNode){
       NodeList childList =  nNode.getChildNodes();
	
  
       for (int temp1 = 0; temp1 < childList.getLength(); temp1++) {
                  String minOccurs = "1";
       String maxOccurs = "1";
           if (childList.item(temp1).getNodeType() == Node.ELEMENT_NODE) {
               
               Element eElement = (Element) childList.item(temp1);
               
               if (eElement.getAttribute("minOccurs")!=""){
                  minOccurs = eElement.getAttribute("minOccurs");
               }
               if (!"".equals( eElement.getAttribute("maxOccurs") )){
                if ("unbounded".equals( eElement.getAttribute("maxOccurs") )){
                     maxOccurs = "*";
                }else{
                     maxOccurs = eElement.getAttribute("maxOccurs");
                }
               }
               if (eElement.getAttribute("name")!= ""){
				if (xsdType.getJolieType( eElement.getAttribute("type") )== null){   
                System.out.println("." + eElement.getAttribute("name") +"["+ minOccurs+","+maxOccurs+"]" +" : "+ eElement.getAttribute("type")+"\n");
               }else{
			    System.out.println("." + eElement.getAttribute("name") +"["+ minOccurs+","+maxOccurs+"]" +" : "+ xsdType.getJolieType( eElement.getAttribute("type")) +"\n");
			   }
			  }
           }
          
       }
       
       System.out.println("}\n");

   }
    
}
