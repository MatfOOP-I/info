package p12;
//: c12:AnalyzeSentence.java
// Look for particular sequences in sentences.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class AnalyzeSentence {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    analyze("I am happy about this");
    analyze("I am not happy about this");
    analyze("I am not! I am happy");
    analyze("I am sad about this");
    analyze("I am not sad about this");
    analyze("I am not! I am sad");
    analyze("Are you happy about this?");
    analyze("Are you sad about this?");
    analyze("It's you! I am happy");
    analyze("It's you! I am sad");
    monitor.expect(new String[] {
      "",
      "new sentence >> I am happy about this",
      "I",
      "am",
      "happy",
      "about",
      "this",
      "",
      "new sentence >> I am not happy about this",
      "I",
      "am",
      "not",
      "happy",
      "Sad detected",
      "",
      "new sentence >> I am not! I am happy",
      "I",
      "am",
      "not!",
      "I",
      "am",
      "happy",
      "",
      "new sentence >> I am sad about this",
      "I",
      "am",
      "sad",
      "Sad detected",
      "",
      "new sentence >> I am not sad about this",
      "I",
      "am",
      "not",
      "sad",
      "",
      "new sentence >> I am not! I am sad",
      "I",
      "am",
      "not!",
      "I",
      "am",
      "sad",
      "Sad detected",
      "",
      "new sentence >> Are you happy about this?",
      "Are",
      "you",
      "happy",
      "",
      "new sentence >> Are you sad about this?",
      "Are",
      "you",
      "sad",
      "Sad detected",
      "",
      "new sentence >> It's you! I am happy",
      "It's",
      "you!",
      "I",
      "am",
      "happy",
      "",
      "new sentence >> It's you! I am sad",
      "It's",
      "you!",
      "I",
      "am",
      "sad",
      "Sad detected"
    });
  }
  private static StringTokenizer st;
  private static void analyze(String s) {
    System.out.println("\nnew sentence >> " + s);
    boolean sad = false;
    st = new StringTokenizer(s);
    while(st.hasMoreTokens()) {
      String token = next();
      // Look until you find one of the
      // two starting tokens:
      if(!token.equals("I") &&
         !token.equals("Are"))
        continue; // Top of while loop
      if(token.equals("I")) {
        String tk2 = next();
        if(!tk2.equals("am")) // Must be after I
          break; // Out of while loop
        else {
          String tk3 = next();
          if(tk3.equals("sad")) {
            sad = true;
            break; // Out of while loop
          }
          if(tk3.equals("not")) {
            String tk4 = next();
            if(tk4.equals("sad"))
              break; // Leave sad false
            if(tk4.equals("happy")) {
              sad = true;
              break;
            }
          }
        }
      }
      if(token.equals("Are")) {
        String tk2 = next();
        if(!tk2.equals("you"))
          break; // Must be after Are
        String tk3 = next();
        if(tk3.equals("sad"))
          sad = true;
        break; // Out of while loop
      }
    }
    if(sad) System.out.println("Sad detected");
  }
  static String next() {
    if(st.hasMoreTokens()) {
      String s = st.nextToken();
      System.out.println(s);
      return s;
    }
    else
      return "";
  }
} ///:~
