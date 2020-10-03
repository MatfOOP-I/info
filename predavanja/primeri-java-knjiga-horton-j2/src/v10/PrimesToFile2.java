package v10;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class PrimesToFile2 {
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
      for (int i = 1; i < count && primes[i] <= limit; i++) 
        if (number % primes[i] == 0)    // Is it an exact divisor?
          continue outer;                // yes, try the next number

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
    final int BUFFERSIZE = 100;   // Buffer size in bytes
    ByteBuffer buf = ByteBuffer.allocate(BUFFERSIZE);

    DoubleBuffer doubleBuf = buf.asDoubleBuffer();
    buf.position(8);
    CharBuffer charBuf = buf.asCharBuffer();
    LongBuffer longBuf = null;
    String primeStr = null;

    for (int i = 0; i < primes.length; i++) {
      primeStr = "prime = " + primes[i];          // Create the string
      doubleBuf.put(0,(double) primeStr.length());// Store the string length
      charBuf.put(primeStr);                      // Store the string
      buf.position(2 * charBuf.position() + 8);   // Position for 3rd buffer
      longBuf = buf.asLongBuffer();               // Create the buffer
      longBuf.put(primes[i]);              // Store the binary long value
      buf.position(buf.position() + 8);    // Set position after last value
      buf.flip();                          // and flip
      try {
        file.write(buf);                   // Write the buffer as before.
      } catch (IOException e) {
        e.printStackTrace(System.err);
        System.exit(1);
      } 
      buf.clear();
      doubleBuf.clear();
      charBuf.clear();
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
