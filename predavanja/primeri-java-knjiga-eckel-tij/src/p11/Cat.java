//: c11:Cat.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p11;

public class Cat {
  private int catNumber;
  public Cat(int i) { catNumber = i; }
  public void id() {
    System.out.println("Cat #" + catNumber);
  }
} ///:~
