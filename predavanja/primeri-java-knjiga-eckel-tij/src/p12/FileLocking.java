package p12;
//: c12:FileLocking.java
// {Clean: file.txt}
// From 'Thinking in Java, 3rd ed.' (c) Bruce Eckel 2002
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
import java.io.FileOutputStream;
import java.nio.channels.*;

public class FileLocking {
  public static void main(String[] args) throws Exception {
    FileOutputStream fos= new FileOutputStream("file.txt");
    FileLock fl = fos.getChannel().tryLock();
    if(fl != null) {
      System.out.println("Locked File");
      Thread.sleep(100);
      fl.release();
      System.out.println("Released Lock");
    }
    fos.close();
  }
} ///:~