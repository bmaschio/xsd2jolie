/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsd2jolie;

import ParseXsd.ParseXsd;
import ParseXsd.XsdVisitor;
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.parser.SchemaDocument;
import com.sun.xml.xsom.parser.XSOMParser;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
        XSOMParser parser = new XSOMParser();
        File file;
        file = new File (".\\Fattura1.2.0.xsd");
        parser.parse(file);
        Set<SchemaDocument> documents = parser.getDocuments();
        Iterator<SchemaDocument> iteratorDocuments = documents.iterator();
        while (iteratorDocuments.hasNext()){
            SchemaDocument document = iteratorDocuments.next();
            XSSchema a = document.getSchema();
            ParseXsd parseXsd =  new  ParseXsd(a);
            parseXsd.parse();
        }
    }
    catch (Exception exp) {
        exp.printStackTrace(System.out);
    }
    }
    
}
