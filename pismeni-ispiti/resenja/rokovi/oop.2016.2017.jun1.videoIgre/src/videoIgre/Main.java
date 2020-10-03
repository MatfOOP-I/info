package videoIgre;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main extends Application {

	private List<VideoIgra> igre = new ArrayList<>();

	private VBox root;
	private Button btUcitaj, btSortiraj, btDodajIgru, btPrikaziIgre;
	private TextArea taIgre;
	private RadioButton rbPC, rbPS4, rbXBOne, rbSve;
	private RadioButton rbIme, rbCena;
	private RadioButton rbDodajPc, rbDodajPS4, rbDodajXBOX;
	private TextField tfIme, tfCena, tfZanr, tfZahtevnost;

	// Metod konstruise graficki korisnicki interfejs.
	private void createGui(Stage primaryStage) {
		root = new VBox(10);
		root.setPadding(new Insets(10, 10, 10, 10));

		btUcitaj = new Button("Ucitaj video igre");
		HBox hb1 = new HBox(10);
		hb1.setAlignment(Pos.CENTER);
		hb1.getChildren().addAll(btUcitaj);
		root.getChildren().addAll(hb1);

		taIgre = new TextArea();
		root.getChildren().addAll(taIgre);

		HBox hb2 = new HBox(10);
		VBox vb1 = new VBox(10);
		VBox vb2 = new VBox(10);
		VBox vb3 = new VBox(10);
		hb2.getChildren().addAll(vb1, vb2, vb3);
		root.getChildren().add(hb2);

		// vb1
		Label lblPlatforma = new Label("Platforma");
		ToggleGroup tg1 = new ToggleGroup();
		rbPC = new RadioButton("PC");
		rbPS4 = new RadioButton("PS4");
		rbXBOne = new RadioButton("XBOX One");
		rbSve = new RadioButton("Sve");
		rbPC.setToggleGroup(tg1);
		rbPC.setToggleGroup(tg1);
		rbPS4.setToggleGroup(tg1);
		rbXBOne.setToggleGroup(tg1);
		rbSve.setToggleGroup(tg1);
		btPrikaziIgre = new Button("Prikazi");
		vb1.getChildren().addAll(lblPlatforma, rbPC, rbPS4, rbXBOne, rbSve, btPrikaziIgre);

		// vb2
		Label lblSortiranje = new Label("Sortiraj po:");
		ToggleGroup tg2 = new ToggleGroup();
		rbIme = new RadioButton("Imenu");
		rbCena = new RadioButton("Ceni");
		rbIme.setToggleGroup(tg2);
		rbCena.setToggleGroup(tg2);
		btSortiraj = new Button("Sortiraj");
		vb2.getChildren().addAll(lblSortiranje, rbIme, rbCena, btSortiraj);

		// vb3
		Label lblIme = new Label("Ime:");
		tfIme = new TextField();
		Label lblCena = new Label("Cena:");
		tfCena = new TextField();
		Label lblZanr = new Label("Zanr:");
		tfZanr = new TextField();
		Label lblZahtevnost = new Label("Zahtevnost:");
		tfZahtevnost = new TextField();
		ToggleGroup tg3 = new ToggleGroup();
		rbDodajPc = new RadioButton("PC");
		rbDodajPS4 = new RadioButton("PS4");
		rbDodajXBOX = new RadioButton("XBOX ONE");
		rbDodajPc.setToggleGroup(tg3);
		rbDodajPS4.setToggleGroup(tg3);
		rbDodajXBOX.setToggleGroup(tg3);
		btDodajIgru = new Button("Dodaj");
		vb3.getChildren().addAll(lblIme, tfIme, lblCena, tfCena, lblZanr, tfZanr, lblZahtevnost, tfZahtevnost);
		vb3.getChildren().addAll(rbDodajPc, rbDodajPS4, rbDodajXBOX, btDodajIgru);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		createGui(primaryStage);

		// Ucitavanje video igara iz tekstualne datoteke.
		btUcitaj.setOnAction(e -> {
			Path input = Paths.get("igre.txt");
			try {
				List<String> linije = Files.readAllLines(input, StandardCharsets.UTF_8);
				for (String linija : linije) {
					String[] tokeni = linija.split(",");
					String tip = tokeni[0].trim();
					String ime = tokeni[1].trim();
					String zanr = tokeni[2].trim();
					int cena = Integer.parseInt(tokeni[3].trim());
					if (tip.equals("pc")) {
						int zahtevnost = Integer.parseInt(tokeni[4].trim());
						igre.add(new PCVideoIgra(ime, zanr, cena, zahtevnost));
					} else {
						igre.add(new KonzolnaVideoIgra(ime, zanr, cena, tip));
					}
				}

				taIgre.setText("Broj ucitanih igara: " + igre.size());
			} catch (IOException e1) {
				taIgre.setText("Neuspelo ucitavanje igara.");
			}
		});

		// Prikazuju se igre u zavisnosti od izabranog dugmeta.
		btPrikaziIgre.setOnAction(e -> {
			taIgre.clear();

			for (VideoIgra vi : igre) {
				// Pretpostavljamo da igru ne treba prikazati.
				boolean prikazi = false;

				// Pokusavamo naci razlog da je ipak prikazemo :)
				if (rbPC.isSelected() && vi.getPlatforma().equals("pc"))
					prikazi = true;
				if (rbPS4.isSelected() && vi.getPlatforma().equals("ps4"))
					prikazi = true;
				if (rbXBOne.isSelected() && vi.getPlatforma().equals("xbone"))
					prikazi = true;
				if (rbSve.isSelected())
					prikazi = true;
				if (!rbPC.isSelected() && !rbPS4.isSelected() && !rbXBOne.isSelected() && !rbSve.isSelected())
					prikazi = true;

				if (prikazi)
					taIgre.appendText("* " + vi.toString() + "\n");
			}
		});

		btSortiraj.setOnAction(e -> {
			if (rbIme.isSelected()) {
				// Prvi nacin, jedna linija :)
				// igre.sort(Comparator.comparing(VideoIgra::getIme));

				igre.sort(new Comparator<VideoIgra>() {
					@Override
					public int compare(VideoIgra a, VideoIgra b) {
						return a.getIme().compareTo(b.getIme());
					}
				});

				// Treci nacin, isti kao drugi ali koristi lambda sintaksu da se
				// skrati zapis
				// igre.sort((VideoIgra a, VideoIgra b) -> {
				// return a.getIme().compareTo(b.getIme());
				// });
			} else if (rbCena.isSelected()) {
				// igre.sort(Comparator.comparingInt(VideoIgra::getCena));

				igre.sort(new Comparator<VideoIgra>() {
					@Override
					public int compare(VideoIgra a, VideoIgra b) {
						return Integer.compare(a.getCena(), b.getCena());
					}
				});

				// igre.sort((VideoIgra a, VideoIgra b) -> {
				// return Integer.compare(a.getCena(), b.getCena());
				// });
			}

			btPrikaziIgre.fire();
		});

		btDodajIgru.setOnAction(e -> {
			try {
				String ime = tfIme.getText().trim();
				String zanr = tfZanr.getText().trim();
				int cena = Integer.parseInt(tfCena.getText().trim());

				if (ime.isEmpty() || zanr.isEmpty()) {
					taIgre.setText("Greska pri unosu!");
					return;
				}

				if (rbDodajPc.isSelected()) {
					int zahtevnost = Integer.parseInt(tfZahtevnost.getText().trim());
					igre.add(new PCVideoIgra(ime, zanr, cena, zahtevnost));
				} else if (rbDodajPS4.isSelected()) {
					igre.add(new KonzolnaVideoIgra(ime, zanr, cena, "ps4"));
				} else if (rbDodajXBOX.isSelected()) {
					igre.add(new KonzolnaVideoIgra(ime, zanr, cena, "xbone"));
				}
				taIgre.setText("Uspesno je dodata igra!");
			} catch (NumberFormatException e1) {
				taIgre.setText("Greska pri unosu!");
			}
		});

		primaryStage.setTitle("Video igre");
		primaryStage.setScene(new Scene(root, 400, 550));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
