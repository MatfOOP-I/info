package p11;
//: c11:MouseList.java
// A type-conscious List.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;

public class MouseList {
  private List list = new ArrayList();
  public void add(Mouse m) { list.add(m); }
  public Mouse get(int index) {
    return (Mouse)list.get(index);
  }
  public int size() { return list.size(); }
} ///:~
