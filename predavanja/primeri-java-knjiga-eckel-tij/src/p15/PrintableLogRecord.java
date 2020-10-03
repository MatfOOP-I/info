package p15;
//: c15:PrintableLogRecord.java
// Override LogRecord toString()
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.ResourceBundle;
import java.util.logging.*;

public class PrintableLogRecord extends LogRecord {
  private static Test monitor = new Test();
  public PrintableLogRecord(Level level, String str) {
    super(level, str);
  }
  public String toString() {
    String result = "Level<" + getLevel() + ">\n"
      + "LoggerName<" + getLoggerName() + ">\n"
      + "Message<" + getMessage() + ">\n"
      + "CurrentMillis<" + getMillis() + ">\n"
      + "Params";
    Object[] objParams = getParameters();
    if(objParams == null)
      result += "<null>\n";
    else
      for(int i = 0; i < objParams.length; i++)
        result += "  Param # <" + i + " value " +
          objParams[i].toString() + ">\n";
    result += "ResourceBundle<" + getResourceBundle()
      + ">\nResourceBundleName<" + getResourceBundleName()
      + ">\nSequenceNumber<" + getSequenceNumber()
      + ">\nSourceClassName<" + getSourceClassName()
      + ">\nSourceMethodName<" + getSourceMethodName()
      + ">\nThread Id<" + getThreadID()
      + ">\nThrown<" + getThrown() + ">";
    return result;
  }
  public static void main(String[] args) {
    PrintableLogRecord logRecord = new PrintableLogRecord(
      Level.FINEST, "Simple Log Record");
    System.out.println(logRecord);
    monitor.expect(new String[] {
      "Level<FINEST>",
      "LoggerName<null>",
      "Message<Simple Log Record>",
      "%% CurrentMillis<.+>",
      "Params<null>",
      "ResourceBundle<null>",
      "ResourceBundleName<null>",
      "SequenceNumber<0>",
      "SourceClassName<null>",
      "SourceMethodName<null>",
      "Thread Id<10>",
      "Thrown<null>"
    });
  }
} ///:~
