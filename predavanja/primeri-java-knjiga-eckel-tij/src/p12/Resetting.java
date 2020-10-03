package p12;
//: c12:Resetting.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.regex.*;
import java.io.*;
import com.bruceeckel.simpletest.*;

public class Resetting {
  private static Test monitor = new Test();
  public static void main(String[] args) throws Exception {
    Matcher m = Pattern.compile("[frb][aiu][gx]")
      .matcher("fix the rug with bags");
    while(m.find())
      System.out.println(m.group());
    m.reset("fix the rig with rags");
    while(m.find())
      System.out.println(m.group());
    monitor.expect(new String[]{
      "fix",
      "rug",
      "bag",
      "fix",
      "rig",
      "rag"
    });
  }
} ///:~
