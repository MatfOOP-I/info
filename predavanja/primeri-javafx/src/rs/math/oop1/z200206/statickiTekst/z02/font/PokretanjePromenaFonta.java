package rs.math.oop1.z200206.statickiTekst.z02.font;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Changing Text Fonts
 * 
 * @author cdea
 */
public class PokretanjePromenaFonta extends Application
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
	public void start( Stage primaryStage )
	{
		primaryStage.setTitle( "Tekst i fontovi" );
		Group koren = new Group();
		Scene scena = new Scene( koren, 550, 250, Color.WHITE );
		// Serif with drop shadow
		Text poruka = new Text( 50, 50, "JavaFX 2.0: Intro. by Example" );
		Font serif = Font.font( "Serif", 30 );
		poruka.setFont( serif );
		poruka.setFill( Color.RED );
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX( 2.0f );
		dropShadow.setOffsetY( 2.0f );
		dropShadow.setColor( Color.rgb( 50, 50, 50, .588 ) );
		poruka.setEffect( dropShadow );
		koren.getChildren().add( poruka );
		// SanSerif
		Text poruka2 = new Text( 50, 100, "JavaFX 2.0: Intro. by Example" );
		Font sanSerif = Font.font( "SanSerif", 30 );
		poruka2.setFont( sanSerif );
		poruka2.setFill( Color.BLUE );
		koren.getChildren().add( poruka2 );
		// Dialog
		Text poruka3 = new Text( 50, 150, "JavaFX 2.0: Intro. by Example" );
		Font dialogFont = Font.font( "Dialog", 30 );
		poruka3.setFont( dialogFont );
		poruka3.setFill( Color.rgb( 0, 255, 0 ) );
		koren.getChildren().add( poruka3 );
		// Monospaced
		Text poruka4 = new Text( 50, 200, "JavaFX 2.0: Intro. by Example" );
		Font monoFont = Font.font( "Monospaced", 30 );
		poruka4.setFont( monoFont );
		poruka4.setFill( Color.BLACK );
		koren.getChildren().add( poruka4 );
		Reflection refl = new Reflection();
		refl.setFraction( 0.8f );
		poruka4.setEffect( refl );
		primaryStage.setScene( scena );
		primaryStage.show();
	}
}