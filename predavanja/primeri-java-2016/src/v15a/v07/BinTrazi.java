package v15a.v07;

public class BinTrazi{

   public static void main(String args[]) {
      
      
       int i, n,x;
       int [] niz = new int[20]; 
       
       for(i=0; i<15; i++) 
            {
               niz[i]=i+1;
               System.out.print(niz[i]+",  ");
          
            }
       System.out.println();
       x=Integer.parseInt(args[0]);
       n=15;
       niz[n]=x;
      
       
       if(bin(x,niz,n)==-1)System.out.println("NIJE NADJEN!");
          else  System.out.println("NADEN na poziciji: "+bin(x,niz,n));
   }

  static int bin(int x, int a[], int n)
    { int l,d,s;
      l=0;
      d= n-1;
      while (l<=d)
        { 
          s=(l+d)/2;
          if(a[s]<x) l=s+1;
          else if(a[s]>x) d=s-1;
          else return s;
        }
      return -1;
     }
        
}

   
