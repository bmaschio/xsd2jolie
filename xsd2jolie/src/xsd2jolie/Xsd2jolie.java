/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsd2jolie;

import ParseXsd.ParseXsd;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 *
 * @author maschio
 */
public class Xsd2jolie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File fXmlFile = new File("./Fattura1.2.0.xsd");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            
            ParseXsd parseXsd = new ParseXsd(doc);
            parseXsd.parse();
             
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Xsd2jolie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Xsd2jolie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Xsd2jolie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
