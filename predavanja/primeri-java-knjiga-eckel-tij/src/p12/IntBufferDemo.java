package p12;
//: c12:IntBufferDemo.java
// Manipulating ints in a ByteBuffer with an IntBuffer
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.nio.*;
import com.bruceeckel.simpletest.*;
import com.bruceeckel.util.*;

public class IntBufferDemo {
  private static Test monitor = new Test();
  private static final int BSIZE = 1024;
  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.allocate(BSIZE);
    IntBuffer ib = bb.asIntBuffer();
    // Store an array of int:
    ib.put(new int[] { 11, 42, 47, 99, 143, 811, 1016 });
    // Absolute location read and write:
    System.out.println(ib.get(3));
    ib.put(3, 1811);
    ib.rewind();
    while(ib.hasRemaining()) {
      int i = ib.get();
      if(i == 0) break; // Else we'll get the entire buffer
      System.out.println(i);
    }
    monitor.expect(new String[] {
      "99",
      "11",
      "42",
      "47",
      "1811",
      "143",
      "811",
      "1016"
    });
  }
} ///:~