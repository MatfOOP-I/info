package zivotinjskaFarma;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
    	/*
    	System.out.println("-----------PRAG----------");
    	Scanner sc = new Scanner(System.in);
    	System.out.println("ime osobe:");
    	String ime = sc.next();
    	System.out.println("naredba:");
    	String naredba = sc.next();
    	Direktiva d = new Direktiva(ime, naredba);
    	System.out.println(d);
    	System.out.println("-------------------------");
    	sc.close();
        */
    	Scanner sc = new Scanner(System.in);
		Svinja napoleon = new Svinja("Napoleon"); 

		System.out.println("Broj parola za Moli:");
		int br_parola = sc.nextInt(); 
		String[] parole = new String[br_parola]; 
		for(int i = 0; i < br_parola; i++) 
			parole[i] = sc.next();
		Ovca moli = new Ovca("Moli", parole); 
		
		System.out.println("Broj parola za Poli:");
		br_parola = sc.nextInt();
		parole = new String[br_parola]; 
		for(int i = 0; i < br_parola; i++) 
			parole[i] = sc.next();
		Ovca poli = new Ovca("Poli", parole); 
		sc.close();
		
		System.out.println(napoleon); 

		moli.uglas(); 
		poli.uglas();

		System.out.println("Poli menja parolu:");
		poli.naredi(new Direktiva("Poli", "CETIRI NOGE DOBRE, DVE NOGE BOLJE!")); 
		System.out.println(poli);

		System.out.println("Napoleon menja parolu:");
		napoleon.setParola("Sve su zivotinje jednake, ali su neke jednakije od drugih"); 
		System.out.println(napoleon);

    }
}

