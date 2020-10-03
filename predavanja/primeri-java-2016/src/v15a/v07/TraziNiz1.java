package v15a.v07;

public class TraziNiz1{

   public static void main(String args[]) {
      
      
       int i, n,x;
       int [] niz = {7,3,6,9,1,2,8,3,2};
   
       x=Integer.parseInt(args[0]);

       n=niz.length;
       
       i=0;
       while((i<n)&&niz[i]!=x) i++;
       if(i==n)System.out.println("NIJE NADJEN!");
          else  System.out.println("NADEN na poziciji: "+i);
   }

  
        
}

   
