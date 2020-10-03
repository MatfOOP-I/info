package rs.math.oop1.z100103.izuzeciIzbacivanje.z05.matrice;

public class NekompatibilneDimenzijeMatriceException extends Exception
{
	private int dim1;
	private int dim2;
	
	public NekompatibilneDimenzijeMatriceException(int dim1, int dim2)
	{
		this.dim1 = dim1;
		this.dim2 = dim2;
	}
	
	@Override
	public String toString()
	{
		String s = super.toString();
		return "Izuzetak nekompatiblinih dimenzija matrice (" + dim1 + "," 
				+ dim2 + ")\n" + s;
	}
}
