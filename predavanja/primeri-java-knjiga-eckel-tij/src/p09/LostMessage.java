package p09;
//: c09:LostMessage.java
// How an exception can be lost.
// {ThrowsException}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class VeryImportantException extends Exception {
  public String toString() {
    return "A very important exception!";
  }
}

class HoHumException extends Exception {
  public String toString() {
    return "A trivial exception";
  }
}

public class LostMessage {
  private static Test monitor = new Test();
  void f() throws VeryImportantException {
    throw new VeryImportantException();
  }
  void dispose() throws HoHumException {
    throw new HoHumException();
  }
  public static void main(String[] args) throws Exception {
    LostMessage lm = new LostMessage();
    try {
      lm.f();
    } finally {
      lm.dispose();
    }
    monitor.expect(new String[] {
      "Exception in thread \"main\" A trivial exception",
      "\tat LostMessage.dispose(LostMessage.java:24)",
      "\tat LostMessage.main(LostMessage.java:31)"
    });  }
} ///:~
