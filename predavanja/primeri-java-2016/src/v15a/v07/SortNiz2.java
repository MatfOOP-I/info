package v15a.v07;

public class SortNiz2{

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
       sort2(niz,n);
       for(i=0;i<n;i++)System.out.print(niz[i]+"   ");
       
   }

  static void sort2(int a[], int n)
    {
      int i,j,pom, k;
      for(i=0;i<n-1; i++){
        k=i;
        pom = a[i];
        for(j=i+1; j<n; j++)
          if(a[j]<pom)
            {
              pom =a[j];
              k=j;
             }
         a[k]=a[i];
         a[i]=pom;
      }      
   }     
}

   
