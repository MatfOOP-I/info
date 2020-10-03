//: c12:WordCount.java
// Counts words in a file, outputs results in sorted form.
// {Args: WordCount.java}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
package p12;
import com.bruceeckel.simpletest.*;
import java.io.*;
import java.util.*;

class Counter {
  private int i = 1;
  public int read() { return i; }
  public void increment() { i++; }
}

public class WordCount {
  private static Test monitor = new Test();
  private static final String usage =
    "Usage: \nWordCount file\n" +
    "Counts the words in the file and " +
    "outputs results in sorted form.";
  private FileReader file;
  private StreamTokenizer st;
  // A TreeMap keeps keys in sorted order:
  private TreeMap counts = new TreeMap();
  public WordCount(String filename)
    throws FileNotFoundException {
    try {
      file = new FileReader(filename);
      st = new StreamTokenizer(new BufferedReader(file));
      st.ordinaryChar('.');
      st.ordinaryChar('-');
    } catch(FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
  public void dispose() {
    try {
      file.close();
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
  public void countWords() {
    try {
      while(st.nextToken() !=
        StreamTokenizer.TT_EOF) {
        String s;
        switch(st.ttype) {
          case StreamTokenizer.TT_EOL:
            s = new String("EOL");
            break;
          case StreamTokenizer.TT_NUMBER:
            s = Double.toString(st.nval);
            break;
          case StreamTokenizer.TT_WORD:
            s = st.sval; // Already a String
            break;
          default: // single character in ttype
            s = String.valueOf((char)st.ttype);
        }
        if(counts.containsKey(s))
          ((Counter)counts.get(s)).increment();
        else
          counts.put(s, new Counter());
      }
    } catch(IOException e) {
      throw new RuntimeException(e);
    }
  }
  public Collection values() {
    return counts.values();
  }
  public Set keySet() { return counts.keySet(); }
  public Counter getCounter(String s) {
    return (Counter)counts.get(s);
  }
  public static void main(String[] args)
  throws FileNotFoundException {
    if(args.length == 0) {
      System.out.println(usage);
      System.exit(1);
    }
    WordCount wc = new WordCount(args[0]);
    wc.countWords();
    Iterator keys = wc.keySet().iterator();
    while(keys.hasNext()) {
      String key = (String)keys.next();
      System.out.println(
        key + ": " + wc.getCounter(key).read());
    }
    wc.dispose();
    monitor.expect(new Object[] {
      new TestExpression("%% .+: \\d+", wc.keySet().size())
    });
  }
} ///:~