package rs.math.oop1.z110600.generickiMetod.z01.par;


public class PairTest
{
	public static void main( String[] args )
	{
		OrderedPair<Integer, String> p1 =
				new OrderedPair<>(1, "apple");
		OrderedPair<Integer, String> p2 =
				new OrderedPair<>(2, "banana");
		int uredjenje = p1.compareTo(p2);
		prikazi(p1, p2, uredjenje);
		p2 = new OrderedPair<>(-1, "apple");
		uredjenje = p1.compareTo(p2);
		prikazi(p1, p2, uredjenje);
		p2 = new OrderedPair<>(1, "banana");
		prikazi(p1, p2, p1.compareTo(p2));
	}

	private static void prikazi(
			OrderedPair<Integer, String> p1,
			OrderedPair<Integer, String> p2, int uredjenje) {
		if (uredjenje > 0)
			System.out.println(p1 + " je vece od " + p2 + ".");
		else if (uredjenje < 0)
			System.out.println(p1 + " je manje od " + p2 + ".");
		else
			System.out.println(p1 + " i " + p2 + "su `isti`.");
	}

}
