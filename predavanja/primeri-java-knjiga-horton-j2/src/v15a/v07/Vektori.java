package v15a.v07;
import java.util.*;

public class Vektori {

   public static void main(String args[]) {
      
       Vector  prvi = new Vector();
       String [] imena = { "Mika", "Pera", "Zika", "Tika", "Maka"};
   
       for (int i=0; i<imena.length;i++)
              prvi.add(imena[i]);
  
       for (int i=0; i<prvi.size(); i++)
           System.out.println((String)prvi.get(i));
   }
}

   
