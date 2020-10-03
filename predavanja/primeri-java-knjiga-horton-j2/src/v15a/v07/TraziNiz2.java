package v15a.v07;

public class TraziNiz2{

   public static void main(String args[]) {
      
      
       int i, n,x;
       int [] niz = new int[20]; 
       
       for(i=0; i<15; i++) 
            {
               niz[i]=(int)(10*Math.random());
               System.out.print(niz[i]+",  ");
          
            }
       System.out.println();
       x=Integer.parseInt(args[0]);
       n=15;
       niz[n]=x;
      
       i=0;
       while(niz[i]!=x) i++;
       if(i==n)System.out.println("NIJE NADJEN!");
          else  System.out.println("NADEN na poziciji: "+i);
   }

  
        
}

   
