package p15;
//: c15:InfoLogging2.java
// Guaranteeing proper class and method names
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.logging.*;
import java.io.*;

public class InfoLogging2 {
  private static Test monitor = new Test();
  private static Logger logger =
    Logger.getLogger("InfoLogging2");
  public static void main(String[] args) {
    logger.logp(Level.INFO, "InfoLogging2", "main",
      "Logging an INFO-level message");
    monitor.expect(new String[] {
      "%% .* InfoLogging2 main",
      "INFO: Logging an INFO-level message"
    });
  }
} ///:~
