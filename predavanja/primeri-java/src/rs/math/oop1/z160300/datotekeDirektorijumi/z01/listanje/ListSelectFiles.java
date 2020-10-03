package rs.math.oop1.z160300.datotekeDirektorijumi.z01.listanje;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class ListSelectFiles
{
	public static void main( String[] args ) throws IOException
	{
		
		{
			final String[] files = new File( "fpij" )
					.list( new java.io.FilenameFilter()
					{
						public boolean accept( final File dir, final String ime )
						{
							return ime.endsWith( ".java" );
						}
					} );
					
			System.out.println( files );
			
		}
		
		Files
				.newDirectoryStream( Paths.get( "fpij" ),
						path -> path.toString().endsWith( ".java" ) )
				.forEach( System.out::println );
	}
}
