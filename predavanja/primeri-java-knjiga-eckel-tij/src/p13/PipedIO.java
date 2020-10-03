package p13;
//: c13:PipedIO.java
// Using pipes for inter-thread I/O
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.*;
import java.util.*;

class Sender extends Thread {
  private Random rand = new Random();
  private PipedWriter out = new PipedWriter();
  public PipedWriter getPipedWriter() { return out; }
  public void run() {
    while(true) {
      for(char c = 'A'; c <= 'z'; c++) {
        try {
          out.write(c);
          sleep(rand.nextInt(500));
        } catch(Exception e) {
          throw new RuntimeException(e);
        }
      }
    }
  }
}

class Receiver extends Thread {
  private PipedReader in;
  public Receiver(Sender sender) throws IOException {
    in = new PipedReader(sender.getPipedWriter());
  }
  public void run() {
    try {
      while(true) {
        // Blocks until characters are there:
        System.out.println("Read: " + (char)in.read());
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
}

public class PipedIO {
  public static void main(String[] args) throws Exception {
    Sender sender = new Sender();
    Receiver receiver = new Receiver(sender);
    sender.start();
    receiver.start();
    new Timeout(4000, "Terminated");
  }
} ///:~
