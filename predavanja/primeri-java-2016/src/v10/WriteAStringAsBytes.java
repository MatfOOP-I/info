package v10;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class WriteAStringAsBytes {
  public static void main(String[] args) {

    String phrase = new String("Garbage in, garbage out\n");
    String dirname = "C:/Beg Java Stuff";   // Directory name
    String filename = "byteData.txt";

    File aFile = new File(dirname, filename);

    // Create the file output stream
    FileOutputStream file = null;
    try {
      file = new FileOutputStream(aFile, true);
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.err);
    } 
    FileChannel outChannel = file.getChannel();
    ByteBuffer buf = ByteBuffer.allocate(phrase.length());
    byte[] bytes = phrase.getBytes();

    buf.put(bytes);
    buf.flip();

    try {
      outChannel.write(buf);
      file.close();   // Close the output stream & the channel
    } catch (IOException e) {
      e.printStackTrace(System.err);
    }
  }
}
