package p13;
//: c13:Daemons.java
// Daemon threads spawn other daemon threads.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.*;
import com.bruceeckel.simpletest.*;

class Daemon extends Thread {
  private Thread[] t = new Thread[10];
  public Daemon() {
    setDaemon(true);
    start();
  }
  public void run() {
    for(int i = 0; i < t.length; i++)
      t[i] = new DaemonSpawn(i);
    for(int i = 0; i < t.length; i++)
      System.out.println("t[" + i + "].isDaemon() = "
        + t[i].isDaemon());
    while(true)
      yield();
  }
}

class DaemonSpawn extends Thread {
  public DaemonSpawn(int i) {
    start();
    System.out.println("DaemonSpawn " + i + " started");
  }
  public void run() {
    while(true)
      yield();
  }
}

public class Daemons {
  private static Test monitor = new Test();
  public static void main(String[] args) throws Exception {
    Thread d = new Daemon();
    System.out.println("d.isDaemon() = " + d.isDaemon());
    // Allow the daemon threads to
    // finish their startup processes:
    Thread.sleep(1000);
    monitor.expect(new String[] {
      "d.isDaemon() = true",
      "DaemonSpawn 0 started",
      "DaemonSpawn 1 started",
      "DaemonSpawn 2 started",
      "DaemonSpawn 3 started",
      "DaemonSpawn 4 started",
      "DaemonSpawn 5 started",
      "DaemonSpawn 6 started",
      "DaemonSpawn 7 started",
      "DaemonSpawn 8 started",
      "DaemonSpawn 9 started",
      "t[0].isDaemon() = true",
      "t[1].isDaemon() = true",
      "t[2].isDaemon() = true",
      "t[3].isDaemon() = true",
      "t[4].isDaemon() = true",
      "t[5].isDaemon() = true",
      "t[6].isDaemon() = true",
      "t[7].isDaemon() = true",
      "t[8].isDaemon() = true",
      "t[9].isDaemon() = true"
    }, Test.IGNORE_ORDER + Test.WAIT);
  }
} ///:~
