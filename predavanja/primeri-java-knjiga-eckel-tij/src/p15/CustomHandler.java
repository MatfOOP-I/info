package p15;
//: c15:CustomHandler.java
// How to write custom handler
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.logging.*;
import java.util.*;

public class CustomHandler {
  private static Test monitor = new Test();
  private static Logger logger =
    Logger.getLogger("CustomHandler");
  private static List strHolder = new ArrayList();
  public static void main(String[] args) {
    logger.addHandler(new Handler() {
      public void publish(LogRecord logRecord) {
        strHolder.add(logRecord.getLevel() + ":");
        strHolder.add(logRecord.getSourceClassName()+":");
        strHolder.add(logRecord.getSourceMethodName()+":");
        strHolder.add("<" + logRecord.getMessage() + ">");
        strHolder.add("\n");
      }
      public void flush() {}
      public void close() {}
    });
    logger.warning("Logging Warning");
    logger.info("Logging Info");
    System.out.print(strHolder);
    monitor.expect(new String[] {
      "%% .* CustomHandler main",
      "WARNING: Logging Warning",
      "%% .* CustomHandler main",
      "INFO: Logging Info",
      "[WARNING:, CustomHandler:, main:, " +
      "<Logging Warning>, ",
      ", INFO:, CustomHandler:, main:, <Logging Info>, ",
      "]"
    });
  }
} ///:~
