package p04;
//: c04:MultiDimArray.java
// Creating multidimensional arrays.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class MultiDimArray {
  static Test monitor = new Test();
  static Random rand = new Random();
  public static void main(String[] args) {
    int[][] a1 = {
      { 1, 2, 3, },
      { 4, 5, 6, },
    };
    for(int i = 0; i < a1.length; i++)
      for(int j = 0; j < a1[i].length; j++)
        System.out.println(
          "a1[" + i + "][" + j + "] = " + a1[i][j]);
    // 3-D array with fixed length:
    int[][][] a2 = new int[2][2][4];
    for(int i = 0; i < a2.length; i++)
      for(int j = 0; j < a2[i].length; j++)
        for(int k = 0; k < a2[i][j].length; k++)
          System.out.println("a2[" + i + "][" + j + "][" +
            k + "] = " + a2[i][j][k]);
    // 3-D array with varied-length vectors:
    int[][][] a3 = new int[rand.nextInt(7)][][];
    for(int i = 0; i < a3.length; i++) {
      a3[i] = new int[rand.nextInt(5)][];
      for(int j = 0; j < a3[i].length; j++)
        a3[i][j] = new int[rand.nextInt(5)];
    }
    for(int i = 0; i < a3.length; i++)
      for(int j = 0; j < a3[i].length; j++)
        for(int k = 0; k < a3[i][j].length; k++)
          System.out.println("a3[" + i + "][" + j + "][" +
            k + "] = " + a3[i][j][k]);
    // Array of nonprimitive objects:
    Integer[][] a4 = {
      { new Integer(1), new Integer(2)},
      { new Integer(3), new Integer(4)},
      { new Integer(5), new Integer(6)},
    };
    for(int i = 0; i < a4.length; i++)
      for(int j = 0; j < a4[i].length; j++)
        System.out.println("a4[" + i + "][" + j +
            "] = " + a4[i][j]);
    Integer[][] a5;
    a5 = new Integer[3][];
    for(int i = 0; i < a5.length; i++) {
      a5[i] = new Integer[3];
      for(int j = 0; j < a5[i].length; j++)
        a5[i][j] = new Integer(i * j);
    }
    for(int i = 0; i < a5.length; i++)
      for(int j = 0; j < a5[i].length; j++)
        System.out.println("a5[" + i + "][" + j +
            "] = " + a5[i][j]);
    // Output test
    int ln = 0;
    for(int i = 0; i < a3.length; i++)
      for(int j = 0; j < a3[i].length; j++)
        for(int k = 0; k < a3[i][j].length; k++)
          ln++;
    monitor.expect(new Object[] {
      "a1[0][0] = 1",
      "a1[0][1] = 2",
      "a1[0][2] = 3",
      "a1[1][0] = 4",
      "a1[1][1] = 5",
      "a1[1][2] = 6",
      new TestExpression(
        "%% a2\\[\\d\\]\\[\\d\\]\\[\\d\\] = 0", 16),
      new TestExpression(
        "%% a3\\[\\d\\]\\[\\d\\]\\[\\d\\] = 0", ln),
      "a4[0][0] = 1",
      "a4[0][1] = 2",
      "a4[1][0] = 3",
      "a4[1][1] = 4",
      "a4[2][0] = 5",
      "a4[2][1] = 6",
      "a5[0][0] = 0",
      "a5[0][1] = 0",
      "a5[0][2] = 0",
      "a5[1][0] = 0",
      "a5[1][1] = 1",
      "a5[1][2] = 2",
      "a5[2][0] = 0",
      "a5[2][1] = 2",
      "a5[2][2] = 4"
    });
  }
} ///:~
