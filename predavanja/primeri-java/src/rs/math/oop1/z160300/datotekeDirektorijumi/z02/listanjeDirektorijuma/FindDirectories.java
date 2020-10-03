package rs.math.oop1.z160300.datotekeDirektorijumi.z02.listanjeDirektorijuma;

import java.io.*;

public class FindDirectories
{
   public static void main(String[] args)
   {
      // if no arguments provided, start at the parent directory
      if (args.length == 0) 
      	args = new String[] { "C:" + File.separator + "Temp" };

      try
      {
         File pathName = new File(args[0]);
         String[] fileNames = pathName.list();

         // enumerate all files in the directory
         for (int i = 0; i < fileNames.length; i++)
         {
            File f = new File(pathName.getPath(), fileNames[i]);

            // if the file is again a directory, call the main method recursively
            if (f.isDirectory())
            {
               System.out.println(f.getCanonicalPath());
               main(new String[] { f.getPath() });
            }
//            else
//            	System.out.println(f.getCanonicalPath());
         }
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}
