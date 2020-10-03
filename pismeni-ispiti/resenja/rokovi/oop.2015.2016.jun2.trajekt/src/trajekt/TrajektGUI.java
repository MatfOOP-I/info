package trajekt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrajektGUI extends Application {

	private static List<String> lines = null;
	private static Trajekt trajekt = null;

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		Scene scene = new Scene(root, 250, 333);

		kreirajGUI(root);

		primaryStage.setTitle("Trajekt");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void kreirajGUI(VBox root) {

		Button btnUcitaj = new Button("Ucitaj");
		TextArea taUcitaj = new TextArea();
		taUcitaj.setEditable(false);
		taUcitaj.setPrefHeight(140);
		VBox top = new VBox(5);
		top.setPadding(new Insets(5, 5, 0, 5));
		top.getChildren().addAll(btnUcitaj, taUcitaj);

		TextField tfIzmena = new TextField();
		Button btnIzvezi = new Button("Izvezi");
		HBox bottom1 = new HBox(5);
		bottom1.setAlignment(Pos.CENTER_LEFT);
		bottom1.getChildren().addAll(tfIzmena, btnIzvezi);

		TextArea taNovo = new TextArea();
		taNovo.setEditable(false);
		taNovo.setPrefHeight(130);

		VBox bottom = new VBox(5);
		bottom.setPadding(new Insets(5, 5, 0, 5));
		bottom.getChildren().addAll(bottom1, taNovo);

		/* obrada dogadjaja */
		obradiUcitaj(btnUcitaj, taUcitaj);
		obradiIzvezi(btnIzvezi, taNovo, tfIzmena);

		root.getChildren().addAll(top, bottom);
	}

	private void obradiUcitaj(Button btnUcitaj, TextArea taUcitaj) {
		btnUcitaj.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				// Ucitavanje vozila
				ucitajVozila();

				StringBuffer sb = new StringBuffer();
				// DEO ZA PRAG
				for (String linija : lines)
					sb.append(linija + "\n");
				// ---------------------------------

				if (!sb.equals(""))
					taUcitaj.setText(sb.toString());
				else
					taUcitaj.setText("Nema trajekta.");
			}
		});
	}

	private static void ucitajVozila() {

		try {
			lines = Files.readAllLines(Paths.get("trajekt.txt"));

			for (String line : lines) {
				try (Scanner scLine = new Scanner(line)) {
					scLine.useDelimiter(", ");

					char vrsta = scLine.next().charAt(0);

					if (vrsta == 'T') {
						int brMesta = scLine.nextInt();
						double maxTezina = scLine.nextDouble();
						double cena = scLine.nextDouble();

						trajekt = new Trajekt(brMesta, maxTezina, cena);
					} else if (vrsta == 'A') {
						double tezina = scLine.nextDouble();
						int kapacitet = scLine.nextInt();
						int mesto = scLine.nextInt();

						Autobus a = new Autobus(tezina, kapacitet);
						trajekt.uvezi(a, mesto);
					} else if (vrsta == 'K') {
						double tezina = scLine.nextDouble();
						int nosivost = scLine.nextInt();
						int mesto = scLine.nextInt();

						Kamion k = new Kamion(tezina, nosivost);
						trajekt.uvezi(k, mesto);
					}
				}
			}
		} catch (IOException e) {
			System.err.println("Greska prilikom ucitavanja vozila.");
			System.exit(1);
		}

	}

	private void obradiIzvezi(Button btnIzvezi, TextArea taNovo, TextField tfIzmena) {
		btnIzvezi.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (trajekt == null)
					taNovo.setText("Nema trajekta!");
				else {
					String izmena = tfIzmena.getText();
					if (!izmena.equals(""))
						trajekt.izvezi(Integer.parseInt(izmena));
					taNovo.setText(trajekt.toString() + "-------------\nUkupan prihod: " + trajekt.prihod());
				}
			}

		});

	}

}
