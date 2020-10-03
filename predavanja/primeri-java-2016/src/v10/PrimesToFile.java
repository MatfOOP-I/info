package v10;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class PrimesToFile {
  public static void main(String[] args) {
    int primesRequired = 100;   // Default count
    if (args.length > 0) {
      try {
        primesRequired = Integer.valueOf(args[0]).intValue();
      } catch (NumberFormatException e) {
        System.out.println("Prime count value invalid. Using default of "
                           + primesRequired);
      }
    }

      long[] primes = new long[primesRequired];   // Array to store primes
      primes[0] = 2;                              // Seed the first prime
      primes[1] = 3;                              // and the second
      // Count of primes found - up to now, which is also the array index
      int count = 2;
      // Next integer to be tested
      long number = 5;

      outer:
      for (; count < primesRequired; number += 2) {

        // The maximum divisor we need to try is square root of number
        long limit = (long) Math.ceil(Math.sqrt((double) number));

        // Divide by all the primes we have up to limit
        for (int i = 1; i < count && primes[i] <= limit; i++) 
          if (number % primes[i] == 0)           // Is it an exact divisor?
            continue outer;                      // yes, try the next number

        primes[count++] = number;                // We got one!
      }

    File aFile = new File("C:/Beg Java Stuff/primes.bin");
    FileOutputStream outputFile = null;
    try {
      outputFile = new FileOutputStream(aFile);   // Create the file stream
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.err);
      System.exit(1);
    } 
    FileChannel file = 
      // Get the channel from the stream
      outputFile.getChannel();
    final int BUFFERSIZE = 100;                // Byte buffer size
    ByteBuffer buf = ByteBuffer.allocate(BUFFERSIZE);
    LongBuffer longBuf = buf.asLongBuffer();   // View buffer for type long

    // Count of primes written to file
    int primesWritten = 0;

    while (primesWritten < primes.length) {
      longBuf.put(primes,              // Array to be written
                  primesWritten, // Index of 1st element to be written
                  Math.min(longBuf.capacity(),  
                        primes.length - primesWritten)); // Element count
      buf.limit(8 * longBuf.position());
      try {
        file.write(buf);
        primesWritten += longBuf.position();
      } catch (IOException e) {
        e.printStackTrace(System.err);
        System.exit(1);
      } 
      longBuf.clear();
      buf.clear();
    } 

    try {
      System.out.println("File written is " + file.size() + " bytes.");
      outputFile.close();   // Close the file and its channel
    } catch (IOException e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
    System.exit(0);
  }
}
