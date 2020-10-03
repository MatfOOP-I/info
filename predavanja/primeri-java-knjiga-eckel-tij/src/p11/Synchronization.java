package p11;
//: c11:Synchronization.java
// Using the Collections.synchronized methods.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;

public class Synchronization {
  public static void main(String[] args) {
    Collection c =
      Collections.synchronizedCollection(new ArrayList());
    List list =
      Collections.synchronizedList(new ArrayList());
    Set s = Collections.synchronizedSet(new HashSet());
    Map m = Collections.synchronizedMap(new HashMap());
  }
} ///:~
