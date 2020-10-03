package rs.math.oop1.z140500.ispitivanjeZabeleski.z02.geometrija;


public class GeometrijaTest
{
	
	/**
	 * @param args
	 */
	public static void main ( String[] args )
	{
		Tacka a = new Tacka(20, 30, "A");
		
		Tacka b = new Tacka(100, 40, "B");
		
		Duz ab = new Duz("AB", a, b);
		
		Tacka c = new Tacka(80, 120, "C");
		
		Tacka d = new Tacka(160, 150, "D");
		
		Trougao t1 = new Trougao("t1", a, b, c);
		
		Trougao t2 = new Trougao("t1", a, c, d);
		
		Cetvorougao c1 = new Cetvorougao("c1", a, b, c, d);
		
		Prikaz[] niz = { a, b, c1, c, t1, d, t2, ab };
		for (Prikaz prika : niz)
		{
			prika.prikaziSe();
			System.out.println();
		}
		Mera[] nizM = { c1, t1,  t2 };		
		for (Mera m : nizM)
		{
			System.out.println( " povrsina: " + m.povrsina());
			System.out.println( " obim: " + m.obim());
			System.out.println();
		}
	}
	
}
