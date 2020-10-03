package p15;
//: c15:LogToFile.java
// {Clean: LogToFile.xml,LogToFile.xml.lck}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.logging.*;

public class LogToFile {
  private static Test monitor = new Test();
  private static Logger logger =
    Logger.getLogger("LogToFile");
  public static void main(String[] args) throws Exception {
    logger.addHandler(new FileHandler("LogToFile.xml"));
    logger.info("A message logged to the file");
    monitor.expect(new String[] {
      "%% .* LogToFile main",
      "INFO: A message logged to the file"
    });
  }
} ///:~
