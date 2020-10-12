package rs.math.oop1.z070401.definicjeMetoda.z08.sistemJednacina;

import java.util.Scanner;

public class KvadratnaMatrica
{
  private int dim;
	private double[][]mat;
	
	public KvadratnaMatrica(int n)
	{
		dim = n;
		mat = new double[dim][dim];
		for(int i=0; i<dim; i++)
			for(int j=0; j<dim; j++)
				mat[i][j]=0;
	}
	
	public void ucitaj( Scanner ulaz, int n )
	{
		dim = n;
		mat = new double[dim][dim];
		System.out.println( "Elementi matrice sistema su" );
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				mat[i][j] = ulaz.nextDouble();
	}
	
	public void prikazi()
	{
		System.out.println( "Elementi kvadratne matrice su" );
		for (int i = 0; i < mat.length; i++)
		{
			for (int j = 0; j < mat[i].length; j++)
				System.out.printf( "%15.4f", mat[i][j] );
			System.out.println();
		}
	}
	
	
}
