/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParseXsd;


import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSContentType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSchema;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author maschio
 */
public class ParseXsd {
    private XSSchema schema;
    private HashMap <String ,String> jolieComplexType ; 
    private Map<String, XSComplexType> complexTypes;
    public ParseXsd(XSSchema schema){
        this.schema = schema;
        
        jolieComplexType = new HashMap<>();
    }
    public void parse(){
        complexTypes = schema.getComplexTypes();
        for( Map.Entry<String, XSComplexType> entry : complexTypes.entrySet()){
            String complexTypeString;
            parseComplexType ((XSComplexType) entry.getValue());
            
        }
      
    }
    private void parseComplexType (XSComplexType complexType ){
        
        try{
                XSContentType contentType = complexType.getContentType();
                String complexTypeString = "type " + complexType.getName() + ":{\n" ;
                parseParticle(contentType.asParticle(),complexTypeString);
                complexTypeString += "}\n";
                System.out.println(complexTypeString);
        }catch(InternalError e ){
              System.err.println("Probably ref");
        }
        
        
       
    }
    
    private void parseParticle (XSParticle particle , String typeString){
       try {
        if (particle.getTerm().isModelGroup()){
            XSParticle[] childrens = particle.getTerm().asModelGroup().getChildren();
            for (int counter = 0 ; counter < childrens.length; counter++){
                parseParticle (childrens[counter] ,typeString);
            } 
        }
        
        if (particle.getTerm().isElementDecl()){
              typeString +=  "\t." + particle.getTerm().asElementDecl().getName() + ":"  ; 
            } 
       
        
        }catch(InternalError e ){
              System.err.println("Probably ref");
            }
    }
    
}
