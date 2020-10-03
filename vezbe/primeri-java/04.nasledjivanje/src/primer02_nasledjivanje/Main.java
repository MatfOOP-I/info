package primer02_nasledjivanje;

public class Main {

	public static void main(String[] args) {
		// Instanciramo nekoliko objekata nase hijerarhije
		Pravougaonik pravougaonik = new Pravougaonik(10, 20, 100, 200);
		Kvadrat kvadrat = new Kvadrat(new Tacka(2, 3), 40);
		Krug krug = new Krug(40);
		Elipsa elipsa = new Elipsa(new Tacka(), 11, 42);
		Trougao trougao = new Trougao(10, 10, 20, 20, 40, 40);
		
		System.out.println(pravougaonik);
		System.out.println(kvadrat);
		System.out.println(krug);
		System.out.println(elipsa);
		
		// Kako mozemo dobiti centar nekog Oblika?
		Tacka centar = krug.getCentar();
		System.out.println("\nKrug se nalazi u tacki " + centar);
		
		// Duzine stranica trougla?
		System.out.println("\nDuzine stranice trougla: AB = " + trougao.getAB() + " BC = " + trougao.getBC()
				+ " CA = " + trougao.getCA());
		
		// Kako mozemo TRANSLIRATI Oblik?
		// Nase klase iz hijerarhije Oblik ne nude tu funkcionalnost,
		// ali mozemo izvrsiti translaciju koristeci klasu Tacka.

		// Ako zelimo da sacuvamo staru tacku PRE TRANSLACIJE ne mozemo sa:
		// Tacka c1 = krug.getCentar();
		// vec moramo da dobijemo KOPIJU tacke sa obzirom na to da joj sledi promena nakon translacije
		Tacka c1 = new Tacka(krug.getCentar());

		krug.getCentar().translate(10, 20);
		Tacka c2 = krug.getCentar();
		System.out.println("\nKrug je tranisliran iz " + c1 + " u " + c2 + " koristeci vektor (10, 20)");
		
		// Kako dobiti rastojanje izmedju centara dva Oblika?
		double dist = krug.getCentar().distance(kvadrat.getCentar());
		System.out.println("\nRastojanje izmedju " + krug + " i " + kvadrat + " je " + dist);
	}

}
