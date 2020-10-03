package p11;
//: c11:Enumerations.java
// Java 1.0/1.1 Vector and Enumeration.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;
import com.bruceeckel.util.*;

public class Enumerations {
  public static void main(String[] args) {
    Vector v = new Vector();
    Collections2.fill(v, Collections2.countries, 100);
    Enumeration e = v.elements();
    while(e.hasMoreElements())
      System.out.println(e.nextElement());
    // Produce an Enumeration from a Collection:
    e = Collections.enumeration(new ArrayList());
  }
} ///:~
