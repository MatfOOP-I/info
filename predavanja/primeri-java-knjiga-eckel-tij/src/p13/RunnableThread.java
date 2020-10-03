package p13;
//: c13:RunnableThread.java
// SimpleThread using the Runnable interface.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

public class RunnableThread implements Runnable {
  private int countDown = 5;
  public String toString() {
    return "#" + Thread.currentThread().getName() +
      ": " + countDown;
  }
  public void run() {
    while(true) {
      System.out.println(this);
      if(--countDown == 0) return;
    }
  }
  public static void main(String[] args) {
    for(int i = 1; i <= 5; i++)
      new Thread(new RunnableThread(), "" + i).start();
    // Output is like SimpleThread.java
  }
} ///:~
