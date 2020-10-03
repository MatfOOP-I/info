package rs.math.oop1.z200206.statickiTekst.z01.pozicijaBoja;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * @author cdea
 */
public class PokretanjeSlucajanTekst extends Application
{
	/**
	 * @param args
	 *          the command line arguments
	 */
	public static void main( String[] args )
	{
		Application.launch( args );
	}
	
	@Override
	public void start( Stage primarnaScena )
	{
		primarnaScena.setTitle( "Ispis teksta" );
		Group koren = new Group();
		Scene scena = new Scene( koren, 300, 250, Color.WHITE );
		Random slucajni = new Random( System.currentTimeMillis() );
		for (int i = 0; i < 15; i++)
		{
			int x = slucajni.nextInt( (int) scena.getWidth() );
			int y = slucajni.nextInt( (int) scena.getHeight() );
			int red = slucajni.nextInt( 255 );
			int green = slucajni.nextInt( 255 );
			int blue = slucajni.nextInt( 255 );
			Text poruka = new Text( x, y, "JavaFX tekst" );
			int rotacija = slucajni.nextInt( 360 );
			poruka.setFill( Color.rgb( red, green, blue, .99 ) );
			poruka.setRotate( rotacija );
			koren.getChildren().add( poruka );
		}
		primarnaScena.setScene( scena );
		primarnaScena.show();
	}
}