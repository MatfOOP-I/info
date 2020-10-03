package v02ch2.SystemInfo;
import java.util.*;

/**
   This program prints out all system properties.
*/
public class SystemInfo
{  
   public static void main(String args[])
   {   
      Properties systemProperties = System.getProperties();
      Enumeration enum2 = systemProperties.propertyNames();
      while (enum2.hasMoreElements())
      {
         String key = (String)enum2.nextElement();
         System.out.println(key + "=" +
            systemProperties.getProperty(key));
      }
   }
}
