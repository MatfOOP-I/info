package vet_ambulanta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class AmbulantaGUI extends Application {
	
	private static Red red = new Red();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox(5);
			Scene scene = new Scene(root,542,230);
			
			createGUI(root);

			primaryStage.setTitle("Veterinarska ambulanta");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void createGUI(VBox root) {
		
		Label imeLbl = new Label("Ime:");
		TextField imeTF = new TextField();
		Label starostLbl = new Label("Starost:");
		TextField starostTF = new TextField();
		VBox leviPane = new VBox();
		leviPane.getChildren().addAll(imeLbl, imeTF, starostLbl, starostTF);
		
		TextArea ispisTA = new TextArea();
		ispisTA.setPrefWidth(320);
		ispisTA.setEditable(false);
		HBox desniPane = new HBox();
		desniPane.getChildren().addAll(ispisTA);
		
		HBox topPane = new HBox(30);
		topPane.getChildren().addAll(leviPane, desniPane);
		
		Button ucitajBtn = new Button("Vidi ko ceka");
		Button dodajMackuURedBtn = new Button("Dodaj macku u red");
		Button dodajPsaURedBtn = new Button("Dodaj psa u red");
		Button prozoviSledecegBtn = new Button("Prozovi sledeceg");
		HBox dugmadPane = new HBox(5);
		dugmadPane.getChildren().addAll(ucitajBtn, dodajMackuURedBtn, dodajPsaURedBtn, prozoviSledecegBtn);
		
		obradiUcitavanje(ucitajBtn, ispisTA);
		obradiDodajMacku(imeTF, starostTF, dodajMackuURedBtn, ispisTA);
		obradiDodajPsa(imeTF, starostTF, dodajPsaURedBtn, ispisTA);
		obradiProzoviSledeceg(prozoviSledecegBtn, ispisTA);
		
		root.setPadding(new Insets(10,0,0,10));
		root.getChildren().addAll(topPane, dugmadPane);
		
	}


	private void obradiProzoviSledeceg(Button prozoviSledecegBtn, TextArea ispisTA) {
		
		prozoviSledecegBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				Ljubimac sledeci = red.prozoviSledeceg();
				StringBuffer sb = new StringBuffer();
				if(sledeci != null) {
					sb.append("Prozvan:\n" +  sledeci + "\n\n");
					sb.append("U redu:\n" + red.toString());
				}
				else
					sb.append("Nema ljubimaca u cekaonici!");
				
				ispisTA.setText(sb.toString());
			}
		});
	}

	private void obradiDodajPsa(TextField imeTF, TextField starostTF, Button dodajPsaURedBtn, TextArea ispisTA) {
		
		dodajPsaURedBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				red.dodajURed(new Pas(imeTF.getText(), Integer.parseInt(starostTF.getText())));
				ispisTA.setText(red.toString());
			}
		});
	}

	private void obradiDodajMacku(TextField imeTF, TextField starostTF, Button dodajMackuURedBtn, TextArea ispisTA) {

		dodajMackuURedBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				red.dodajURed(new Macka(imeTF.getText(), Integer.parseInt(starostTF.getText())));
				ispisTA.setText(red.toString());
			}
		});
	}

	private void obradiUcitavanje(Button ucitajBtn, TextArea ispisTA) {
		
		ucitajBtn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				int brojMacaka = 0, brojPasa = 0;
				List<String> linije;
				String podaci[] = new String[4];

				try {
					linije = Files.readAllLines(Paths.get("baza.txt"));
							
					for(String linija : linije) {
						
						podaci = linija.split(", ");
						if(podaci[0].equals("P")) {
							brojPasa++;							
							
							if(Pas.validnaIdentifikacija(podaci[3]))
								red.dodajURed(new Pas(podaci[1], Integer.parseInt(podaci[2]), podaci[3]));
						}
						else if(podaci[0].equals("M")) {
							brojMacaka++;
							
							if(Macka.validnaIdentifikacija(podaci[3]))
								red.dodajURed(new Macka(podaci[1], Integer.parseInt(podaci[2]), podaci[3]));
						}
						
					}
					
					if(brojMacaka != 0 || brojPasa != 0)
						ispisTA.setText("U redu ceka " + brojMacaka + " macaka i " + brojPasa + " pasa.");
					else
						ispisTA.setText("U redu ne ceka ni jedan ljubimac.");
				}
				catch(IOException e) {
					System.err.println("Neuspelo ucitavanje datoteke");
					System.exit(1);
				}
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
