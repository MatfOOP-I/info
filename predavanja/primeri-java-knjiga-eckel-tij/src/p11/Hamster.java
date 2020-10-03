package p11;
//: c11:Hamster.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class Hamster {
  private int hamsterNumber;
  public Hamster(int hamsterNumber) {
    this.hamsterNumber = hamsterNumber;
  }
  public String toString() {
    return "This is Hamster #" + hamsterNumber;
  }
} ///:~
