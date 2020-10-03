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
public class CvorDrveta
{
	CvorDrveta levi;
	CvorDrveta desni;
	Object podatak;

	public CvorDrveta(Object o)
	{
		levi = desni = null;
		podatak = o;
	}

	public Object vratiPodatak()
	{
		return podatak;
	}

	public CvorDrveta vratiLevi()
	{
		return levi;
	}

	public CvorDrveta vratiDesni()
	{
		return desni;
	}

	public void postaviPodatak(Object o)
	{
		podatak = o;
	}

	public void postaviLevi(CvorDrveta l)
	{
		levi = l;
	}

	public void postaviDesni(CvorDrveta r)
	{
		desni = r;
	}

	public String toString()
	{
		return "Cvor " + podatak;
	}

}