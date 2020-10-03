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
public class GlobalniResurs_en extends ListResourceBundle
{
	public static final String ZDRAVO = "zdravo";
	public static final String ZBOGOM = "zbogom";
	
	private static final Object[][] sadrzaj =
	{
		{GlobalniResurs.ZDRAVO, "Hello" },
		{GlobalniResurs.ZBOGOM, "Goodbye" }
	};

	public Object[][] getContents()
	{
		return sadrzaj;
	}

}
