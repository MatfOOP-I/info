package v22;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ErrorHandler;
import java.io.*;

public class TryDOM implements ErrorHandler {
  public static void main(String args[]) {
    if (args.length == 0) {
      System.out.println("No file to process."
                         + "Usage is:\njava TryDOM <filename>");

      return;
    }
    File xmlFile = new File(args[0]);
    DocumentBuilderFactory builderFactory =
      DocumentBuilderFactory.newInstance();
    // Set namespace aware and validating parser feaures
    builderFactory.setNamespaceAware(true);
    builderFactory.setValidating(true);

    DocumentBuilder builder = null;
    try {
      builder = builderFactory.newDocumentBuilder();   // Create the parser
      builder.setErrorHandler(new TryDOM());
      // Error handler is instance of TryDOM
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
    System.out.println("Builder Factory = " + builderFactory
                       + "\nBuilder = " + builder);
    Document xmlDoc = null;
    try {
      xmlDoc = builder.parse(xmlFile);
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    listNodes(xmlDoc);   // List the document
  }
  
  // Lists all the nodes in a document
  static void listNodes(Node node) {
    String nodeName = node.getNodeName();       // Get name of this node

    if (node instanceof Element) {
      // Stores the attribute string
      StringBuffer attrStr = new StringBuffer();
      if (node.hasAttributes()) {  // If the element has attributes
                                   // get the collection of attributes
        NamedNodeMap attrs = node.getAttributes();
        for (int i = 0 ; i<attrs.getLength() ; i++) {
          Attr attribute = (Attr)attrs.item(i);   // Get an attribute

          // Append " name="value" to the attribute string
          attrStr.append(' ').append(attribute.getName()).append(
            '=').append('\"').append(attribute.getValue()).append('\"');
        }
      }
      System.out.println(indent+"<" + nodeName + attrStr + ">");
    } else if (node instanceof Text) {
      System.out.println(((Text)node).getData());
    } else if (node instanceof DocumentType) {
      System.out.println(getDoctypeString((DocumentType)node));
    }

	indent.append(' ');                     // Indent one space
    NodeList list = node.getChildNodes();   // Get the list of child nodes
    if (list.getLength() > 0) {    // As long as there are some...
      for (int i = 0; i < list.getLength(); 
           i++) {                  // ...list them and their children...
        listNodes(list.item(i));   // by calling listNodes()
      }

    //assert indent.length()>0;   // Should always be positive
    } 
    indent.deleteCharAt(indent.length() - 1);    // Chop off one space
    System.out.println("</" + nodeName + ">");   // Output end tag

  }

  public void fatalError(SAXParseException spe) throws SAXException {
    System.out.println("Fatal error at line " + spe.getLineNumber());
    System.out.println(spe.getMessage());
    throw spe;
  }

  public void warning(SAXParseException spe) {
    System.out.println("Warning at line " + spe.getLineNumber());
    System.out.println(spe.getMessage());
  }

  public void error(SAXParseException spe) {
    System.out.println("Error at line " + spe.getLineNumber());
    System.out.println(spe.getMessage());
  }

  // Indent for child nodes
  static StringBuffer indent = new StringBuffer("");

  private static String getDoctypeString(DocumentType doctype) {
    // Create the opening string for the DOCTYPE declaration with its name
    String str = doctype.getName();
    StringBuffer doctypeStr = new StringBuffer("<!DOCTYPE ").append(str);

    // Check for a system ID
    if ((str = doctype.getSystemId()) != null) {
      doctypeStr.append(" SYSTEM ").append('\"').append(str).append('\"');
    }

    // Check for a public ID
    if ((str = doctype.getPublicId()) != null) {
        doctypeStr.append(" PUBLIC ").append('\"').append(str).append('\"');
    }

    // Check for an internal subset
    if ((str = doctype.getInternalSubset()) != null) {
      doctypeStr.append('[').append(str).append(']');
    }

    // Append '>' and return the string
    return doctypeStr.append('>').toString();
  }
}