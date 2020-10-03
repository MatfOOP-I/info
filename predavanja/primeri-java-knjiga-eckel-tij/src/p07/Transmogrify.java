package p07;
//: c07:Transmogrify.java
// Dynamically changing the behavior of an object
// via composition (the "State" design pattern).
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

abstract class Actor {
  public abstract void act();
}

class HappyActor extends Actor {
  public void act() {
    System.out.println("HappyActor");
  }
}

class SadActor extends Actor {
  public void act() {
    System.out.println("SadActor");
  }
}

class Stage {
  private Actor actor = new HappyActor();
  public void change() { actor = new SadActor(); }
  public void performPlay() { actor.act(); }
}

public class Transmogrify {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    Stage stage = new Stage();
    stage.performPlay();
    stage.change();
    stage.performPlay();
    monitor.expect(new String[] {
      "HappyActor",
      "SadActor"
    });
  }
} ///:~
