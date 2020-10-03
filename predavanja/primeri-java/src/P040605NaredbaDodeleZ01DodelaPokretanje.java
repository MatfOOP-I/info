//Пример илуструје различите начине извршења наредбе доделе.

class PokretanjeNaredbaDodele {

   public static void main(String[] args) {
       int m, n, k;
       int a=2, b=3, s=5, s1=1; //dodele pri deklaraciji

       m = n = k = 5;
       /*k dobija vrednost 5,
        kako je i vrednost izraza k=5 takodje 5,
        n dobija vrednost 5,
        a po tom principu i m dobija vrednost 5. */
       System.out.println(k);
       System.out.println(m);
       System.out.println(n);

       s+=s1+=a*b; // s1 dobija vrednost 7, jer se na 1 dodaje 6, a s vrednost 12, jer se na 5 dodaje 7.
       System.out.println(s1);
       System.out.println(s);
   }

}
