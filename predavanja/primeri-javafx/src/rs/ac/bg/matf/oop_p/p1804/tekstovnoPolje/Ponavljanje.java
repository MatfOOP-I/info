package rs.ac.bg.matf.oop_p.p1804.tekstovnoPolje;


import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

public class Ponavljanje extends Application
{
	private Label ponavljanjeOpis;
	private TextField ponavljanjeVrednost;
	private Label porukaOpis;
	private TextField porukaVrednost;
	private Button ispisi;
	private Pane poMeniSePise;
	
	/**
	 * @param args
	 *          the command line arguments
	 */
	public static void main( String[] args )
	{
		Application.launch( args );
	}
	
	@Override
	public void start( Stage primarnaScena ) throws Exception
	{
		
		Scene scena = SceneBuilder.create().width( 600 ).height( 400 )
				.root( kreirajScenu() ).build();
		primarnaScena.setTitle( "Ponavljanje" );
		primarnaScena.setScene( scena );
		primarnaScena.show();
	}
	
	private Parent kreirajScenu()
	{
		Pane rez = PaneBuilder.create().build();
		porukaOpis = kreirajOznakuPorukaOpis();
		rez.getChildren().add( porukaOpis );
		porukaVrednost = kreirajTekstovnoPoljePorukaVrednost();
		rez.getChildren().add( porukaVrednost );
		ponavljanjeOpis = kreirajOznakuPonavljanjeOpis();
		rez.getChildren().add( ponavljanjeOpis );
		ponavljanjeVrednost = kreirajTekstovnoPoljePonavljanjeVrednost();
		rez.getChildren().add( ponavljanjeVrednost );
		ispisi = kreirajDugmeIspisi();
		rez.getChildren().add( ispisi );
		poMeniSePise = kreirajPanelPoMeniSePise();
		rez.getChildren().add( poMeniSePise );
		return rez;
	}
	
	private Label kreirajOznakuPorukaOpis()
	{
		Label oznaka = LabelBuilder.create()
				 .layoutX( 30 )
				 .layoutY( 25 )
				 .text( "Unesi poruku: " )
				 .font( new Font( "Times New Roman", 13 ) )
				 .build(); 
		return oznaka;
	}

	private TextField kreirajTekstovnoPoljePorukaVrednost()
	{
		TextField polje = TextFieldBuilder.create()
				.layoutX( 140 )
				.layoutY( 20 )
				.prefWidth( 160 )
				.text( "Java FX 2.0" )
				.focusTraversable( false )
				.build();
		return polje;
	}


	private Label kreirajOznakuPonavljanjeOpis()
	{
		Label oznaka = LabelBuilder.create()
				 .layoutX( 320 )
				 .layoutY( 25 )
				 .text( "Broj poruka: " )
				 .build(); 
		return oznaka;
	}

	private TextField kreirajTekstovnoPoljePonavljanjeVrednost()
	{
		TextField polje = TextFieldBuilder.create()
				.layoutX( 430 )
				.layoutY( 20 )
				.prefWidth( 60 )
				.text( "40" )
				.focusTraversable( false )
				.build();
		return polje;
	}

	private Button kreirajDugmeIspisi()
	{
		Button dugme = ButtonBuilder.create()
				.layoutX( 530 )
				.layoutY( 20 )
				.text( "Ispisi" )
				.onAction( new EventHandler<ActionEvent>()
				{
					public void handle( ActionEvent event )
					{
						int bp = Integer.parseInt( ponavljanjeVrednost.getText() );
						ispisiPoruku( poMeniSePise, porukaVrednost.getText(), bp );
						String imeFonta =  porukaOpis.getFont().getFamily();
						if( imeFonta.equals( "Times New Roman") )
							porukaOpis.setFont( new Font( "Arial", 13 ) );
						else
							porukaOpis.setFont( new Font( "Times New Roman", 13 ) );							
					}
				} )
				.build();
		return dugme;
	}
	
	private Pane kreirajPanelPoMeniSePise()
	{
		Pane panel = PaneBuilder.create().layoutX( 0 ).layoutY( 120 )
				.prefHeight( 280 ).prefWidth( 600 ).build();
		return panel;
	}
	
	protected void ispisiPoruku( Pane panel, String poruka, int brojPonavljanja )
	{
		panel.getChildren().clear();
		Random rand = new Random( System.currentTimeMillis() );
		for (int i = 0; i < brojPonavljanja; i++)
		{
			int x = rand.nextInt( (int) panel.getWidth() );
			int y = rand.nextInt( (int) panel.getHeight() );
			int red = rand.nextInt( 255 );
			int green = rand.nextInt( 255 );
			int blue = rand.nextInt( 255 );
			Text text = new Text( x, y, poruka );
			int rot = rand.nextInt( 360 );
			text.setFill( Color.rgb( red, green, blue, .99 ) );
			text.setRotate( rot );
			panel.getChildren().add( text );
		}
	}
}
