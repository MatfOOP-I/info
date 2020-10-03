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
public class BalansiranoDrvo extends UredjenoDrvo
{
	protected int brojac = 0;

	public BalansiranoDrvo(Uporedivost o)
	{
		super(o);
	}

	public void dodaj(Object o)
	{
		super.dodaj(o);
		if (koren != null)
		{
			koren = balansiraj(koren);
		}
	}

	protected int brojCvorovaPoddrveta(CvorDrveta koren, int smer)
	{
		brojac = 0;
		CvorDrveta poddrvo = null;
		if (koren == null)
			return 0;
		switch (smer)
		{
			case DESNO :
				poddrvo = koren.vratiDesni();
				break;
			case LEVO :
				poddrvo = koren.vratiLevi();
				break;
		}
		if (poddrvo == null)
			return 0;
		prodji(poddrvo, INFIKSNO, new Prolazak()
		{
			public void obradi(Object o)
			{
				brojac++;
			}
		});

		return brojac;
	}

	protected CvorDrveta rotiraj(CvorDrveta koren, int smer)
	{
		CvorDrveta noviKoren = null;
		CvorDrveta siroce = null;
		switch (smer)
		{
			case DESNO :
				noviKoren = koren.vratiLevi();
				koren.postaviLevi(null);
				siroce = noviKoren.vratiDesni();
				noviKoren.postaviDesni(koren);
				break;
			case LEVO :
				noviKoren = koren.vratiDesni();
				koren.postaviDesni(null);
				siroce = noviKoren.vratiLevi();
				noviKoren.postaviLevi(koren);
				break;
		}
		if (noviKoren == null)
			return koren;
		if (siroce != null)
			dodaj(koren, siroce);
		return noviKoren;
	}

	protected CvorDrveta balansiraj(CvorDrveta koren)
	{
		if (koren == null)
			return null;
		int levi = brojCvorovaPoddrveta(koren, LEVO);
		int desni = brojCvorovaPoddrveta(koren, DESNO);
		if (levi > desni)
		{
			while (levi > desni + 1)
			{
				koren = rotiraj(koren, DESNO);
				levi = brojCvorovaPoddrveta(koren, LEVO);
				desni = brojCvorovaPoddrveta(koren, DESNO);
			}
		}
		if (desni > levi)
		{
			while (desni > levi + 1)
			{
				koren = rotiraj(koren, LEVO);
				levi = brojCvorovaPoddrveta(koren, LEVO);
				desni = brojCvorovaPoddrveta(koren, DESNO);
			}
		}
		koren.postaviLevi(balansiraj(koren.vratiLevi()));
		koren.postaviDesni(balansiraj(koren.vratiDesni()));
		return koren;
	}

}