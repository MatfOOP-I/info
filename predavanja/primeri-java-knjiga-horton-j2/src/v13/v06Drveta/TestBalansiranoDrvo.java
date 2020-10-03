/*
 * Created on 2004.4.8
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package v13.v06Drveta;

/**
 * @author Ja
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TestBalansiranoDrvo
{
	public static void main(String args[])
	{
		BalansiranoDrvo t = new BalansiranoDrvo(new Uporedivost()
		{
			public int uporedi(Object a, Object b)
			{
				return ((String) a).compareTo((String) b);
			}
		});
		t.dodaj("A");
		t.dodaj("B");
		t.dodaj("C");
		t.dodaj("D");
		t.dodaj("E");
		t.dodaj("F");
		t.dodaj("G");
		t.dodaj("H");
		t.dodaj("I");
		t.dodaj("J");
		t.dodaj("K");
		t.dodaj("L");
		/*
		t.dodaj("M");
		t.dodaj("N");
		t.dodaj("O");
		t.dodaj("P");
		t.dodaj("Q");
		t.dodaj("R");
		t.dodaj("S");
		t.dodaj("T");
		t.dodaj("U");
		t.dodaj("V");
		t.dodaj("W");
		t.dodaj("X");
		t.dodaj("Y");
		t.dodaj("Z");
		*/
		t.prodji(UredjenoDrvo.PREFIKSNO, new Prolazak()
		{
			public void obradi(Object o)
			{
				System.out.print(o + " ");
			}
		});
		System.out.println();
		t.prodji(UredjenoDrvo.INFIKSNO, new Prolazak()
		{
			public void obradi(Object o)
			{
				System.out.print(o + " ");
			}
		});
		System.out.println();
		t.prodji(UredjenoDrvo.POSTFIKSNO, new Prolazak()
		{
			public void obradi(Object o)
			{
				System.out.print(o + " ");
			}
		});
	}
}
