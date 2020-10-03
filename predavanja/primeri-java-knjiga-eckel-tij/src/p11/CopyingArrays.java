package p11;
//: c11:CopyingArrays.java
// Using System.arraycopy()
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import com.bruceeckel.util.*;
import java.util.*;

public class CopyingArrays {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    int[] i = new int[7];
    int[] j = new int[10];
    Arrays.fill(i, 47);
    Arrays.fill(j, 99);
    System.out.println("i = " + Arrays2.toString(i));
    System.out.println("j = " + Arrays2.toString(j));
    System.arraycopy(i, 0, j, 0, i.length);
    System.out.println("j = " + Arrays2.toString(j));
    int[] k = new int[5];
    Arrays.fill(k, 103);
    System.arraycopy(i, 0, k, 0, k.length);
    System.out.println("k = " + Arrays2.toString(k));
    Arrays.fill(k, 103);
    System.arraycopy(k, 0, i, 0, k.length);
    System.out.println("i = " + Arrays2.toString(i));
    // Objects:
    Integer[] u = new Integer[10];
    Integer[] v = new Integer[5];
    Arrays.fill(u, new Integer(47));
    Arrays.fill(v, new Integer(99));
    System.out.println("u = " + Arrays.asList(u));
    System.out.println("v = " + Arrays.asList(v));
    System.arraycopy(v, 0, u, u.length/2, v.length);
    System.out.println("u = " + Arrays.asList(u));
    monitor.expect(new String[] {
      "i = [47, 47, 47, 47, 47, 47, 47]",
      "j = [99, 99, 99, 99, 99, 99, 99, 99, 99, 99]",
      "j = [47, 47, 47, 47, 47, 47, 47, 99, 99, 99]",
      "k = [47, 47, 47, 47, 47]",
      "i = [103, 103, 103, 103, 103, 47, 47]",
      "u = [47, 47, 47, 47, 47, 47, 47, 47, 47, 47]",
      "v = [99, 99, 99, 99, 99]",
      "u = [47, 47, 47, 47, 47, 99, 99, 99, 99, 99]"
    });
  }
} ///:~
