package v09;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class AvoidOverwritingFile {
  public static void main(String[] args) {
    String filepath = "C:/Beg Java Stuff/myFile.txt";
    File aFile = new File(filepath);
    FileOutputStream outputFile = null;     // Stores the stream reference
    if (aFile.isFile()) {
      File newFile = aFile;                 // Start with the original file

      // We will append "_old" to the file
      // name repeatedly until it is unique
      do {
        String name = newFile.getName();    // Get the name of the file
        int period = 
          name.indexOf('.');         // Find the separator for the extension
        newFile = new File(newFile.getParent(), 
                           name.substring(0, period) + "_old" 
                           + name.substring(period));
 //     } while (!aFile.renameTo(newFile));   // Stop when no such file exists
      } while (newFile.exists());             // Stop when no such file exists
      aFile.renameTo(newFile);                // Rename the file
    } 

    // Now we can create the new file
    try {

      // Create the stream opened to append data
      outputFile = new FileOutputStream(aFile);
      System.out.println("myFile.txt output stream created");
    } catch (FileNotFoundException e) {
      e.printStackTrace(System.err);
    } 
    System.exit(0);
  }
}
