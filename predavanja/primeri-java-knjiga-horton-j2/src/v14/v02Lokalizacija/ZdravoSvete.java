/*
 * Created on 2004.4.6
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package v14.v02Lokalizacija;

import java.util.*;

/**
 * @author Ja
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ZdravoSvete
{

	public static void main(String[] argumenti)
	{
		ResourceBundle resurs = ResourceBundle.getBundle("GlobalniResurs");
		String poruka;
		if( argumenti.length > 0 )
			poruka = resurs.getString( "ZBOGOM" );
		else
			poruka = resurs.getString( "ZDRAVO" );
		System.out.println( poruka );
	}
}
