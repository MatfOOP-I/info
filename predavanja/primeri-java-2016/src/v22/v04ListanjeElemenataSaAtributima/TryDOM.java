package v22.v04ListanjeElemenataSaAtributima;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import org.w3c.dom.NamedNodeMap;
import java.io.File;
import java.io.IOException;
import java.io.IOException;

public class TryDOM implements ErrorHandler {
  public static void main(String args[]) {
    if(args.length == 0) {
      System.out.println("No file to process."+
                           "Usage is:\njava TryDOM \"filename\"");
                           
      System.exit(1);
    }
    File xmlFile = new File(args[0]);
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    builderFactory.setNamespaceAware(true);       // Set namespace aware
    builderFactory.setValidating(true);           // and validating parser feaures
    builderFactory.setIgnoringElementContentWhitespace (true);

    DocumentBuilder builder = null;
    try {
      builder = builderFactory.newDocumentBuilder();  // Create the parser
      builder.setErrorHandler(new TryDOM()); //Error handler is instance of TryDOM
    }
    catch(ParserConfigurationException e) {
      e.printStackTrace();
    }
    Document xmlDoc = null;

    try {
      xmlDoc = builder.parse(xmlFile);
    }
    catch(SAXException e) {
      e.printStackTrace();
    }
    catch(IOException e) {
      e.printStackTrace();
    }
    DocumentType doctype = xmlDoc.getDoctype();       // Get the DOCTYPE node
    System.out.println("DOCTYPE node:\n" + doctype);  // and output it
    System.out.println("\nDocument body contents are:");
    listNodes(xmlDoc.getDocumentElement(),"");         // Root element & children
  }
  
  // output a node and all its child nodes
  static void listNodes(Node node, String indent) {
    String nodeName = node.getNodeName();
    System.out.println(indent+nodeName+" Node, type is "
                                             +node.getClass().getName()+":");
    System.out.println(indent+" "+node);

    if(node instanceof Element && node.hasAttributes()) {
      System.out.println(indent+"Element Attributes are:");
      NamedNodeMap attrs = node.getAttributes();      //.... get the attributes
      for(int i = 0; i<attrs.getLength(); i++) {
         Attr attribute = (Attr)attrs.item(i);
         System.out.println(indent+attribute.getName()+ "=" + attribute.getValue());
       }
    }

    NodeList list = node.getChildNodes();       // Get the list of child nodes
    if(list.getLength() > 0) {                  // As long as there are some...
      System.out.println(indent+"Child Nodes of "+nodeName+" are:");
      for(int i = 0 ; i<list.getLength() ; i++) //...list them & their children...
        listNodes(list.item(i),indent+" ");     // by calling listNodes() for each  
    }         
  }

  public void fatalError(SAXParseException spe) throws SAXException {
    System.out.println("Fatal error at line "+spe.getLineNumber());
    System.out.println(spe.getMessage());
    throw spe;
  }

  public void warning(SAXParseException spe) {
    System.out.println("Warning at line "+spe.getLineNumber());
    System.out.println(spe.getMessage());
  }

  public void error(SAXParseException spe) {
    System.out.println("Error at line "+spe.getLineNumber());
    System.out.println(spe.getMessage());
  }
}
