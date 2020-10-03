package p02;
//: c02:DataOnlyTest.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

class DataOnly {
  int i;
  float f;
  boolean b;
}

public class DataOnlyTest {
  public static void main(String[] args) {
    DataOnly d = new DataOnly();
    d.i = 47;
    d.f = 1.1f;
    d.b = false;
  }
} ///:~
