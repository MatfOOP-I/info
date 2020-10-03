//: c08:Month.java
// A more robust enumeration system.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p08;
import com.bruceeckel.simpletest.*;

public final class Month {
  private static Test monitor = new Test();
  private String name;
  private Month(String nm) { name = nm; }
  public String toString() { return name; }
  public static final Month
    JAN = new Month("January"),
    FEB = new Month("February"),
    MAR = new Month("March"),
    APR = new Month("April"),
    MAY = new Month("May"),
    JUN = new Month("June"),
    JUL = new Month("July"),
    AUG = new Month("August"),
    SEP = new Month("September"),
    OCT = new Month("October"),
    NOV = new Month("November"),
    DEC = new Month("December");
  public static final Month[] month =  {
    JAN, FEB, MAR, APR, MAY, JUN,
    JUL, AUG, SEP, OCT, NOV, DEC
  };
  public static final Month number(int ord) {
    return month[ord - 1];
  }
  public static void main(String[] args) {
    Month m = Month.JAN;
    System.out.println(m);
    m = Month.number(12);
    System.out.println(m);
    System.out.println(m == Month.DEC);
    System.out.println(m.equals(Month.DEC));
    System.out.println(Month.month[3]);
    monitor.expect(new String[] {
      "January",
      "December",
      "true",
      "true",
      "April"
    });
  }
} ///:~
