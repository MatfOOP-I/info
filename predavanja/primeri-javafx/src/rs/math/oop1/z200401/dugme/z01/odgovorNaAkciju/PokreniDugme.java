package rs.math.oop1.z200401.dugme.z01.odgovorNaAkciju;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PokreniDugme extends Application
{
	
	private Button ispisi = new Button();
	private Pane poMeniSePise = new Pane();
	
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
		
		primarnaScena.setTitle( "Pokreni dugme" );
		Group koren = new Group();
		Scene scena = new Scene( koren, 600, 400 );
		ispisi.setLayoutX( 250 );
		ispisi.setLayoutY( 20 );
		ispisi.setText( "Prikaz poruka" );
		ispisi.setOnAction( new EventHandler<ActionEvent>()
		{
			public void handle( ActionEvent event )
			{
				ispisiPoruku( poMeniSePise );
			}
		} );
		koren.getChildren().add( ispisi );
		poMeniSePise.setLayoutX( 0 );
		poMeniSePise.setLayoutY( 120 );
		poMeniSePise.setPrefSize( 600, 280 );
		koren.getChildren().add( poMeniSePise );
		primarnaScena.setScene( scena );
		primarnaScena.show();
		
	}
	
	protected void ispisiPoruku( Pane panel )
	{
		panel.getChildren().clear();
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i < 25; i++)
		{
			int x = rand.nextInt((int) panel.getWidth());
			int y = rand.nextInt((int) panel.getHeight());
			int red = rand.nextInt(255);
			int green = rand.nextInt(255);
			int blue = rand.nextInt(255);
			Text text = new Text(x, y, "Vlado je bio ovde!!!");
			int rot = rand.nextInt(360);
			text.setFill(Color.rgb(red, green, blue, .99));
			text.setRotate(rot);
			panel.getChildren().add(text);
		}		
	}
}
