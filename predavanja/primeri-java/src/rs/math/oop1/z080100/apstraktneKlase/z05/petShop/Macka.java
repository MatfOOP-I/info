package rs.math.oop1.z080100.apstraktneKlase.z05.petShop;

public class Macka extends Sisar
{
	
	public Macka( String ime, String klasifikacijaLine,
			double ocekivanaStarostGod, double trudnocaTrajeGod, double tezinaBebeKg )
	{
		super( ime, klasifikacijaLine, ocekivanaStarostGod, trudnocaTrajeGod,
				tezinaBebeKg );
	}
	
	@Override
	public int brojNogu()
	{
		return 4;
	}
	
	@Override
	public int naciniKretanja()
	{
		return NacinKretanja.HODANJE | NacinKretanja.SKAKANJE | NacinKretanja.TRCANJE
				| NacinKretanja.PLIVANJE;
	}
	
}
