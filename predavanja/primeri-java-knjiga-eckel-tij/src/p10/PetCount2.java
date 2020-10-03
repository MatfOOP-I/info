//: c10:PetCount2.java
// Using class literals.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p10;
import com.bruceeckel.simpletest.*;
import java.util.*;

public class PetCount2 {
  private static Test monitor = new Test();
  private static Random rand = new Random();
  public static void main(String[] args) {
    Object[] pets = new Object[15];
    Class[] petTypes = {
      // Class literals:
      Pet.class,
      Dog.class,
      Pug.class,
      Cat.class,
      Rodent.class,
      Gerbil.class,
      Hamster.class,
    };
    try {
      for(int i = 0; i < pets.length; i++) {
        // Offset by one to eliminate Pet.class:
        int rnd = 1 + rand.nextInt(petTypes.length - 1);
        pets[i] = petTypes[rnd].newInstance();
      }
    } catch(InstantiationException e) {
      System.out.println("Cannot instantiate");
      System.exit(1);
    } catch(IllegalAccessException e) {
      System.out.println("Cannot access");
      System.exit(1);
    }
    AssociativeArray map =
      new AssociativeArray(petTypes.length);
    for(int i = 0; i < petTypes.length; i++)
      map.put(petTypes[i].toString(), new Counter());
    for(int i = 0; i < pets.length; i++) {
      Object o = pets[i];
      if(o instanceof Pet)
        ((Counter)map.get("class c10.Pet")).i++;
      if(o instanceof Dog)
        ((Counter)map.get("class c10.Dog")).i++;
      if(o instanceof Pug)
        ((Counter)map.get("class c10.Pug")).i++;
      if(o instanceof Cat)
        ((Counter)map.get("class c10.Cat")).i++;
      if(o instanceof Rodent)
        ((Counter)map.get("class c10.Rodent")).i++;
      if(o instanceof Gerbil)
        ((Counter)map.get("class c10.Gerbil")).i++;
      if(o instanceof Hamster)
        ((Counter)map.get("class c10.Hamster")).i++;
    }
    // List each individual pet:
    for(int i = 0; i < pets.length; i++)
      System.out.println(pets[i].getClass());
    // Show the counts:
    System.out.println(map);
    monitor.expect(new Object[] {
      new TestExpression("%% class c10\\." +
        "(Dog|Pug|Cat|Rodent|Gerbil|Hamster)",
        pets.length),
      new TestExpression("%% class c10\\." +
        "(Pet|Dog|Pug|Cat|Rodent|Gerbil|Hamster) : \\d+",
        petTypes.length)
    });
  }
} ///:~
