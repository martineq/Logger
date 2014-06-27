package com.fiuba.tecnicas.logging.sourceSettings;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

/**
 * @author Mart
 *
 */
public class XmlSource implements SourceSettings {

	final static String SOURCE_FILE_EXTENSION = ".xml";
	Document domDocument;
	Element domElement;
	private boolean available;
	
	public XmlSource() {
		available = true;
	}
	
	@Override
	public void load(String name) {

        try {
        	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            domDocument = documentBuilder.parse(name+SOURCE_FILE_EXTENSION);
    		domElement = domDocument.getDocumentElement();
        } catch (ParserConfigurationException pce) {
        	available = false;
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
        	available = false;
        	System.out.println(se.getMessage());
        } catch (IOException ioe) {
        	available = false;
            System.err.println(ioe.getMessage());
        }
        
	}

	@Override
	public boolean isAvailable() {
		return available;
	}
	
	@Override
	public String getValue(String key, String defaultValue) {
		String value = getValueFromElement(key, defaultValue, domElement);
		if (value.isEmpty()){ return defaultValue;}
		return value;
	}

	private String getValueFromElement(String tag, String defaultValue, Element doc) {
	    NodeList node = doc.getElementsByTagName(tag);
	    if (node.getLength() > 0 && node.item(0).hasChildNodes()) return node.item(0).getFirstChild().getNodeValue();
	    else return defaultValue;
	}
	
	@Override
	public String getValue(String key, String defaultValue,String loggerName) {
		String value = defaultValue;
		boolean found = false;
		NodeList node = domElement.getElementsByTagName(loggerName);
		
		node = node.item(0).getChildNodes();
		
		if (node.getLength() > 0) {
			for(int i=0 ; i<node.getLength() ; i++){
		    	
				//System.out.println("name"+i+node.item(i).getNodeName());
				//System.out.println("valor"+i+node.item(i).getTextContent());
				
				if(node.item(i).getNodeName().equals(key)){
					if( node.item(i).getTextContent().isEmpty() == false){					
						value = node.item(i).getTextContent();	
					}			
				}	
		    }			
		}
		
	    return value;
	}
	
}
