package p11;
//: c11:MouseListTest.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class MouseListTest {
  private static Test monitor = new Test();
  public static void main(String[] args) {
    MouseList mice = new MouseList();
    for(int i = 0; i < 3; i++)
      mice.add(new Mouse(i));
    for(int i = 0; i < mice.size(); i++)
      MouseTrap.caughtYa(mice.get(i));
    monitor.expect(new String[] {
      "Mouse: 0",
      "Mouse: 1",
      "Mouse: 2"
    });
  }
} ///:~
