package v15a.v07;

public class SortNiz1{

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
       sort1(niz,n);
       for(i=0;i<n;i++)System.out.print(niz[i]+"   ");
       
   }

  static void sort1(int a[], int n)
    {
      int i,j,pom;
      for(i=0;i<n-1; i++)
        for(j=i+1; j<n; j++)
          if(a[j]<a[i])
            {
              pom =a[i];
              a[i]=a[j];
              a[j]=pom;
             }
     }      
        
}

   
