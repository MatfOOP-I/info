package p09;
//: c09:TurnOffChecking.java
// "Turning off" Checked exceptions.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.io.*;

class WrapCheckedException {
  void throwRuntimeException(int type) {
    try {
      switch(type) {
        case 0: throw new FileNotFoundException();
        case 1: throw new IOException();
        case 2: throw new RuntimeException("Where am I?");
        default: return;
      }
    } catch(Exception e) { // Adapt to unchecked:
      throw new RuntimeException(e);
    }
  }
}

class SomeOtherException extends Exception {}

public class TurnOffChecking {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    WrapCheckedException wce = new WrapCheckedException();
    // You can call f() without a try block, and let
    // RuntimeExceptions go out of the method:
    wce.throwRuntimeException(3);
    // Or you can choose to catch exceptions:
    for(int i = 0; i < 4; i++)
      try {
        if(i < 3)
          wce.throwRuntimeException(i);
        else
          throw new SomeOtherException();
      } catch(SomeOtherException e) {
          System.out.println("SomeOtherException: " + e);
      } catch(RuntimeException re) {
        try {
          throw re.getCause();
        } catch(FileNotFoundException e) {
          System.out.println(
            "FileNotFoundException: " + e);
        } catch(IOException e) {
          System.out.println("IOException: " + e);
        } catch(Throwable e) {
          System.out.println("Throwable: " + e);
        }
      }
    monitor.expect(new String[] {
      "FileNotFoundException: " +
      "java.io.FileNotFoundException",
      "IOException: java.io.IOException",
      "Throwable: java.lang.RuntimeException: Where am I?",
      "SomeOtherException: SomeOtherException"
    });
  }
} ///:~