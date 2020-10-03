package primer02Anagram;

import java.util.Random;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	private static String izracunajAnagram(String s) {
		char[] tmp = s.toCharArray();
		
		// Algoritam koji permutuje niz.
		Random rand = new Random();
		for (int i = 0; i < tmp.length; i++) {
			// Generisemo pseudo slucajni indeks u nizu karaktera.
			int k = rand.nextInt(tmp.length);
			
			// Vrsimo razmenu karaktera na indeksima 'i' i 'k'.
			char helper = tmp[i];
			tmp[i] = tmp[k];
			tmp[k] = helper;
		}
		
		return String.valueOf(tmp);
	}

	@Override
	public void start(Stage primaryStage) {
		VBox root = new VBox(10);
		
		/*
		 	Konstruisemo sledecu konstrukciju:
		  	VBox:
		  		HBox:
		  			VBox 		<- vbLevi
		  			VBox 		<- vbDesni
				Label 			<- lblIme
				TextArea 		<- tfUnos
				Label 			<- lblPoruka
		*/

		/*
			HBox:
				VBox 			<- vbLevi
		 		VBox 			<- vbDesni
		*/
		HBox hbTop = new HBox(10);
		VBox vbLevi = new VBox(10);
		VBox vbDesni = new VBox(10);
		vbLevi.setPadding(new Insets(10, 0, 0, 10));
		vbDesni.setPadding(new Insets(10, 10, 0, 0));
		hbTop.getChildren().addAll(vbLevi, vbDesni);

		/*
			VBox: 				<- vbLevi
		 		Label 			<- lblIme
		 		TextField 		<- tfUnos
		*/
		Label lblIme = new Label("Unesite Vase ime:");
		TextField tfUnos = new TextField();
		vbLevi.getChildren().addAll(lblIme, tfUnos);

		/*
		 VBox: 				<- vbDesni
		 	Button 			<- btUnos
			Button 			<- btOcisti
			Button 			<- btIzadji
		*/
		Button btnUnos = new Button("Potvrdi");
		Button btnOcisti = new Button("Ocisti");
		Button btnIzadji = new Button("Izadji");
		vbDesni.getChildren().addAll(btnUnos, btnOcisti, btnIzadji);

		/*
			Label 			<- lblIme
			TextArea 		<- tfUnos
			Label 			<- lblPoruka
		*/
		Label lblIspis = new Label("Ispis: ");
		TextArea taIspis = new TextArea();
		Label lblPoruka = new Label();
		lblPoruka.setTextFill(Color.RED);
		
		root.getChildren().addAll(hbTop, lblIspis, taIspis, lblPoruka);
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anagrami");
		
		btnUnos.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String korisnikiUnos = tfUnos.getText();
				if (korisnikiUnos.isEmpty()) {
					lblPoruka.setText("Molimo unesite neki tekst.");
					return;
				}
				String anagram = izracunajAnagram(korisnikiUnos);
				taIspis.setText("Vas anagram je: " + anagram);
				lblPoruka.setText("");
			}
		});
		
		btnOcisti.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tfUnos.clear();
				lblPoruka.setText("");
				taIspis.clear();
			}
		});
		
		// Dodajemo dogadjaje na dugmice.
		btnIzadji.setOnAction(e ->  Platform.exit());

		/*
			Ne smemo zaboravljati sledecu naredbu, ona prikazuje konstruisani
			graficki interfejs.
	 	*/
		primaryStage.show();
	}
}
