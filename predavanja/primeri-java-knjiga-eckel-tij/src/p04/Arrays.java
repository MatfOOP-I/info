package p04;
//: c04:Arrays.java
// Arrays of primitives.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class Arrays {
  static Test monitor = new Test();
  public static void main(String[] args) {
    int[] a1 = { 1, 2, 3, 4, 5 };
    int[] a2;
    a2 = a1;
    for(int i = 0; i < a2.length; i++)
      a2[i]++;
    for(int i = 0; i < a1.length; i++)
      System.out.println(
        "a1[" + i + "] = " + a1[i]);
    monitor.expect(new String[] {
      "a1[0] = 2",
      "a1[1] = 3",
      "a1[2] = 4",
      "a1[3] = 5",
      "a1[4] = 6"
    });
  }
} ///:~
