/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ParseXsd;

import com.sun.xml.xsom.XSAnnotation;
import com.sun.xml.xsom.XSAttGroupDecl;
import com.sun.xml.xsom.XSAttributeDecl;
import com.sun.xml.xsom.XSAttributeUse;
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSContentType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSFacet;
import com.sun.xml.xsom.XSIdentityConstraint;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSModelGroupDecl;
import com.sun.xml.xsom.XSNotation;
import com.sun.xml.xsom.XSParticle;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSimpleType;
import com.sun.xml.xsom.XSWildcard;
import com.sun.xml.xsom.XSXPath;
import com.sun.xml.xsom.visitor.XSVisitor;

/**
 *
 * @author maschio
 */
public class XsdVisitor implements XSVisitor{

    @Override
    public void annotation(XSAnnotation ann) {
       System.out.println (ann.getAnnotation().toString());
    }

    @Override
    public void attGroupDecl(XSAttGroupDecl decl) {
        System.out.println(decl.getName());
    }

    @Override
    public void attributeDecl(XSAttributeDecl decl) {
         System.out.println(decl.getName());
    }

    @Override
    public void attributeUse(XSAttributeUse use) {
         System.out.println(use.getDecl().getName());
    }

    
    @Override
    public void complexType(XSComplexType type) {
         System.out.println(type.getName()); //To change body of generated methods, choose Tools | Templates.
         XSParticle particle = type.getContentType().asParticle();
         particle.visit(this);
        }
    @Override
    public void schema(XSSchema schema) {
         System.out.println("schema"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void facet(XSFacet facet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notation(XSNotation notation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void identityConstraint(XSIdentityConstraint decl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void xpath(XSXPath xp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void wildcard(XSWildcard wc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modelGroupDecl(XSModelGroupDecl decl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modelGroup(XSModelGroup group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elementDecl(XSElementDecl decl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void simpleType(XSSimpleType simpleType) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void particle(XSParticle particle) {
        if (particle.getTerm().isModelGroup()){
              
            XSParticle[] children = particle.getTerm().asModelGroup().getChildren();
            for (int counter = 0 ; counter < children.length; counter++){
                children[counter].visit(this);
            } 
        }
        if (particle.getTerm().isElementDecl()){
          System.out.println (particle.getTerm().asElementDecl().getName());
        
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void empty(XSContentType empty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
