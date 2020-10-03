package v08.v01FormatizovaniUlaz;

public class TestFormatizovaniUlaz
{
	public static void main(String[] args)
	{
		FormatizovaniUlaz kb = new FormatizovaniUlaz();
		for (int i = 0; i < 5; i++)
		{
			try
			{
				System.out.print("Unesi ceo broj: ");
				System.out.println("Procitan je ceo broj: " + kb.citajInt());
				System.out.print("Unesi double broj: ");
				System.out.println("Procitan je double broj: " + kb.citajDouble());
				System.out.print("Unesi string: ");
				System.out.println("Procitan je string: " + kb.citajString());
			}
			catch (NekorektanUnosException e)
			{
				System.out.println(
					"Podignut je izuzetak tipa NekorektanUnosException.\n"
						+ e.getMessage());
			}
		}
	}
}
