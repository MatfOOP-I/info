package p13;
//: c13:SimpleDaemons.java
// Daemon threads don't prevent the program from ending.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class SimpleDaemons extends Thread {
  public SimpleDaemons() {
    setDaemon(true); // Must be called before start()
    start();
  }
  public void run() {
    while(true) {
      try {
        sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(this);
    }
  }
  public static void main(String[] args) {
    for(int i = 0; i < 10; i++)
      new SimpleDaemons();
  }
} ///:~
