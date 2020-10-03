package p12;
//: c12:MappedReader.java
// What happens when the entire file 
// isn't in your mapping region?
// {ThrowsException}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MappedReader {
  private static final int LENGTH = 100; // Small
  public static void main(String[] args) throws Exception {
    if(args.length != 1) {
      System.out.println("argument: sourcefile");
      System.exit(1);
    }
    MappedByteBuffer in = new FileInputStream(args[0])
      .getChannel()
      .map(FileChannel.MapMode.READ_ONLY, 0, LENGTH);
    int i = 0;
    while(i < LENGTH)
      System.out.print((char)in.get(i++));
    System.out.println((char)in.get(i++));
  }
} ///:~