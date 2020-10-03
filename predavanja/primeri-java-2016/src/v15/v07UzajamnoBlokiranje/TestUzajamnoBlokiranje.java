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
public class TestUzajamnoBlokiranje
{

	public static void main(String[] args)
	{
		final Prijatelj pera = new Prijatelj( "Pera" );
		final Prijatelj mika = new Prijatelj( "Mika" );
		pera.sprijateljiSe( mika );
		mika.sprijateljiSe( pera );
		Thread t1 = 
		new Thread( new Runnable()
		{
			public void run() 
			{
				mika.zagrli();
			}
		},	"Nit broj 1" );
		t1.start();
//		new Thread( new Runnable ()
//		{
//			public void run() 
//			{
//				pera.zagrli();
//			}
//		},	"Nit broj 2" ).start();
		
	}
	
}
