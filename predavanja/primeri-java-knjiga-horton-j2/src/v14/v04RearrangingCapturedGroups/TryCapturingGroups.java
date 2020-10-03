package v14.v04RearrangingCapturedGroups;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TryCapturingGroups {
  public static void main(String args[]) {
    String regEx = "(Math.pow)"+                                  // Math.pow
    "\\s*\\(" +                                                   // Opening parenthesis
    "\\s*([+|-]?(\\d+\\.?\\d*|\\.\\d+)|([a-zA-Z]\\w*))" +         // First argument
    "\\s*,\\s*" +                                                 // Comma 
    "([+|-]?(\\d+\\.?\\d*|\\.\\d+)|([a-zA-Z]\\w*))" +             // Second argument
    "\\s*\\)";                                                    // Closing parenthesis

//    String regEx = "(Math.pow)\\s*\\(\\s*([+|-]?(\\d+\\.?\\d*|\\.\\d+)|([a-zA-Z]\\w*))\\s*,\\s*([+|-]?(\\d+\\.?\\d*|\\.\\d+)|([a-zA-Z]\\w*))\\s*\\)";
    String oldCode = "double result = Math.pow( 3.0, 16.0); " +
                     "\ndouble resultSquared = Math.pow(2 ,result );"+
                "\ndouble hypotenuse = Math.sqrt(Math.pow(2.0, 30.0)+Math.pow(2 , 40.0));";
    Pattern pattern = Pattern.compile(regEx);
    Matcher m = pattern.matcher(oldCode);

    StringBuffer newCode = new StringBuffer();
    while(m.find())
      m.appendReplacement(newCode, "$1\\($5,$2\\)");

    m.appendTail(newCode);

    System.out.println("Original Code:\n"+oldCode.toString());
    System.out.println("\nNew Code:\n"+newCode.toString());
  }
}
