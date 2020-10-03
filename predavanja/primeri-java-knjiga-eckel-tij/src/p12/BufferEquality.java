package p12;
//: c12:BufferEquality.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.nio.*;

public class BufferEquality {
  public static void main(String[] args) {
    CharBuffer 
      cb1 = CharBuffer.allocate(5),
      cb2 = CharBuffer.allocate(5);
    cb1.put('B').put('u').put('f').put('f').put('A');
    cb2.put('B').put('u').put('f').put('f').put('B');
    cb1.rewind();
    cb2.rewind();
    System.out.println(cb1.limit(4).equals(cb2.limit(4)));
    // Should be "true"
  }
} ///:~