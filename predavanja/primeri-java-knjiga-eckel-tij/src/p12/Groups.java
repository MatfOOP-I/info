package p12;
//: c12:Groups.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.regex.*;
import com.bruceeckel.simpletest.*;

public class Groups {
  private static Test monitor = new Test();
  static public final String poem =
    "Twas brillig, and the slithy toves\n" +
    "Did gyre and gimble in the wabe.\n" +
    "All mimsy were the borogoves,\n" +
    "And the mome raths outgrabe.\n\n" +
    "Beware the Jabberwock, my son,\n" +
    "The jaws that bite, the claws that catch.\n" +
    "Beware the Jubjub bird, and shun\n" +
    "The frumious Bandersnatch.";
  public static void main(String[] args) {
    Matcher m =
      Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
        .matcher(poem);
    while(m.find()) {
      for(int j = 0; j <= m.groupCount(); j++)
        System.out.print("[" + m.group(j) + "]");
      System.out.println();
    }
    monitor.expect(new String[]{
      "[the slithy toves]" +
      "[the][slithy toves][slithy][toves]",
      "[in the wabe.][in][the wabe.][the][wabe.]",
      "[were the borogoves,]" +
      "[were][the borogoves,][the][borogoves,]",
      "[mome raths outgrabe.]" +
      "[mome][raths outgrabe.][raths][outgrabe.]",
      "[Jabberwock, my son,]" +
      "[Jabberwock,][my son,][my][son,]",
      "[claws that catch.]" +
      "[claws][that catch.][that][catch.]",
      "[bird, and shun][bird,][and shun][and][shun]",
      "[The frumious Bandersnatch.][The]" +
      "[frumious Bandersnatch.][frumious][Bandersnatch.]"
    });
  }
} ///:~