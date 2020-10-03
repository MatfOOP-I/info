package v11;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class RandomFileRead
{
  public static void main(String[] args)
  {
    File aFile = new File("C:/Beg Java Stuff/primes.bin");
    FileInputStream inFile = null;
    FileOutputStream outFile = null;
   
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
    
    final int PRIMESREQUIRED = 10;
    ByteBuffer buf = ByteBuffer.allocate(8*PRIMESREQUIRED);  

    long[] primes = new long[PRIMESREQUIRED];
    int index = 0;                                     // Position for a prime in the file

    try
    {
      final int PRIMECOUNT = (int)inChannel.size()/8;  // Count of primes in the file

      // Read the number of random primes required
      for(int i = 0 ; i<PRIMESREQUIRED ; i++)
      {
        index = 8*(int)(PRIMECOUNT*Math.random());  
        inChannel.read(buf, index);                   // Read the value 
        buf.flip();
        primes[i] = buf.getLong();                    // Save it in the array
        buf.clear();
      }

      // Output the selection of random primes 5 to a line in field width of 12
      StringBuffer str = null;        
      for(int i = 0 ; i<PRIMESREQUIRED ; i++)
      {
        str = new StringBuffer("           ").append(primes[i]);          
        System.out.print(str.substring(str.length()-12, str.length())+
                                            ((i+1)%5 == 0 ? "\n" : ""));
      }
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
