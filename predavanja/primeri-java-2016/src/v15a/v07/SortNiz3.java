package v15a.v07;

public class SortNiz3{

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
       sort3(niz,n);
       for(i=0;i<n;i++)System.out.print(niz[i]+"   ");
       
   }

  static void sort3(int a[], int n)
    {
      int i,j,pom;
      for(i=1;i<n-1; i++)
    
        for(j=n-1; j>=i; j--)
          if(a[j]<a[j-1])
            {
              pom =a[j-1];
              a[j-1]=a[j];
              a[j]=pom;
             }
              
   }     
}

   
