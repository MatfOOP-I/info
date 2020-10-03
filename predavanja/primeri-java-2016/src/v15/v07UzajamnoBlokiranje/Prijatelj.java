/*
 * Created on 2004.4.8
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package v15.v07UzajamnoBlokiranje;

/**
 * @author Ja
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Prijatelj
{
  private Prijatelj drug;
  private String ime;
  
  public Prijatelj( String ime)
  {
  	this.ime = ime;
  }
  
  public synchronized void zagrli()
  {
		System.out.println( "Gde si, " + drug.ime + " sta radis?" );
		try
		{
			Thread.sleep( 200 );
		}
		catch( InterruptedException e )
		{
			e.printStackTrace(); 
		}
  	System.out.println( Thread.currentThread().getName() +
  		" u metodi " + ime + ".zagrli() pokusava da izvrsi " +
  		drug.ime + ".uzvratiZagrljaj()" );
  	drug.uzvratiZagrljaj();
  }

	public synchronized void uzvratiZagrljaj()
	{
		System.out.println( "Evo tu sam, " + drug.ime + " sta ima kod tebe novo?" );
	}
	
	public void sprijateljiSe( Prijatelj drug )
	{
		this.drug = drug;
	}
}
