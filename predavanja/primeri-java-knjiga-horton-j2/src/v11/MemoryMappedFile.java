package v11;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class MemoryMappedFile
{
  public static void main(String[] args)
  {
    File aFile = new File("C:/Beg Java Stuff/primes.bin");
    RandomAccessFile ioFile = null;
    
   
    try
    {
      ioFile = new RandomAccessFile(aFile,"rw");
    }
    catch(FileNotFoundException e)
    {
      e.printStackTrace(System.err);
      System.exit(1);
    }
    FileChannel ioChannel = ioFile.getChannel();
    
    
    final int PRIMESREQUIRED = 10;
    long[] primes = new long[PRIMESREQUIRED];

    int index = 0;                      // Position for a prime in the file
    final long REPLACEMENT = 999999L;    // Replacement for a selected prime

    try
    {
      final int PRIMECOUNT = (int)ioChannel.size()/8;
      MappedByteBuffer buf = ioChannel.map(FileChannel.MapMode.READ_WRITE, 0L, ioChannel.size()).load();
      for(int i = 0 ; i<PRIMESREQUIRED ; i++)
      {
         index = 8*(int)(PRIMECOUNT*Math.random());    
         primes[i] = buf.getLong(index);
         buf.putLong(index, REPLACEMENT );
      }

      StringBuffer str = null;        
      for(int i = 0 ; i<PRIMESREQUIRED ; i++)
      {
        str = new StringBuffer("           ").append(primes[i]);          
          System.out.print((i%5 == 0 ? "\n" : "") + 
                                             str.substring(str.length()-12, str.length()));
      }
      ioFile.close();                   // Close the file and the channel
 
    }
    catch(IOException e)
    {
      e.printStackTrace(System.err);
      System.exit(1);
    }
      System.exit(0);
  }
}
