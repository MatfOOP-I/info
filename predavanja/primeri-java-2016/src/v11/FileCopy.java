package v11;
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class FileCopy
{
  public static void main(String[] args)
  {
    if(args.length==1)
    {
      System.out.println("No file to copy. Application usage is:\n"+
                         "java -classpath . FileCopy \"filepath\"" );
      System.exit(1);
    }
    File fromFile = new File(args[0]);

    if(!fromFile.exists())
    {
      System.out.println("File to copy, "+fromFile.getAbsolutePath()+", does not exist.");
      System.exit(1);
    }
    
//    File toFile = createBackupFile(fromFile);
//    FileInputStream inFile = null;
//    FileOutputStream outFile = null;
//    try
//    {
//      inFile = new FileInputStream(fromFile); 
//      outFile = new FileOutputStream(toFile);
//    }
//    catch(FileNotFoundException e)
//    {
//      e.printStackTrace(System.err);
//      //assert false;
//    }
//
//    FileChannel inChannel = inFile.getChannel();    
//    FileChannel outChannel = outFile.getChannel(); 
//
//    try
//    {
//      int bytesWritten = 0;
//      int byteCount = (int)inChannel.size();
//      while(bytesWritten<byteCount)
//        bytesWritten += inChannel.transferTo(bytesWritten, byteCount-bytesWritten,
//                                                                               outChannel); 
//      
//      System.out.println("File copy complete. " + byteCount + " bytes copied to " +
//                                                                 toFile.getAbsolutePath());
//      inFile.close();
//      outFile.close();
//    } 
//    catch(IOException e)
//    {
//      e.printStackTrace(System.err);
//      System.exit(1);
//    }
    System.exit(0); 
  }
 
  // Code for createBackupFile() goes here...
}
