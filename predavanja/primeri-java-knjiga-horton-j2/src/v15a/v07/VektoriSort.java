package v15a.v07;
import java.util.*;

public class VektoriSort {

   public static void main(String args[]) {
      
       Vector  prvi = new Vector();
       String [] imena = { "Mika", "Pera", "Zika", "Tika", "Maka"};
   
       for (int i=0; i<imena.length;i++)
              prvi.add(imena[i]);

//  Sortiranje

       Collections.sort(prvi);
  
       for (int i=0; i<prvi.size(); i++)
           System.out.println((String)prvi.get(i));
   }
}

   
