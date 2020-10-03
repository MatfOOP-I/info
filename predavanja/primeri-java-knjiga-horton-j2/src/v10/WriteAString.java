package v10;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class WriteAString {
  public static void main(String[] args) {
    String phrase = new String("Garbage in, garbage out\n");
    String dirname = "C:/Beg Java Stuff";   // Directory name
    String filename = "charData.txt";       // File name

    File dir = new File(dirname);           // File object for directory

    // Now check out the directory
    if (!dir.exists())                      // If directory does not exist
     {
      if (!dir.mkdir())                     // ...create it
       {
        System.out.println("Cannot create directory: " + dirname);
        System.exit(1);
      } 
    } else if (!dir.isDirectory()) {
      System.err.println(dirname + " is not a directory");
      System.exit(1);
    } 

    // Create the filestream
    File aFile = new File(dir, filename);
    FileOutputStream outputFile = 
      null;                          // Place to store the stream reference
    try {
      outputFile = new FileOutputStream(aFile, true);
      System.out.println("File stream created successfully.");
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.err);
    } 

    // Create the file output stream channel
    FileChannel outChannel = outputFile.getChannel();
    
    ByteBuffer buf = ByteBuffer.allocate(1024);
    System.out.println("New buffer:           position = " + buf.position()
                       + "\tLimit = " + buf.limit() + "\tcapacity = "
                       + buf.capacity());

    // Load the data into the buffer
    for (int i = 0; i < phrase.length(); i++) {
      buf.putChar(phrase.charAt(i));
    }

    System.out.println("Buffer after loading: position = " + buf.position()
                       + "\tLimit = " + buf.limit() + "\tcapacity = "
                       + buf.capacity());

    buf.flip();                // Flip the buffer ready for file write
    System.out.println("Buffer after flip:    position = " + buf.position() 
                       + "\tLimit = " + buf.limit() + "\tcapacity = " 
                       + buf.capacity());

    // Write the file
    try {
      outChannel.write(buf);   // Write the buffer to the file channel
      outputFile.close();      // Close the output stream & the channel
      System.out.println("Buffer contents written to file.");
    } catch (IOException e) {
      e.printStackTrace(System.err);
    }
    System.exit(0);
  }
}
