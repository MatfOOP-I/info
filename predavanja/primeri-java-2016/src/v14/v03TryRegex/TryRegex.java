package v14.v03TryRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

class TryRegex
 {
  public static void main(String args[])
 {
    //  A regex and a string in which to search are specified
    String regEx = "h[aio]d";
    String str = "Ted and Ned Hodge hid their hod and huddled in the hedge.";

    // The matches in the output will be marked (fixed-width font required)
    char[]  marker = new char[str.length()];
    Arrays.fill(marker,' '); //  So we can later replace spaces with marker characters

    //  Obtain the required matcher
    Pattern pattern = Pattern.compile(regEx);
    Matcher m = pattern.matcher(str);
 
    // Find every match and mark it
    while( m.find() ){
      System.out.println("Pattern found at Start: "+m.start()+" End: "+m.end());
      Arrays.fill(marker,m.start(),m.end(),'^');
    }

    // Show the object string with matches marked under it
    System.out.println(str);
    System.out.println(new String(marker));
  }
}
