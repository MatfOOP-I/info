package v15a.v07;

public class SortNiz4{

   public static void main(String args[]) {
      
      
       int i, n;
       int [] niz = new int[20]; 
       
       for(i=1; i<=15; i++) 
            {
               niz[i]=(int)(10*Math.random());
               System.out.print(niz[i]+"   ");
          
            }
       n=15; 
       System.out.println();
       System.out.println("Sortirani niz");
       sort4(niz,n);
       for(i=1;i<=n;i++)System.out.print(niz[i]+"   ");
       
   }

  static void sort4(int a[], int n)
    {
      int i,j,pom;
      for(i=2;i<=n; i++)
       {
         pom = a[i];
         a[0]=pom;
         j=i;
         while (pom<a[j-1])
          {  
             a[j]=a[j-1];
             j--;
          }
        a[j]=pom;       
     }     
   }
}
   
