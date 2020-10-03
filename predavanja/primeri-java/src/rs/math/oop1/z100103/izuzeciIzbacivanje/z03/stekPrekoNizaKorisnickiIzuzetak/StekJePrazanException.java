package rs.math.oop1.z100103.izuzeciIzbacivanje.z03.stekPrekoNizaKorisnickiIzuzetak;

public class StekJePrazanException extends Exception
{	
	@Override
	public String toString()
	{
		String s = super.toString();
		return "Izuzetak: stek je prazan. " + s;
	}
}
