package p15;
//: c15:InfoLogging.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.logging.*;
import java.io.*;

public class InfoLogging {
  private static Test monitor = new Test();
  private static Logger logger =
    Logger.getLogger("InfoLogging");
  public static void main(String[] args) {
    logger.info("Logging an INFO-level message");
    monitor.expect(new String[] {
      "%% .* InfoLogging main",
      "INFO: Logging an INFO-level message"
    });
  }
} ///:~
