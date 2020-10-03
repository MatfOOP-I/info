package p12;
//: c12:Endians.java
// Endian differences and data storage.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.nio.*;
import com.bruceeckel.simpletest.*;
import com.bruceeckel.util.*;

public class Endians {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
    bb.asCharBuffer().put("abcdef");
    System.out.println(Arrays2.toString(bb.array()));
    bb.rewind();
    bb.order(ByteOrder.BIG_ENDIAN);
    bb.asCharBuffer().put("abcdef");
    System.out.println(Arrays2.toString(bb.array()));
    bb.rewind();
    bb.order(ByteOrder.LITTLE_ENDIAN);
    bb.asCharBuffer().put("abcdef");
    System.out.println(Arrays2.toString(bb.array()));
    monitor.expect(new String[]{
      "[0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]",
      "[0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]",
      "[97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102, 0]"
    });
  } 
} ///:~