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
public class UredjenoDrvo
{
	protected CvorDrveta koren;
	protected Uporedivost c;

	public final static int INFIKSNO = 1;
	public final static int PREFIKSNO = 2;
	public final static int POSTFIKSNO = 3;

	protected final static int DESNO = 1;
	protected final static int LEVO = 2;

	public UredjenoDrvo(Uporedivost o)
	{
		c = o;
	}

	public void dodaj(Object o)
	{
		dodaj(koren, new CvorDrveta(o));
	}

	protected void dodaj(CvorDrveta koren, CvorDrveta noviCvor)
	{
		if (koren == null)
		{
			this.koren = noviCvor;
			return;
		}
		int val = c.uporedi(noviCvor.vratiPodatak(), koren.vratiPodatak());
		if (val == 0)
		{
			koren.postaviPodatak(noviCvor.vratiPodatak());
			return;
		}
		else if (val < 0)
		{
			if (koren.vratiLevi() == null)
				koren.postaviLevi(noviCvor);
			else
				dodaj(koren.vratiLevi(), noviCvor);
		}
		else if (val > 0)
		{
			if (koren.vratiDesni() == null)
				koren.postaviDesni(noviCvor);
			else
				dodaj(koren.vratiDesni(), noviCvor);
		}
	}

	public Object trazi(Object o)
	{
		return trazi(koren, o);
	}
	
	protected Object trazi(CvorDrveta koren, Object o)
	{
		if (koren == null)
		{
			return null;
		}
		int val = c.uporedi(o, koren.vratiPodatak());
		if (val == 0)
		{
			return koren.vratiPodatak();
		}
		else if (val < 0)
		{
			return trazi(koren.vratiLevi(), o);
		}
		else if (val > 0)
		{
			return trazi(koren.vratiDesni(), o);
		}
		return null;
	}

	public void prodji(Prolazak prolaz)
	{
		prodji(INFIKSNO, prolaz);
	}

	public void prodji(int type, Prolazak prolaz)
	{
		prodji(koren, type, prolaz);
	}

	protected void prodji(CvorDrveta root, int type, Prolazak prolaz)
	{
		CvorDrveta tmp;

		if (type == PREFIKSNO)
			prolaz.obradi(root.vratiPodatak());
		if ((tmp = root.vratiLevi()) != null)
			prodji(tmp, type, prolaz);
		if (type == INFIKSNO)
			prolaz.obradi(root.vratiPodatak());
		if ((tmp = root.vratiDesni()) != null)
			prodji(tmp, type, prolaz);
		if (type == POSTFIKSNO)
			prolaz.obradi(root.vratiPodatak());
	}
	
	public void Prikazi()
	{
		prodji(new Prolazak()
		{
			public void obradi(Object o)
			{				
				System.out.println( ((CvorDrveta)o).vratiPodatak() );
			}
		});
	}

}
