package p12;
//: c12:PreferencesDemo.java
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.util.prefs.*;
import java.util.*;

public class PreferencesDemo {
  public static void main(String[] args) throws Exception {
    Preferences prefs = Preferences
      .userNodeForPackage(PreferencesDemo.class);
    prefs.put("Location", "Oz");
    prefs.put("Footwear", "Ruby Slippers");
    prefs.putInt("Companions", 4);
    prefs.putBoolean("Are there witches?", true);
    int usageCount = prefs.getInt("UsageCount", 0);
    usageCount++;
    prefs.putInt("UsageCount", usageCount);
    Iterator it = Arrays.asList(prefs.keys()).iterator();
    while(it.hasNext()) {
      String key = it.next().toString();
      System.out.println(key + ": "+ prefs.get(key, null));
    }
    // You must always provide a default value:
    System.out.println(
      "How many companions does Dorothy have? " + 
      prefs.getInt("Companions", 0));
  }
} ///:~