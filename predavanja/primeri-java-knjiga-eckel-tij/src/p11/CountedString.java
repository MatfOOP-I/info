package p11;
//: c11:CountedString.java
// Creating a good hashCode().
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;
import java.util.*;

public class CountedString {
  private static Test monitor = new Test();
  private static List created = new ArrayList();
  private String s;
  private int id = 0;
  public CountedString(String str) {
    s = str;
    created.add(s);
    Iterator it = created.iterator();
    // Id is the total number of instances
    // of this string in use by CountedString:
    while(it.hasNext())
      if(it.next().equals(s))
        id++;
  }
  public String toString() {
    return "String: " + s + " id: " + id +
      " hashCode(): " + hashCode();
  }
  public int hashCode() {
    // Very simple approach:
    // return s.hashCode() * id;
    // Using Joshua Bloch's recipe:
    int result = 17;
    result = 37*result + s.hashCode();
    result = 37*result + id;
    return result;
  }
  public boolean equals(Object o) {
    return (o instanceof CountedString)
      && s.equals(((CountedString)o).s)
      && id == ((CountedString)o).id;
  }
  public static void main(String[] args) {
    Map map = new HashMap();
    CountedString[] cs = new CountedString[10];
    for(int i = 0; i < cs.length; i++) {
      cs[i] = new CountedString("hi");
      map.put(cs[i], new Integer(i));
    }
    System.out.println(map);
    for(int i = 0; i < cs.length; i++) {
      System.out.println("Looking up " + cs[i]);
      System.out.println(map.get(cs[i]));
    }
    monitor.expect(new String[] {
      "{String: hi id: 4 hashCode(): 146450=3," +
      " String: hi id: 10 hashCode(): 146456=9," +
      " String: hi id: 6 hashCode(): 146452=5," +
      " String: hi id: 1 hashCode(): 146447=0," +
      " String: hi id: 9 hashCode(): 146455=8," +
      " String: hi id: 8 hashCode(): 146454=7," +
      " String: hi id: 3 hashCode(): 146449=2," +
      " String: hi id: 5 hashCode(): 146451=4," +
      " String: hi id: 7 hashCode(): 146453=6," +
      " String: hi id: 2 hashCode(): 146448=1}",
      "Looking up String: hi id: 1 hashCode(): 146447",
      "0",
      "Looking up String: hi id: 2 hashCode(): 146448",
      "1",
      "Looking up String: hi id: 3 hashCode(): 146449",
      "2",
      "Looking up String: hi id: 4 hashCode(): 146450",
      "3",
      "Looking up String: hi id: 5 hashCode(): 146451",
      "4",
      "Looking up String: hi id: 6 hashCode(): 146452",
      "5",
      "Looking up String: hi id: 7 hashCode(): 146453",
      "6",
      "Looking up String: hi id: 8 hashCode(): 146454",
      "7",
      "Looking up String: hi id: 9 hashCode(): 146455",
      "8",
      "Looking up String: hi id: 10 hashCode(): 146456",
      "9"
    });
  }
} ///:~
