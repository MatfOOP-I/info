package v15a.v07;

public class SortNiz5{

   public static void main(String args[]) {
      
      
       int i, n;
       int [] niz = new int[20]; 
       
       for(i=0; i<15; i++) 
            {
               niz[i]=(int)(10*Math.random());
               System.out.print(niz[i]+"   ");
          
            }
       n=15; 
       System.out.println();
       System.out.println("Sortirani niz");
       sort5(niz,n);
       for(i=0;i<n;i++)System.out.print(niz[i]+"   ");
       
   }

  static void sort5(int a[], int n)
    {
      int i,j,pom;
      pom=a[0];
      j=0;
      for(i=1;i<n; i++)
        if (a[i]<pom){
           pom=a[i];
           j=i;
        }
      a[j]=a[0];
      a[0]=pom;
     
      for(i=2;i< n; i++)
       {
         pom = a[i];
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
   
