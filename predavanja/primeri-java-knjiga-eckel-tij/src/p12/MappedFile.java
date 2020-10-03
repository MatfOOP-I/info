package p12;
//: c12:MappedFile.java
// Mapping an entire file into memory for reading.
// {Args: MappedFile.java}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MappedFile {
  public static void main(String[] args) throws Exception {
    if(args.length != 1) {
      System.out.println("argument: sourcefile");
      System.exit(1);
    }
    long length = new File(args[0]).length();
    MappedByteBuffer in = new FileInputStream(args[0])
      .getChannel()
      .map(FileChannel.MapMode.READ_ONLY, 0, length);
    int i = 0;
    while(i < length)
      System.out.print((char)in.get(i++));
  }
} ///:~