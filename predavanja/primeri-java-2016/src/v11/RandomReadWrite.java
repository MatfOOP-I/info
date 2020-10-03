package v11;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class RandomReadWrite
{
  public static void main(String[] args)
  {
    File aFile = new File("C:/Beg Java Stuff/primes.bin");
    FileInputStream inFile = null;
    FileOutputStream outFile = null;
   
    try
    {
      inFile = new FileInputStream(aFile); 
      outFile = new FileOutputStream(aFile, true); 
    }
    catch(FileNotFoundException e)
    {
      e.printStackTrace(System.err);
      System.exit(1);
    }
    FileChannel inChannel = inFile.getChannel();
    FileChannel outChannel = outFile.getChannel();
    
    final int PRIMESREQUIRED = 10;
    ByteBuffer buf = ByteBuffer.allocate(8);  

    long[] primes = new long[PRIMESREQUIRED];
    int index = 0;                                     // Position for a prime in the file
    final long REPLACEMENT = 99999L;                   // Replacement for a selected prime   

    try
    {
      final int PRIMECOUNT = (int)inChannel.size()/8;
      System.out.println("Prime count = "+PRIMECOUNT);
      for(int i = 0 ; i<PRIMESREQUIRED ; i++)
      {
        index = 8*(int)(PRIMECOUNT*Math.random());  
        inChannel.read(buf, index);  
        buf.flip();
        primes[i] = buf.getLong();
        buf.flip();
        buf.putLong(REPLACEMENT);
        buf.flip();
        outChannel.write(buf, index);
        buf.clear();
      }
 
        StringBuffer str = null;        
      for(int i = 0 ; i<PRIMESREQUIRED ; i++)
      {
        str = new StringBuffer("           ").append(primes[i]);          
          System.out.print((i%5 == 0 ? "\n" : "") + 
                                   str.substring(str.length()-12, str.length()));
      }
      inFile.close();                   // Close the file and the channel
      outFile.close();
    }
    catch(IOException e)
    {
      e.printStackTrace(System.err);
      System.exit(1);
    }
      System.exit(0);
  }
}
