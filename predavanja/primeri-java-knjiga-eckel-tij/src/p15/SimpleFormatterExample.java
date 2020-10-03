package p15;
//: c15:SimpleFormatterExample.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.logging.*;
import java.util.logging.Formatter;
import java.util.*;

public class SimpleFormatterExample {
  private static Test monitor = new Test();
  private static Logger logger =
    Logger.getLogger("SimpleFormatterExample");
  private static void logMessages() {
    logger.info("Line One");
    logger.info("Line Two");
  }
  public static void main(String[] args) {
    logger.setUseParentHandlers(false);
    Handler conHdlr = new ConsoleHandler();
    conHdlr.setFormatter(new Formatter() {
      public String format(LogRecord record) {
        return record.getLevel()  + "  :  "
          + record.getSourceClassName()  + " -:- "
          + record.getSourceMethodName()  + " -:- "
          + record.getMessage() + "\n";
      }
    });
    logger.addHandler(conHdlr);
    logMessages();
    monitor.expect(new String[] {
      "INFO  :  SimpleFormatterExample -:- logMessages "
        + "-:- Line One",
      "INFO  :  SimpleFormatterExample -:- logMessages "
        + "-:- Line Two"
    });
  }
} ///:~
