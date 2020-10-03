package v09;
import java.io.File;

public class TryFile {
  public static void main(String[] args) {

    // Create an object that is a directory
    File myDir = new File("C:/j2sdk1.4.0/src/java/io");
    System.out.println(myDir + (myDir.isDirectory() ? " is" : " is not")
                       + " a directory.");

    // Create an object that is a file
    File myFile = new File(myDir, "File.java");
    System.out.println(myFile + (myFile.exists() ? " does" : " does not")
                       + " exist");
    System.out.println(myFile + (myFile.isFile() ? " is" : " is not")
                       + " a file.");
    System.out.println(myFile + (myFile.isHidden() ? " is" : " is not")
                       + " hidden");
    System.out.println("You can" + (myFile.canRead() ? " " : "not ")
                       + "read " + myFile);
    System.out.println("You can" + (myFile.canWrite() ? " " : "not ")
                       + "write " + myFile);
    return;
  }
}
