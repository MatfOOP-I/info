package p15;
//: c15:LogToFile2.java
// {Clean: LogToFile2.txt,LogToFile2.txt.lck}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.logging.*;

public class LogToFile2 {
  private static Test monitor = new Test();
  private static Logger logger =
    Logger.getLogger("LogToFile2");
  public static void main(String[] args) throws Exception {
    FileHandler logFile= new FileHandler("LogToFile2.txt");
    logFile.setFormatter(new SimpleFormatter());
    logger.addHandler(logFile);
    logger.info("A message logged to the file");
    monitor.expect(new String[] {
      "%% .* LogToFile2 main",
      "INFO: A message logged to the file"
    });
  }
} ///:~
