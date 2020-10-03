package p03;
//: c03:ListCharacters.java
// Demonstrates "for" loop by listing
// all the lowercase ASCII letters.
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import com.bruceeckel.simpletest.*;

public class ListCharacters {
  static Test monitor = new Test();
  public static void main(String[] args) {
    for(int i = 0; i < 128; i++)
      if(Character.isLowerCase((char)i))
        System.out.println("value: " + i +
          " character: " + (char)i);
    monitor.expect(new String[] {
      "value: 97 character: a",
      "value: 98 character: b",
      "value: 99 character: c",
      "value: 100 character: d",
      "value: 101 character: e",
      "value: 102 character: f",
      "value: 103 character: g",
      "value: 104 character: h",
      "value: 105 character: i",
      "value: 106 character: j",
      "value: 107 character: k",
      "value: 108 character: l",
      "value: 109 character: m",
      "value: 110 character: n",
      "value: 111 character: o",
      "value: 112 character: p",
      "value: 113 character: q",
      "value: 114 character: r",
      "value: 115 character: s",
      "value: 116 character: t",
      "value: 117 character: u",
      "value: 118 character: v",
      "value: 119 character: w",
      "value: 120 character: x",
      "value: 121 character: y",
      "value: 122 character: z"
    });
  }
} ///:~
