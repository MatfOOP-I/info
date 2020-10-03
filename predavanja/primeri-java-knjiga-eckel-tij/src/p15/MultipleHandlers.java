package p15;
//: c15:MultipleHandlers.java
// {Clean: MultipleHandlers.xml,MultipleHandlers.xml.lck}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.logging.*;

public class MultipleHandlers {
  private static Test monitor = new Test();
  private static Logger logger =
    Logger.getLogger("MultipleHandlers");
  public static void main(String[] args) throws Exception {
    FileHandler logFile =
      new FileHandler("MultipleHandlers.xml");
    logger.addHandler(logFile);
    logger.addHandler(new ConsoleHandler());
    logger.warning("Output to multiple handlers");
    monitor.expect(new String[] {
      "%% .* MultipleHandlers main",
      "WARNING: Output to multiple handlers",
      "%% .* MultipleHandlers main",
      "WARNING: Output to multiple handlers"
    });
  }
} ///:~
