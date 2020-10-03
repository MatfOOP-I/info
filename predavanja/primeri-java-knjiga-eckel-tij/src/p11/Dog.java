//: c11:Dog.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p11;

public class Dog {
  private int dogNumber;
  public Dog(int i) { dogNumber = i; }
  public void id() {
    System.out.println("Dog #" + dogNumber);
  }
} ///:~
