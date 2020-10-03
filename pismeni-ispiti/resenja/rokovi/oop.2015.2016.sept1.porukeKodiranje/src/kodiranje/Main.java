package kodiranje;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private static Map<String, Integer> mBitovi = new HashMap<>();
	private static Map<String, Integer> cBitovi = new HashMap<>();
	private static Map<Integer, List<Integer>> cBitoviFormule = new HashMap<>();
	private static List<String> poruke;
	
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox(5);
			Scene scene = new Scene(root,480,280);
			
			createGUI(root);

			primaryStage.setTitle("Kodiranje binarnih poruka");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createGUI(VBox root) {
		
		TextArea porukeTA = new TextArea();
		porukeTA.setEditable(false);
		porukeTA.setMinHeight(240);
		
		Button tablicaBtn = new Button("Ucitaj i prikazi tablicu");
		Button formuleBtn = new Button("Kako se kodira?");
		Button porukeBtn = new Button("Ucitaj poruke i prikazi kontrolne bitove");
		HBox dugmadPane = new HBox(5);
		dugmadPane.setAlignment(Pos.CENTER);
		dugmadPane.getChildren().addAll(tablicaBtn, formuleBtn, porukeBtn);
		
		obradiTablicu(tablicaBtn, porukeTA);
		obradiFormule(formuleBtn, porukeTA);
		obradiPoruke(porukeBtn, porukeTA);
				
		root.setPadding(new Insets(10));
		root.getChildren().addAll(porukeTA, dugmadPane);
	}

	/***  DEO ZA PRAG  ***/
	private void obradiTablicu(Button tablicaBtn, TextArea porukeTA) {
		
		tablicaBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				try {
					List<String> linije = Files.readAllLines(Paths.get("tablica.txt"));
					if(linije.isEmpty())
						porukeTA.appendText("Nema tablice u datoteci!");
					for(String linija : linije) {
						String[] delovi1 = linija.split(", ");
						String bit = delovi1[0];
						String binarniKod = delovi1[1];
						
						if(bit.charAt(0) == 'm') {
							porukeTA.appendText(binarniKod + "\t\t" + bit + "\n");
							mBitovi.put(binarniKod, bit.charAt(1)-'0');  // van praga
						}
						else {
							porukeTA.appendText(binarniKod + "  " + bit + "\n");
							cBitovi.put(binarniKod, bit.charAt(1)-'0'); // van praga
						}
					}
				} 
				catch(IOException e) {
					System.err.println("Neuspelo ucitavanje tablice!");
					System.exit(1);
				}
			}
		});
	}
	/***  KRAJ DELA ZA PRAG  ***/	
	
	private void obradiFormule(Button formuleBtn, TextArea porukeTA) {
		
		formuleBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
			
				// prave se formule za racunanje c-bitova (popunjava se mapa cBitoviFormule)
				
				// za svaki c-bit
				for(int cRbr = 1; cRbr <= 4; cRbr++) {
					// racunamo mesto jedinice u odgovarajucem binarnom kodu
					int pozJedinice = 4-cRbr;
					
					// izdvajamo sve kljuceve (binarne kodove) iz mape mBitovi
					Set<String> kodoviZaM = mBitovi.keySet();
					// i medju njima one koji imaju jedinicu na mestu pozJedinice
					List<Integer> cFormula = new ArrayList<>();
					for(String kodZaM : kodoviZaM) {
						if(kodZaM.charAt(pozJedinice) == '1') 
							// za takav binarni kod se redni broj odgovarajuceg m-bita dodaje u listu cFormula
							cFormula.add(mBitovi.get(kodZaM));
					}
					// sortira se lista cFormula
					Collections.sort(cFormula);
					// popunjava se mapa sa kombinacijom m-bitova za racunanje c-bitova
					cBitoviFormule.put(cRbr, cFormula);
				}
				
				porukeTA.appendText("\n");
				// ispis u TA
				for(int cRbr = 1; cRbr <= 4; cRbr++) {
					porukeTA.appendText("c" + cRbr + " = ");
					List<Integer> mBitovi = cBitoviFormule.get(cRbr);
					Iterator<Integer> iter = mBitovi.iterator();
					while(iter.hasNext()) {
						porukeTA.appendText("m" + iter.next() + "");
						if(iter.hasNext())
							porukeTA.appendText(" + ");
					}
					porukeTA.appendText("\n");
				}
			}
		});
	}

	private void obradiPoruke(Button porukeBtn, TextArea porukeTA) {
		
		porukeBtn.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				
				try {
					poruke = Files.readAllLines(Paths.get("poruke.txt"));
					if(poruke.isEmpty())
						porukeTA.appendText("Nema poruka u datoteci!");
				}
				catch(IOException e) {
					System.err.println("Neuspelo ucitavanje poruka!");
					System.exit(1);
				}
				
				porukeTA.appendText("\nm8m7m6m5m4m3m2m1 : c4c3c2c1\n");
				porukeTA.appendText("----------------------------------------\n");
				for(String m : poruke) {
					String cBitovi = "";
					// odredjujemo kontrolne bitove (jedan po jedan), na osnovu mape cBitoviFormule
					for(int cRbr = 4; cRbr >= 1; cRbr--) {
						List<Integer> mBitovi = cBitoviFormule.get(cRbr);
						int cBit = 0;
						for(Integer mBit : mBitovi) 
							cBit += m.charAt(8-mBit)-'0';
						cBit %= 2;
						cBitovi += cBit;
					}
					porukeTA.appendText(m + " : " + cBitovi + "\n");
				}
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
