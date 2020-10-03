package dekodiranje;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
	private static Map<Integer, List<Integer>> cPrimBitovi = new HashMap<>();
	private static List<KodiranaPoruka> poruke = new ArrayList<KodiranaPoruka>();
	
	public void start(Stage primaryStage) {
		try {
			HBox root = new HBox(10);
			Scene scene = new Scene(root,520,280);
			
			createGUI(root);

			primaryStage.setTitle("Otkrivanje gresaka u kodiranim binarnim porukama");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createGUI(HBox root) {
		
		TextArea porukeTA = new TextArea();
		porukeTA.setEditable(false);
		porukeTA.setMaxWidth(350);
		
		Button porukeBtn = new Button("Ucitaj i prikazi poruke");
		Button tablicaBtn = new Button("Ucitaj tablicu");
		Button formuleBtn = new Button("Kako se dekodira?");
		Button proveriBtn = new Button("Proveri ispravnost poruka");
		VBox dugmadPane = new VBox(10);
		dugmadPane.setAlignment(Pos.CENTER_LEFT);
		dugmadPane.getChildren().addAll(porukeBtn, tablicaBtn, formuleBtn, proveriBtn);
		
		obradiPoruke(porukeBtn, porukeTA);
		obradiTablicu(tablicaBtn, porukeTA);
		obradiFormule(formuleBtn, porukeTA);
		obradiProveri(proveriBtn, porukeTA);
				
		root.setPadding(new Insets(10));
		root.getChildren().addAll(porukeTA, dugmadPane);
	}

	/***  DEO ZA PRAG  ***/
	private void obradiPoruke(Button porukeBtn, TextArea porukeTA) {
		
		porukeBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				porukeTA.appendText("\nm8m7m6m5m4m3m2m1 : c4c3c2c1\n");
				porukeTA.appendText("----------------------------------------\n");
				try {
					List<String> linije = Files.readAllLines(Paths.get("poruke.txt"));
					if(linije.isEmpty())
						porukeTA.appendText("Nema poruka u datoteci!");
					for(String linija : linije) {
						String m = linija.substring(0, 8);
						String c = linija.substring(8);
						porukeTA.appendText(m + " : " + c + "\n");
						
						KodiranaPoruka p = new KodiranaPoruka(m, c); // van praga
					    poruke.add(p); // van praga
					}
				}
				catch(IOException e) {
					System.err.println("Neuspelo ucitavanje poruka!");
					System.exit(1);
				}
			}
		});
	}
	/***  KRAJ DELA ZA PRAG  ***/	
	
	private void obradiTablicu(Button tablicaBtn, TextArea porukeTA) {
		
		tablicaBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				
				try {
					List<String> linije = Files.readAllLines(Paths.get("tablica.txt"));
					for(String linija : linije) {
						Scanner sc = new Scanner(linija);
						String binarniKod = sc.next();
						String bit = sc.next();

						if(bit.charAt(0) == 'm') 
							mBitovi.put(binarniKod, bit.charAt(1)-'0');  
						else 
							cBitovi.put(binarniKod, bit.charAt(1)-'0'); 

						sc.close();
					}
					porukeTA.appendText("\nTablica je uspesno ucitana!\n");
				} 
				catch(IOException e) {
					System.err.println("Neuspelo ucitavanje tablice!");
					System.exit(1);
				}
			}
		});
	}

	private void obradiFormule(Button formuleBtn, TextArea porukeTA) {
		
		formuleBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				try {
					
					List<String> linije = Files.readAllLines(Paths.get("formule.txt"));
					if(linije.isEmpty())
						porukeTA.appendText("Nema formula u datoteci!");
					
					for(String linija : linije) {
						porukeTA.appendText("\n" + linija);
						
						String[] delovi = linija.split(" = ");
						Integer cPrim = delovi[0].charAt(1)-'0';
						String[] mBitovi = delovi[1].split(" \\+ ");
						
						List<Integer> cFormula = new ArrayList<>();
						for(int i = 0; i < mBitovi.length; i++) 
							cFormula.add(mBitovi[i].charAt(1)-'0');
						
						cPrimBitovi.put(cPrim, cFormula);
					}	
				}
				catch(IOException e) {
					System.err.println("Neuspelo ucitavanje formula!");
					System.exit(1);
				}
			}
		});
	}
	
	private void obradiProveri(Button proveriBtn, TextArea porukeTA) {
		
		proveriBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				porukeTA.appendText("\n\nm8m7m6m5m4m3m2m1 : c4c3c2c1 + c4'c3'c2'c1'\n");
				porukeTA.appendText("-------------------------------------------------------\n");
				for(KodiranaPoruka poruka : poruke) {
					String m = poruka.getBitoviM();
					String c = poruka.getBitoviC();
					String cPrim = "";
					// odredjujemo kontrolne bitove (jedan po jedan), na osnovu formula
					// sadrzanih u mapi cPrimBitovi 
					for(int cPRbr = 4; cPRbr >= 1; cPRbr--) {
						List<Integer> mBitovi = cPrimBitovi.get(cPRbr);
						int cP = 0;
						for(Integer mBit : mBitovi) 
							cP += m.charAt(8-mBit)-'0';
						cP %= 2;
						cPrim += cP;
					}
					porukeTA.appendText(poruka + " + " + cPrim + "\n");
					
					String sindrom = "";
					for(int i = 0; i < 4; i++)
						sindrom += (c.charAt(i) + cPrim.charAt(i)) % 2;
					
					// ukoliko je sadrzaj stringa "sindrom" jednak nekom od kljuceva mape mBitovi
					// neispravan je odgovarajuci bit poruke
					porukeTA.appendText("s4s3s2s1: " + sindrom);
					boolean greska_m = false;
					boolean greska_c = false;
					for(String kljuc : mBitovi.keySet()) 
						if(sindrom.equals(kljuc)) {
							porukeTA.appendText(" => Poruka je neispravna, greska je u bitu m" + mBitovi.get(kljuc) + "\n");
							greska_m = true;
							break;
						}
					// ako je jednak nekom od kljuceva mape cBitovi, neispravan je odgovarajuci kontrolni bit
					if(!greska_m)
						for(String kljuc : cBitovi.keySet()) 
							if(sindrom.equals(kljuc)) {
								porukeTA.appendText(" => Poruka je ispravna, greska je u bitu c" + cBitovi.get(kljuc) + "\n");
								greska_c = true;
								break;
							}
					if(!greska_m && !greska_c)
						porukeTA.appendText(" => Poruka je ispravna\n");
				}
			}
		});
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
