package p11;
//: c11:MapPerformance.java
// Demonstrates performance differences in Maps.
// {Args: 500}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.*;
import com.bruceeckel.util.*;

public class MapPerformance {
  private static int reps = 50000;
  private abstract static class Tester {
    String name;
    Tester(String name) { this.name = name; }
    abstract void test(Map m, int size);
  }
  private static Tester[] tests = {
    new Tester("put") {
      void test(Map m, int size) {
        for(int i = 0; i < reps; i++) {
          m.clear();
          Collections2.fill(m,
            Collections2.geography.reset(), size);
        }
      }
    },
    new Tester("get") {
      void test(Map m, int size) {
        for(int i = 0; i < reps; i++)
          for(int j = 0; j < size; j++)
            m.get(Integer.toString(j));
      }
    },
    new Tester("iteration") {
      void test(Map m, int size) {
        for(int i = 0; i < reps * 10; i++) {
          Iterator it = m.entrySet().iterator();
          while(it.hasNext())
            it.next();
        }
      }
    },
  };
  public static void test(Map m, int size) {
    // Strip qualifiers from class name:
    System.out.println("Testing " +
      m.getClass().getName().replaceAll("\\w+\\.", "") +
      " size " + size);
    Collections2.fill(m,
      Collections2.geography.reset(), size);
    for(int i = 0; i < tests.length; i++) {
      System.out.print(tests[i].name);
      long t1 = System.currentTimeMillis();
      tests[i].test(m, size);
      long t2 = System.currentTimeMillis();
      System.out.println(": " +
        ((double)(t2 - t1)/(double)size));
    }
  }
  public static void main(String[] args) {
    // Choose a different number of
    // repetitions via the command line:
    if(args.length > 0)
      reps = Integer.parseInt(args[0]);
    System.out.println(reps + " repetitions");
    // Small:
    test(new TreeMap(), 10);
    test(new HashMap(), 10);
    test(new LinkedHashMap(), 10);
    test(new IdentityHashMap(), 10);
    test(new WeakHashMap(), 10);
    test(new Hashtable(), 10);
    // Medium:
    test(new TreeMap(), 100);
    test(new HashMap(), 100);
    test(new LinkedHashMap(), 100);
    test(new IdentityHashMap(), 100);
    test(new WeakHashMap(), 100);
    test(new Hashtable(), 100);
    // Large:
    test(new TreeMap(), 1000);
    test(new HashMap(), 1000);
    test(new LinkedHashMap(), 1000);
    test(new IdentityHashMap(), 1000);
    test(new WeakHashMap(), 1000);
    test(new Hashtable(), 1000);
  }
} ///:~
