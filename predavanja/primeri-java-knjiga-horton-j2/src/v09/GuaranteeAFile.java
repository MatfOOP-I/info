package v09;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class GuaranteeAFile {
  public static void main(String[] args) {
    String filename = "C:/Beg Java Stuff/Bonzo/Beanbag/myFile.txt";
    File aFile = new File(filename);    // Create the File object

    // Verify the path is a file.
    if (aFile.isDirectory()) {

      // Abort after a message.
      // You could get input from the keyboard here and try again...
      System.out.println("The path " + aFile.getPath()
                         + " does not specify a file. Program aborted.");
      System.exit(1);
    }

    // If the file doesn't exist
    if (!aFile.isFile()) {
      // Check the parent directory...
      aFile = aFile.getAbsoluteFile();
      File parentDir = new File(aFile.getParent());
      if (!parentDir.exists()) {   // ... and create it if necessary
        parentDir.mkdirs();
      } 
    } 

    // Place to store the stream reference
    FileOutputStream outputFile = null; 
    try {

      // Create the stream opened to append data
      outputFile = new FileOutputStream(aFile, true);
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.err);
    } 
    System.exit(0);
  } 
}
