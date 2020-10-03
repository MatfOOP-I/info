package p12;
//: c12:ViewBuffers.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.nio.*;
import com.bruceeckel.simpletest.*;

public class ViewBuffers {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.wrap(
      new byte[]{ 0, 0, 0, 0, 0, 0, 0, 'a' });
    bb.rewind();
    System.out.println("Byte Buffer");
    while(bb.hasRemaining())
      System.out.println(bb.position()+ " -> " + bb.get());
    CharBuffer cb =
      ((ByteBuffer)bb.rewind()).asCharBuffer();
    System.out.println("Char Buffer");
    while(cb.hasRemaining())
      System.out.println(cb.position()+ " -> " + cb.get());
    FloatBuffer fb =
      ((ByteBuffer)bb.rewind()).asFloatBuffer();
    System.out.println("Float Buffer");
    while(fb.hasRemaining())
      System.out.println(fb.position()+ " -> " + fb.get());
    IntBuffer ib =
      ((ByteBuffer)bb.rewind()).asIntBuffer();
    System.out.println("Int Buffer");
    while(ib.hasRemaining())
      System.out.println(ib.position()+ " -> " + ib.get());
    LongBuffer lb =
      ((ByteBuffer)bb.rewind()).asLongBuffer();
    System.out.println("Long Buffer");
    while(lb.hasRemaining())
      System.out.println(lb.position()+ " -> " + lb.get());
    ShortBuffer sb =
      ((ByteBuffer)bb.rewind()).asShortBuffer();
    System.out.println("Short Buffer");
    while(sb.hasRemaining())
      System.out.println(sb.position()+ " -> " + sb.get());
    DoubleBuffer db =
      ((ByteBuffer)bb.rewind()).asDoubleBuffer();
    System.out.println("Double Buffer");
    while(db.hasRemaining())
      System.out.println(db.position()+ " -> " + db.get());
    monitor.expect(new String[] {
      "Byte Buffer",
      "0 -> 0",
      "1 -> 0",
      "2 -> 0",
      "3 -> 0",
      "4 -> 0",
      "5 -> 0",
      "6 -> 0",
      "7 -> 97",
      "Char Buffer",
      "0 -> \0",
      "1 -> \0",
      "2 -> \0",
      "3 -> a",
      "Float Buffer",
      "0 -> 0.0",
      "1 -> 1.36E-43",
      "Int Buffer",
      "0 -> 0",
      "1 -> 97",
      "Long Buffer",
      "0 -> 97",
      "Short Buffer",
      "0 -> 0",
      "1 -> 0",
      "2 -> 0",
      "3 -> 97",
      "Double Buffer",
      "0 -> 4.8E-322"
    });
  }
} ///:~