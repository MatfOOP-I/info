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
public class TestUredjenoDrvo
{
	public static void main(String args[])
	{
		UredjenoDrvo t = new UredjenoDrvo(new Uporedivost()
		{
			public int uporedi(Object a, Object b)
			{
				return ((String) a).compareTo((String) b);
			}
		});

		t.dodaj("Chicago");
		t.dodaj("Los Angeles");
		t.dodaj("Atlanta");
		t.dodaj("Boston");
		t.dodaj("Houston");
		t.dodaj("Indianapolis");
		t.prodji(new Prolazak()
		{
			public void obradi(Object o)
			{				
				System.out.println(o);
			}
		});
		System.out.println();
		System.out.println("Trazimo Houston.");
		System.out.println("TRAZI=" + t.trazi("Houston"));
		System.out.println();
		System.out.println("Trazimo Miami.");
		System.out.println("TRAZI=" + t.trazi("Miami"));

	}
}
