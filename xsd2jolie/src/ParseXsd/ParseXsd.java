/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParseXsd;

import java.util.HashMap;
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
        private HashMap <String ,String >xsdJolieType = new  HashMap<>();
        public XsdType(){
           xsdJolieType.put("xs:string","string");
           xsdJolieType.put("xs:decimal","double");
           xsdJolieType.put("xs:date","string");
           xsdJolieType.put ("xs:integer","int");1
        }
        
   }
    
    Document doc ;
    public ParseXsd(Document doc){
       
        this.doc = doc;
        
      
    }
    public void parse(){
       NodeList nListComplex = doc.getElementsByTagName("xs:complexType");
       for (int counter = 0; counter < nListComplex.getLength(); counter++) {
                Node nNode = nListComplex.item(counter);
                
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                         Element eElement = (Element) nNode;
                    System.out.println("type " + eElement.getAttribute("name") + ":void{\n");
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
               if (eElement.getAttribute("maxOccurs")!= ""){
                if (eElement.getAttribute("maxOccurs")== "unbounded"){
                     maxOccurs = "*";
                }else{
                     maxOccurs = eElement.getAttribute("maxOccurs");
                }
               }
               if (eElement.getAttribute("name")!= ""){
                System.out.println("." + eElement.getAttribute("name") +"["+ minOccurs+":"+maxOccurs+"]" +" : "+ eElement.getAttribute("type")+"\n");
               }
           }
          
       }
       
       System.out.println("}\n");

   }
    
}
