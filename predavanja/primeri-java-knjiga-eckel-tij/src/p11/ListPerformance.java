package p11;
//: c11:ListPerformance.java
// Demonstrates performance differences in Lists.
// {Args: 500}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;
import com.bruceeckel.util.*;

public class ListPerformance {
  private static int reps = 10000;
  private static int quantity = reps / 10;
  private abstract static class Tester {
    private String name;
    Tester(String name) { this.name = name; }
    abstract void test(List a);
  }
  private static Tester[] tests = {
    new Tester("get") {
      void test(List a) {
        for(int i = 0; i < reps; i++) {
          for(int j = 0; j < quantity; j++)
            a.get(j);
        }
      }
    },
    new Tester("iteration") {
      void test(List a) {
        for(int i = 0; i < reps; i++) {
          Iterator it = a.iterator();
          while(it.hasNext())
            it.next();
        }
      }
    },
    new Tester("insert") {
      void test(List a) {
        int half = a.size()/2;
        String s = "test";
        ListIterator it = a.listIterator(half);
        for(int i = 0; i < reps * 10; i++)
          it.add(s);
      }
    },
    new Tester("remove") {
      void test(List a) {
        ListIterator it = a.listIterator(3);
        while(it.hasNext()) {
          it.next();
          it.remove();
        }
      }
    },
  };
  public static void test(List a) {
    // Strip qualifiers from class name:
    System.out.println("Testing " +
      a.getClass().getName().replaceAll("\\w+\\.", ""));
    for(int i = 0; i < tests.length; i++) {
      Collections2.fill(a, Collections2.countries.reset(),
        quantity);
      System.out.print(tests[i].name);
      long t1 = System.currentTimeMillis();
      tests[i].test(a);
      long t2 = System.currentTimeMillis();
      System.out.println(": " + (t2 - t1));
    }
  }
  public static void testArrayAsList(int reps) {
    System.out.println("Testing array as List");
    // Can only do first two tests on an array:
    for(int i = 0; i < 2; i++) {
      String[] sa = new String[quantity];
      Arrays2.fill(sa, Collections2.countries.reset());
      List a = Arrays.asList(sa);
      System.out.print(tests[i].name);
      long t1 = System.currentTimeMillis();
      tests[i].test(a);
      long t2 = System.currentTimeMillis();
      System.out.println(": " + (t2 - t1));
    }
  }
  public static void main(String[] args) {
    // Choose a different number of
    // repetitions via the command line:
    if(args.length > 0)
      reps = Integer.parseInt(args[0]);
    System.out.println(reps + " repetitions");
    testArrayAsList(reps);
    test(new ArrayList());
    test(new LinkedList());
    test(new Vector());
  }
} ///:~
