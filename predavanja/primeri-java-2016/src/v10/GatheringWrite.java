package v10;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class GatheringWrite {
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
    long number = 5;                            // Next integer to be tested

    outer:
    for (; count < primesRequired; number += 2) {

      // The maximum divisor we need to try is square root of number
      long limit = (long) Math.ceil(Math.sqrt((double) number));

      // Divide by all the primes we have up to limit
      for (int i = 1; i < count && primes[i] <= limit; i++) {
        if (number % primes[i] == 0) {   // Is it an exact divisor?
          continue outer;                // yes, try the next number

        }
      }
      primes[count++] = number;          // We got one!
    }

    File aFile = new File("C:/Beg Java Stuff/primes.txt");
    FileOutputStream outputFile = null;
    try {
      outputFile = new FileOutputStream(aFile);
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }
    FileChannel file = outputFile.getChannel();

    // Array of buffer references
    ByteBuffer[] buffers = new ByteBuffer[3];
    buffers[0] = ByteBuffer.allocate(8);   // To hold a double value
    buffers[2] = ByteBuffer.allocate(8);   // To hold a long value

    String primeStr = null;
    for (int primesWritten = 0; primesWritten < primes.length; 
         primesWritten++) {
      primeStr = "prime = " + primes[primesWritten];
      buffers[0].putDouble((double) primeStr.length()).flip();
      buffers[1] = ByteBuffer.allocate(primeStr.length());
      buffers[1].put(primeStr.getBytes()).flip();
      buffers[2].putLong(primes[primesWritten]).flip();
      try {
        file.write(buffers);
      } catch (IOException e) {
        e.printStackTrace(System.err);
        System.exit(1);
      } 
      buffers[0].clear();
      buffers[2].clear();
    }

    try {
      System.out.println("File written is " + file.size() + " bytes.");
      outputFile.close();   // Close the file and its channel
    } catch (IOException e) {
      e.printStackTrace(System.err);
      System.exit(1);
    }

    System.out.println("File closed");
    System.exit(0);
  }
}
