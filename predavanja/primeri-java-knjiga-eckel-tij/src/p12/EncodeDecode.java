package p12;
//: c12:EncodeDecode.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.nio.*;
import java.nio.charset.*;
import com.bruceeckel.simpletest.*;

public class EncodeDecode {
  private static Test monitor = new Test();
  public static void print(ByteBuffer bb) {
    while(bb.hasRemaining())
      System.out.print(bb.get() + " ");
    System.out.println();
    bb.rewind();
  }
  public static void main(String[] args) {
    ByteBuffer bb = ByteBuffer.wrap(
      new byte[]{0,0,0,0,0,0,0,(byte)'a'});
    System.out.println("Initial Byte Buffer");
    print(bb);
    Charset[] csets = {Charset.forName("UTF-16LE"),
    Charset.forName("UTF-16BE"),
    Charset.forName("UTF-8"),
    Charset.forName("US-ASCII"),
    Charset.forName("ISO-8859-1")};
    for(int i = 0; i < csets.length; i++) {
      System.out.println(csets[i].name() + ":");
      print(csets[i].encode(bb.asCharBuffer()));
      csets[i].decode(bb);
      bb.rewind();
    }
    monitor.expect(new String[] {
      "Initial Byte Buffer",
      "0 0 0 0 0 0 0 97 ",
      "UTF-16LE:",
      "0 0 0 0 0 0 97 0 ",
      "UTF-16BE:",
      "0 0 0 0 0 0 0 97 ",
      "UTF-8:",
      "0 0 0 97 ",
      "US-ASCII:",
      "0 0 0 97 ",
      "ISO-8859-1:",
      "0 0 0 97 "
    });
  }
} ///:~