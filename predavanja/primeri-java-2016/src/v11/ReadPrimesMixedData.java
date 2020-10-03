package v11;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class ReadPrimesMixedData
{
  public static void main(String[] args)
  {
    File aFile = new File("C:/Beg Java Stuff/primes.txt");
    FileInputStream inFile = null;
   
    try
    {
      inFile = new FileInputStream(aFile); 
    }
    catch(FileNotFoundException e)
    {
      e.printStackTrace(System.err);
      System.exit(1);
    }
  
    FileChannel inChannel = inFile.getChannel();    
    try
    {
      ByteBuffer lengthBuf = ByteBuffer.allocate(8);
      int strLength = 0;              // Stores the string length 
      ByteBuffer buf = null;          // Stores a reference to the second byte buffer 
      byte[] strChars = null;         // Stores a reference to an array to hold the string
 
      while(true)  
      {
        if(inChannel.read(lengthBuf) == -1)        // Read the string length, if its EOF
          break;                                   // exit the loop

        lengthBuf.flip();
        strLength = (int)lengthBuf.getDouble();    // Extract the length and convert to int
        buf = ByteBuffer.allocate(2*strLength+8);  // Buffer for the string & the prime

        if(inChannel.read(buf) == -1)              // Read the string & binary prime value
        {
          //assert false;                            // Should not get here!
          break;                                   // Exit loop on EOF
        }
        buf.flip();
        strChars = new byte[2*strLength];          // Create the array for the string
        buf.get(strChars);                         // Extract string & binary prime value
          
        System.out.println("String length: " + strChars.length+ "  String: " +
                        ByteBuffer.wrap(strChars).asCharBuffer() + "  Binary value: " + buf.getLong());
         
        lengthBuf.clear();                    // Clear the buffer for the next read
      }
      System.out.println("\nEOF reached.");
      inFile.close();                   // Close the file and the channel
 
    }
    catch(IOException e)
    {
      e.printStackTrace(System.err);
      System.exit(1);
    }
      System.exit(0);
  }
}
