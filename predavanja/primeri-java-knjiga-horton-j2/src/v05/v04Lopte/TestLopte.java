package v05.v04Lopte;

public class TestLopte
{
	public static void main(String[] args)
	{
		System.out.println("Broj objekata = " + Lopta.getBroj());

		Lopta lopta = new Lopta(4.0, 0.0, 0.0, 0.0); // Create a sphere
		System.out.println("Broj objekata = " + lopta.getBroj());

		Lopta globus = new Lopta(12., 1.0, 1.0, 1.0); // Create a sphere
		System.out.println("Broj objekata = " + Lopta.getBroj());

		Lopta bilijarLopta8 = new Lopta(10.0, 10.0, 0.0);
		Lopta neparna = new Lopta();
		System.out.println("Broj objekata = " + Lopta.getBroj());

		// Output the volume of each sphere
		System.out.println("zapremina za lopta = " + lopta.zapremina());
		System.out.println("zapremina za globus = " + globus.zapremina());
		System.out.println(
			"zapremina za bilijarLopta8 = " + bilijarLopta8.zapremina());
		System.out.println("zapremina za neparna = " + neparna.zapremina());
	}
}
