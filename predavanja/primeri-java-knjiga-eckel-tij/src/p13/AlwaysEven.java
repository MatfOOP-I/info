package p13;
//: c13:AlwaysEven.java
// Demonstrating thread collision over resources by
// reading an object in an unstable intermediate state.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class AlwaysEven {
  private int i;
  public void next() { i++; i++; }
  public int getValue() { return i; }
  public static void main(String[] args) {
    final AlwaysEven ae = new AlwaysEven();
    new Thread("Watcher") {
      public void run() {
        while(true) {
          int val = ae.getValue();
          if(val % 2 != 0) {
            System.out.println(val);
            System.exit(0);
          }
        }
      }
    }.start();
    while(true)
      ae.next();
  }
} ///:~
