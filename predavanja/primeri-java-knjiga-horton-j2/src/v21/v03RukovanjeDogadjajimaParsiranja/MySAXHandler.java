package v21.v03RukovanjeDogadjajimaParsiranja;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class MySAXHandler extends DefaultHandler {
  public void startDocument() {
  	System.out.println("Start document: ");
  }    
    public void endDocument()  {
  	System.out.println("End document: ");
  }
  
  public void startElement(String uri, String localName, String qname, 
                                                               Attributes attr)
  {
    System.out.println("Start element: local name: " + localName + " qname: " 
                                                        + qname + " uri: "+uri);
  }
  
  public void endElement(String uri, String localName, String qname) {
    System.out.println("End element: local name: " + localName + " qname: "
                                                         + qname + " uri: "+uri);
  }
  
  public void characters(char[] ch, int start, int length) {
    System.out.println("Characters: " + new String(ch, start, length));
  }

  public void ignorableWhitespace(char[] ch, int start, int length) {
    System.out.println("Ignorable whitespace: " + new String(ch, start, length));
  }
}
