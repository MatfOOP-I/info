//: c10:AssociativeArray.java
// Associates keys with values.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p10;
import com.bruceeckel.simpletest.*;

public class AssociativeArray {
  private static Test monitor = new Test();
  private Object[][] pairs;
  private int index;
  public AssociativeArray(int length) {
    pairs = new Object[length][2];
  }
  public void put(Object key, Object value) {
    if(index >= pairs.length)
      throw new ArrayIndexOutOfBoundsException();
    pairs[index++] = new Object[] { key, value };
  }
  public Object get(Object key) {
    for(int i = 0; i < index; i++)
      if(key.equals(pairs[i][0]))
        return pairs[i][1];
    throw new RuntimeException("Failed to find key");
  }
  public String toString() {
    String result = "";
    for(int i = 0; i < index; i++) {
      result += pairs[i][0] + " : " + pairs[i][1];
      if(i < index - 1) result += "\n";
    }
    return result;
  }
  public static void main(String[] args) {
    AssociativeArray map = new AssociativeArray(6);
    map.put("sky", "blue");
    map.put("grass", "green");
    map.put("ocean", "dancing");
    map.put("tree", "tall");
    map.put("earth", "brown");
    map.put("sun", "warm");
    try {
      map.put("extra", "object"); // Past the end
    } catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("Too many objects!");
    }
    System.out.println(map);
    System.out.println(map.get("ocean"));
    monitor.expect(new String[] {
      "Too many objects!",
      "sky : blue",
      "grass : green",
      "ocean : dancing",
      "tree : tall",
      "earth : brown",
      "sun : warm",
      "dancing"
    });
  }
} ///:~