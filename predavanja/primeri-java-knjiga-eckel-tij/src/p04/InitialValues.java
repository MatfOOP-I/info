package p04;
//: c04:InitialValues.java
// Shows default initial values.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class InitialValues {
  static Test monitor = new Test();
  boolean t;
  char c;
  byte b;
  short s;
  int i;
  long l;
  float f;
  double d;
  void print(String s) { System.out.println(s); }
  void printInitialValues() {
    print("Data type      Initial value");
    print("boolean        " + t);
    print("char           [" + c + "]");
    print("byte           " + b);
    print("short          " + s);
    print("int            " + i);
    print("long           " + l);
    print("float          " + f);
    print("double         " + d);
  }
  public static void main(String[] args) {
    InitialValues iv = new InitialValues();
    iv.printInitialValues();
    /* You could also say:
    new InitialValues().printInitialValues();
    */
    monitor.expect(new String[] {
      "Data type      Initial value",
      "boolean        false",
      "char           [" + (char)0 + "]",
      "byte           0",
      "short          0",
      "int            0",
      "long           0",
      "float          0.0",
      "double         0.0"
    });
  }
} ///:~
