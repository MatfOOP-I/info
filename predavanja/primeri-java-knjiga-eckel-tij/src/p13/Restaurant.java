package p13;
//: c13:Restaurant.java
// The producer-consumer approach to thread cooperation.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

class Order {
  private static int i = 0;
  private int count = i++;
  public Order() {
    if(count == 10) {
      System.out.println("Out of food, closing");
      System.exit(0);
    }
  }
  public String toString() { return "Order " + count; }
}

class WaitPerson extends Thread {
  private Restaurant restaurant;
  public WaitPerson(Restaurant r) {
    restaurant = r;
    start();
  }
  public void run() {
    while(true) {
      while(restaurant.order == null)
        synchronized(this) {
          try {
            wait();
          } catch(InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      System.out.println(
        "Waitperson got " + restaurant.order);
      restaurant.order = null;
    }
  }
}

class Chef extends Thread {
  private Restaurant restaurant;
  private WaitPerson waitPerson;
  public Chef(Restaurant r, WaitPerson w) {
    restaurant = r;
    waitPerson = w;
    start();
  }
  public void run() {
    while(true) {
      if(restaurant.order == null) {
        restaurant.order = new Order();
        System.out.print("Order up! ");
        synchronized(waitPerson) {
          waitPerson.notify();
        }
      }
      try {
        sleep(100);
      } catch(InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}

public class Restaurant {
  private static Test monitor = new Test();
  Order order; // Package access
  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant();
    WaitPerson waitPerson = new WaitPerson(restaurant);
    Chef chef = new Chef(restaurant, waitPerson);
    monitor.expect(new String[] {
      "Order up! Waitperson got Order 0",
      "Order up! Waitperson got Order 1",
      "Order up! Waitperson got Order 2",
      "Order up! Waitperson got Order 3",
      "Order up! Waitperson got Order 4",
      "Order up! Waitperson got Order 5",
      "Order up! Waitperson got Order 6",
      "Order up! Waitperson got Order 7",
      "Order up! Waitperson got Order 8",
      "Order up! Waitperson got Order 9",
      "Out of food, closing"
    }, Test.WAIT);
  }
} ///:~
