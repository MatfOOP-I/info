package p11;
//: c11:FillingArrays.java
// Using Arrays.fill()
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import com.bruceeckel.util.*;
import java.util.*;

public class FillingArrays {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    int size = 6;
    // Or get the size from the command line:
    if(args.length != 0)
      size = Integer.parseInt(args[0]);
    boolean[] a1 = new boolean[size];
    byte[] a2 = new byte[size];
    char[] a3 = new char[size];
    short[] a4 = new short[size];
    int[] a5 = new int[size];
    long[] a6 = new long[size];
    float[] a7 = new float[size];
    double[] a8 = new double[size];
    String[] a9 = new String[size];
    Arrays.fill(a1, true);
    System.out.println("a1 = " + Arrays2.toString(a1));
    Arrays.fill(a2, (byte)11);
    System.out.println("a2 = " + Arrays2.toString(a2));
    Arrays.fill(a3, 'x');
    System.out.println("a3 = " + Arrays2.toString(a3));
    Arrays.fill(a4, (short)17);
    System.out.println("a4 = " + Arrays2.toString(a4));
    Arrays.fill(a5, 19);
    System.out.println("a5 = " + Arrays2.toString(a5));
    Arrays.fill(a6, 23);
    System.out.println("a6 = " + Arrays2.toString(a6));
    Arrays.fill(a7, 29);
    System.out.println("a7 = " + Arrays2.toString(a7));
    Arrays.fill(a8, 47);
    System.out.println("a8 = " + Arrays2.toString(a8));
    Arrays.fill(a9, "Hello");
    System.out.println("a9 = " + Arrays.asList(a9));
    // Manipulating ranges:
    Arrays.fill(a9, 3, 5, "World");
    System.out.println("a9 = " + Arrays.asList(a9));
    monitor.expect(new String[] {
      "a1 = [true, true, true, true, true, true]",
      "a2 = [11, 11, 11, 11, 11, 11]",
      "a3 = [x, x, x, x, x, x]",
      "a4 = [17, 17, 17, 17, 17, 17]",
      "a5 = [19, 19, 19, 19, 19, 19]",
      "a6 = [23, 23, 23, 23, 23, 23]",
      "a7 = [29.0, 29.0, 29.0, 29.0, 29.0, 29.0]",
      "a8 = [47.0, 47.0, 47.0, 47.0, 47.0, 47.0]",
      "a9 = [Hello, Hello, Hello, Hello, Hello, Hello]",
      "a9 = [Hello, Hello, Hello, World, World, Hello]"
    });
  }
} ///:~
