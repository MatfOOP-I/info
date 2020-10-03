package v12.v01Serijalizacija.Podaci;

import java.io.Serializable;

public class Podatak implements Serializable
{
	private int broj;

	public Podatak(int broj)
	{
		this.broj = broj;
	}

	// Method to compare two Data objects
	public boolean equals( Object obj )
	{
		if (obj instanceof Podatak && ((Podatak) obj).broj == broj)
			return true;
		return false;
	}

	public void setBroj(int broj)
	{
		this.broj = broj;
	}

	public int getBroj()
	{
		return broj;
	}
}
