package p12;
//: c12:LargeMappedFiles.java
// Creating a very large file using mapping.
// {RunByHand}
// {Clean: test.dat}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class LargeMappedFiles {
  static int length = 0x8FFFFFF; // 128 Mb
  public static void main(String[] args) throws Exception {
    MappedByteBuffer out = 
      new RandomAccessFile("test.dat", "rw").getChannel()
      .map(FileChannel.MapMode.READ_WRITE, 0, length);
    for(int i = 0; i < length; i++)
      out.put((byte)'x');
    System.out.println("Finished writing");
    for(int i = length/2; i < length/2 + 6; i++)
      System.out.print((char)out.get(i));
  }
} ///:~