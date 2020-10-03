package p11;
//: c11:SpringDetector2.java
// A working key.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class SpringDetector2 {
  private static Test monitor = new Test();
  public static void main(String[] args) throws Exception {
    SpringDetector.detectSpring(Groundhog2.class);
    monitor.expect(new String[] {
      "%% map = \\{(Groundhog #\\d=" +
      "(Early Spring!|Six more weeks of Winter!)" +
      "(, )?){10}\\}",
      "",
      "Looking up prediction for Groundhog #3",
      "%% Early Spring!|Six more weeks of Winter!"
    });
  }
} ///:~
