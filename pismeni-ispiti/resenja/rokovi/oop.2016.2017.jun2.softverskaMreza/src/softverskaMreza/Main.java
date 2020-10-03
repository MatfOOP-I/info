package softverskaMreza;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	private TextArea taSoftver;
	private TextField tfJezik;
	private Button btPrikaziSve, btNajpopularnijiJezik, btsoftverZajezik, btUkupnoLinijaKodaZaJezik, btUkupnoLinijaKoda;

	@Override
	public void start(Stage primaryStage) {
		makeGUI(primaryStage);

		SoftverskaMreza mreza = new SoftverskaMreza("HitGub");
		
		if (mreza.ucitajPodatke("softver.txt"))
			taSoftver.setText("Ucitani su podaci.");
		else
			taSoftver.setText("Neuspelo ucitavanje podataka.");

		// Prikazivanje celokupnog softvera koji mreza sadrzi
		btPrikaziSve.setOnAction(e -> {
			taSoftver.setText(mreza.toString());
		});

		// Najpopularniji jezik.
		btNajpopularnijiJezik.setOnAction(e -> {
			taSoftver.setText("Najpopularniji jezik: " + mreza.najpopularnijiJezik());
		});

		// Trazenje softvera za jezik koji korisnik prosledi.
		btsoftverZajezik.setOnAction(e -> {
			String jezik = tfJezik.getText();
			if (jezik.isEmpty()) {
				taSoftver.setText("Unesite jezik u tekstualno polje i pokusajte ponovo.");
				return;
			}
			taSoftver.setText("Softver za jezik " + jezik + "\n");
			for (Softver s : mreza.softverZaJezik(jezik))
				taSoftver.appendText(" * " + s.toString() + "\n");
		});

		// Trazi se broj linija koda celokupnog softvera implementiranog
		// u jeziku koji je prosledio korisnik.
		btUkupnoLinijaKodaZaJezik.setOnAction(e -> {
			String jezik = tfJezik.getText();
			if (jezik.isEmpty()) {
				taSoftver.setText("Unesite jezik u tekstualno polje i pokusajte ponovo.");
				return;
			}
			taSoftver.setText("Ukupno linija koda za jezik " + jezik + ": " + mreza.ukupnoLinijaKodaZaJezik(jezik));
		});

		// Trazi se ukupan broj linija kode softverske mreze.
		btUkupnoLinijaKoda.setOnAction(e -> {
			taSoftver.setText("Ukupno linija koda: " + mreza.ukupnoLinija());
		});
	}

	// Metod konstruise graficki korisnicki interfejs.
	private void makeGUI(Stage primaryStage) {
		VBox root = new VBox(10);
		root.setPadding(new Insets(10, 10, 10, 10));

		taSoftver = new TextArea();
		taSoftver.setPrefHeight(350);
		tfJezik = new TextField();
		btPrikaziSve = new Button("Sadrzaj mreze");
		btNajpopularnijiJezik = new Button("Najpopularniji jezik");
		btsoftverZajezik = new Button("Softver za jezik");
		btUkupnoLinijaKodaZaJezik = new Button("Ukupno linija koda za jezik");
		btUkupnoLinijaKoda = new Button("Ukupno linija koda");
		HBox dugmici = new HBox(10);
		dugmici.setAlignment(Pos.CENTER);
		dugmici.getChildren().addAll(btPrikaziSve, btNajpopularnijiJezik, btsoftverZajezik, btUkupnoLinijaKodaZaJezik,
				btUkupnoLinijaKoda);
		root.getChildren().addAll(taSoftver, tfJezik, dugmici);

		Scene scene = new Scene(root, 850, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Softverska mreza");
		primaryStage.show();
	}
}
