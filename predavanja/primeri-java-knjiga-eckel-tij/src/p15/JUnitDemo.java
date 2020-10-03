package p15;
//: c15:JUnitDemo.java
// Simple use of JUnit to test ArrayList
// {Depends: junit.jar}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;
import junit.framework.*;

// So we can see the list objects being created,
// and keep track of when they are cleaned up:
class CountedList extends ArrayList {
  private static int counter = 0;
  private int id = counter++;
  public CountedList() {
    System.out.println("CountedList #" + id);
  }
  public int getId() { return id; }
}

public class JUnitDemo extends TestCase {
  private static com.bruceeckel.simpletest.Test monitor =
    new com.bruceeckel.simpletest.Test();
  private CountedList list = new CountedList();
  // You can use the constructor instead of setUp():
  public JUnitDemo(String name) {
    super(name);
    for(int i = 0; i < 3; i++)
      list.add("" + i);
  }
  // Thus, setUp() is optional, but is run right
  // before the test:
  protected void setUp() {
    System.out.println("Set up for " + list.getId());
  }
  // tearDown() is also optional, and is called after
  // each test. setUp() and tearDown() can be either
  // protected or public:
  public void tearDown() {
    System.out.println("Tearing down " + list.getId());
  }
  // All tests have method names beginning with "test":
  public void testInsert() {
    System.out.println("Running testInsert()");
    assertEquals(list.size(), 3);
    list.add(1, "Insert");
    assertEquals(list.size(), 4);
    assertEquals(list.get(1), "Insert");
  }
  public void testReplace() {
    System.out.println("Running testReplace()");
    assertEquals(list.size(), 3);
    list.set(1, "Replace");
    assertEquals(list.size(), 3);
    assertEquals(list.get(1), "Replace");
  }
  // A "helper" method to reduce code duplication. As long
  // as the name doesn't start with "test," it will not
  // be automatically executed by JUnit.
  private void compare(ArrayList lst, String[] strs) {
    Object[] array = lst.toArray();
    assertTrue("Arrays not the same length",
      array.length == strs.length);
    for(int i = 0; i < array.length; i++)
      assertEquals(strs[i], (String)array[i]);
  }
  public void testOrder() {
    System.out.println("Running testOrder()");
    compare(list, new String[] { "0", "1", "2" });
  }
  public void testRemove() {
    System.out.println("Running testRemove()");
    assertEquals(list.size(), 3);
    list.remove(1);
    assertEquals(list.size(), 2);
    compare(list, new String[] { "0", "2" });
  }
  public void testAddAll() {
    System.out.println("Running testAddAll()");
    list.addAll(Arrays.asList(new Object[] {
      "An", "African", "Swallow"}));
    assertEquals(list.size(), 6);
    compare(list, new String[] { "0", "1", "2",
       "An", "African", "Swallow" });
  }
  public static void main(String[] args) {
    // Invoke JUnit on the class:
    junit.textui.TestRunner.run(JUnitDemo.class);
    monitor.expect(new String[] {
      "CountedList #0",
      "CountedList #1",
      "CountedList #2",
      "CountedList #3",
      "CountedList #4",
      // '.' indicates the beginning of each test:
      ".Set up for 0",
      "Running testInsert()",
      "Tearing down 0",
      ".Set up for 1",
      "Running testReplace()",
      "Tearing down 1",
      ".Set up for 2",
      "Running testOrder()",
      "Tearing down 2",
      ".Set up for 3",
      "Running testRemove()",
      "Tearing down 3",
      ".Set up for 4",
      "Running testAddAll()",
      "Tearing down 4",
      "",
      "%% Time: .*",
      "",
      "OK (5 tests)",
      "",
    });
  }
} ///:~
