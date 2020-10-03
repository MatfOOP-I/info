//: c10:PetCount.java
// Using instanceof.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p10;
import com.bruceeckel.simpletest.*;
import java.util.*;

public class PetCount {
  private static Test monitor = new Test();
  private static Random rand = new Random();
  static String[] typenames = {
    "Pet", "Dog", "Pug", "Cat",
    "Rodent", "Gerbil", "Hamster",
  };
  // Exceptions thrown to console:
  public static void main(String[] args) {
    Object[] pets = new Object[15];
    try {
      Class[] petTypes = {
        Class.forName("c10.Dog"),
        Class.forName("c10.Pug"),
        Class.forName("c10.Cat"),
        Class.forName("c10.Rodent"),
        Class.forName("c10.Gerbil"),
        Class.forName("c10.Hamster"),
      };
      for(int i = 0; i < pets.length; i++)
        pets[i] = petTypes[rand.nextInt(petTypes.length)]
          .newInstance();
    } catch(InstantiationException e) {
      System.out.println("Cannot instantiate");
      System.exit(1);
    } catch(IllegalAccessException e) {
      System.out.println("Cannot access");
      System.exit(1);
    } catch(ClassNotFoundException e) {
      System.out.println("Cannot find class");
      System.exit(1);
    }
    AssociativeArray map =
      new AssociativeArray(typenames.length);
    for(int i = 0; i < typenames.length; i++)
      map.put(typenames[i], new Counter());
    for(int i = 0; i < pets.length; i++) {
      Object o = pets[i];
      if(o instanceof Pet)
        ((Counter)map.get("Pet")).i++;
      if(o instanceof Dog)
        ((Counter)map.get("Dog")).i++;
      if(o instanceof Pug)
        ((Counter)map.get("Pug")).i++;
      if(o instanceof Cat)
        ((Counter)map.get("Cat")).i++;
      if(o instanceof Rodent)
        ((Counter)map.get("Rodent")).i++;
      if(o instanceof Gerbil)
        ((Counter)map.get("Gerbil")).i++;
      if(o instanceof Hamster)
        ((Counter)map.get("Hamster")).i++;
    }
    // List each individual pet:
    for(int i = 0; i < pets.length; i++)
      System.out.println(pets[i].getClass());
    // Show the counts:
    System.out.println(map);
    monitor.expect(new Object[] {
      new TestExpression("%% class c10\\."+
        "(Dog|Pug|Cat|Rodent|Gerbil|Hamster)",
        pets.length),
      new TestExpression(
        "%% (Pet|Dog|Pug|Cat|Rodent|Gerbil|Hamster)" +
        " : \\d+", typenames.length)
    });
  }
} ///:~