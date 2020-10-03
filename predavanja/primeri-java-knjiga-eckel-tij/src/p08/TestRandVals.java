package p08;
//: c08:TestRandVals.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class TestRandVals {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    System.out.println(RandVals.randomInt);
    System.out.println(RandVals.randomLong);
    System.out.println(RandVals.randomFloat);
    System.out.println(RandVals.randomDouble);
    monitor.expect(new String[] {
      "%% -?\\d+",
      "%% -?\\d+",
      "%% -?\\d\\.\\d+E?-?\\d+",
      "%% -?\\d\\.\\d+E?-?\\d+"
    });
  }
} ///:~
