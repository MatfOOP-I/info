package pakovanje;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PakovanjeMain extends Application {

	private static LinkedList<Paket> paketi = new LinkedList<>();
	private static List<String> lines = null;
	
	public static void main(String[] args) {
		ucitajPakete();
		launch(args);
	}

	private static void ucitajPakete() {
		try {
			lines = Files.readAllLines(Paths.get("paketi.txt"));
			// lines = Files.readAllLines(Paths.get("paketiBezKutija.txt"));

			for (String line : lines) {
				try (Scanner scLine = new Scanner(line)) {
					scLine.useDelimiter(", ");

					char vrsta = scLine.next().charAt(0);

					if (vrsta == 'V') {
						double a = scLine.nextDouble();
						double h = scLine.nextDouble();
						paketi.add(new Valjak(a, h));
					} else {
						double a = scLine.nextDouble();
						double b = scLine.nextDouble();
						double c = scLine.nextDouble();
						paketi.add(new Kutija(a, b, c));
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Greska prilikom ucitavanja paketa.");
			System.exit(1);
		}
	}

	public void start(Stage primaryStage) {

		VBox root = new VBox();
		Scene scene = new Scene(root, 250, 420);

		kreirajGUI(root);

		primaryStage.setTitle("Paketi");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void kreirajGUI(VBox root) {

		Button btnPregledPaketa = new Button("Pregled paketa");
		TextArea taPregled = new TextArea();
		taPregled.setEditable(false);

		VBox top = new VBox(10);
		top.setPadding(new Insets(10, 10, 0, 10));
		top.getChildren().addAll(btnPregledPaketa, taPregled);

		Label lblCena = new Label("Cena zastitne folije");
		TextField tfCena = new TextField();
		tfCena.setMaxWidth(90);
		tfCena.setPrefHeight(40);
		TextArea taKutije = new TextArea();
		taKutije.setEditable(false);
		Button btnKutije = new Button("Izracunaj cenu dodatnog pakovanja");

		HBox bottom1 = new HBox(10);
		bottom1.setAlignment(Pos.CENTER_LEFT);
		bottom1.getChildren().addAll(lblCena, tfCena);

		VBox bottom = new VBox(10);
		bottom.setPadding(new Insets(10, 10, 10, 10));
		bottom.getChildren().addAll(bottom1, taKutije, btnKutije);

		/* obrada dogadjaja */
		obradiPregledPaketa(btnPregledPaketa, taPregled);
		obradiIzracunavanjeCene(btnKutije, taKutije, tfCena);

		root.getChildren().addAll(top, bottom);
	}

	private void obradiPregledPaketa(Button btnPregledPaketa, TextArea taPregled) {
		btnPregledPaketa.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				StringBuilder sb = new StringBuilder();
				// DEO ZA PRAG
				sb.append("DEO ZA PRAG: \n");
				for (String linija : lines)
					sb.append(linija + "\n");
				sb.append("------------------------------------- \n");
				//---------------------------------
				
				for (Paket paket : paketi)
					sb.append(paket + "\n");
				
				if(!sb.equals(""))
					taPregled.setText(sb.toString());
				else
					taPregled.setText("Prazan spisak paketa.");
			}
		});
	}

	private void obradiIzracunavanjeCene(Button btnKutije, TextArea taKutije, TextField tfCena) {
		btnKutije.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				double ukupnaPovrsina = 0;
				double povrsina;
				StringBuilder sb = new StringBuilder();
				for (Paket paket : paketi)
					if (paket instanceof Kutija) {
						povrsina = ((Kutija) paket).povrsina();
						sb.append(paket + ", P = " + String.format("%.2f", povrsina) + "\n");
						ukupnaPovrsina += povrsina;
					}

				if (!sb.toString().equals("")) {
					System.out.println(sb);
					sb.append("------------------------------------- \n");
					sb.append("Ukupna povrsina: " + String.format("%.2f", ukupnaPovrsina) + "\n");

					// Unesena je cena
					String cena = tfCena.getText();
					if (!tfCena.getText().equals("")) {
						sb.append("Ukupna cena: " + String.format("%.2f", ukupnaPovrsina * Double.parseDouble(cena)));
					} else
						sb.append("Nije uneta cena.");
					taKutije.setText(sb.toString());
				} else
					taKutije.setText("Nema kutija medju paketima.");
			}
		});

	}

}
