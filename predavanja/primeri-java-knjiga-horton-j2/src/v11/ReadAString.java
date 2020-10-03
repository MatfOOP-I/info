package v11;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadAString {
  public static void main(String[] args) {
    File aFile = new File("C:/Beg Java Stuff/charData.txt");
    FileInputStream inFile = null;
   
    try {
      inFile = new FileInputStream(aFile); 

    } catch(FileNotFoundException e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }

    FileChannel inChannel = inFile.getChannel();    
    ByteBuffer buf = ByteBuffer.allocate(48);    
    try {
      while(inChannel.read(buf) != -1) {

        System.out.println("String read: " +
                           ((ByteBuffer)(buf.flip())).asCharBuffer().toString());
        buf.clear();                    // Clear the buffer for the next read
      }
      System.out.println("EOF reached.");
      inFile.close();                   // Close the file and the channel
 
    } catch(IOException e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
    System.exit(0);
  }
}
