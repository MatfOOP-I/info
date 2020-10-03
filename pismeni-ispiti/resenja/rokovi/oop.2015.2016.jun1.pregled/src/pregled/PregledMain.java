package pregled;
	
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PregledMain extends Application {
	
	private static ArrayList<Pacijent> pacijenti = new ArrayList<>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox(10);
			Scene scene = new Scene(root,650,430);
			
			kreirajGUI(root);
			
			primaryStage.setTitle("Nutricionistički pregled");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void kreirajGUI(VBox root) {	
		
		Label labela = new Label("Stanje u čekaonici:");
		
		TextArea pregledTA = new TextArea();
		pregledTA.setMaxWidth(630);
		pregledTA.setPrefHeight(350);
		pregledTA.setEditable(false);
		
		Button pregledBtn = new Button("Pregled čekaonice");
		pregledBtn.setPrefWidth(250);
		Button pregledKriterijumBtn = new Button("Pregled uređeno");	
		pregledKriterijumBtn.setPrefWidth(250);
		HBox donjiSloj = new HBox(20);
		donjiSloj.setPadding(new Insets(0,0,0,50));
		donjiSloj.getChildren().addAll(pregledBtn, pregledKriterijumBtn);	
		
		obradiPregledCekaonice(pregledBtn, pregledTA);
		obradiPregledPremaKriterijumu(pregledKriterijumBtn, pregledTA);

		root.setPadding(new Insets(10,0,0,10));
		root.getChildren().addAll(labela, pregledTA, donjiSloj);
		
	}

	private void obradiPregledPremaKriterijumu(Button pregledKriterijumBtn, TextArea pregledTA) {

		pregledKriterijumBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				Collections.sort(pacijenti);
				StringBuilder sb = new StringBuilder();
				
				for(Pacijent p : pacijenti)
					sb.append(p + "\n");
				
				pregledTA.setText(sb.toString());
			}
		});
	}

	private void obradiPregledCekaonice(Button pregledBtn, TextArea pregledTA) {

		pregledBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				List<String> linije = null;
				StringBuilder sb = new StringBuilder("DEO ZA PRAG:\n");
				Character pol;
				int G;
				double T, V;
				FizickaAktivnost PA;
				
				try {
					
					linije = Files.readAllLines(Paths.get("cekaonica.txt"));
					
					if(!linije.isEmpty()) {
						for(String linija : linije) {
							
							try(Scanner scLinija = new Scanner(linija)) {								
								scLinija.useDelimiter(", ");
								
								pol = scLinija.next().charAt(0);
								G = scLinija.nextInt();
								V = scLinija.nextDouble();
								T = scLinija.nextDouble();
								PA = FizickaAktivnost.valueOf(scLinija.next());
								
								Pacijent p = null;
								if(pol == 'M')
									p = new Muskarac(T, V, G, PA);
								else
									p = new Zena(T, V, G, PA);
								
								pacijenti.add(p);								
							}
							
							sb.append(linija + "\n");
						}					
						sb.append("-------------------------------------");
					}		
					else
						sb.append("Niko ne ceka u cekaonici");
						
					pregledTA.setText(sb.toString());				
					
				}
				catch(IOException e) {
					System.err.println("Greska prilikom citanja iz cekaonica.txt");
					System.exit(1);
				}
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
