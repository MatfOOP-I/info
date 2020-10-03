package poruke;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sanduce extends Application {

    private static Korisnik tweety = new Korisnik("Tweety");
    private Path datoteka = Paths.get("poruke.txt");

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        HBox hbRadio = new HBox(10);
        TextArea taIspis = new TextArea();
        Label lblPrimalac = new Label("Primalac:");
        TextField tfPrimalac = new TextField();
        Label lblDatum = new Label("Datum:");
        TextField tfDatum = new TextField();
        Label lblPoruka = new Label("Poruka za slanje:");
        TextArea taPoruka = new TextArea();
        HBox hbDugmici = new HBox(10);
        root.getChildren().addAll(hbRadio, taIspis, lblPrimalac, tfPrimalac, lblDatum, tfDatum, lblPoruka, taPoruka, hbDugmici);

        Button btnSvePoruke = new Button("Sve poruke");
        RadioButton rbPoslate = new RadioButton("Poslate");
        RadioButton rbPrimljene = new RadioButton("Primljene");
        ToggleGroup tg = new ToggleGroup();
        rbPoslate.setToggleGroup(tg);
        rbPrimljene.setToggleGroup(tg);
        rbPoslate.setSelected(true);
        Button btnPrikazi = new Button("Prikazi");
        hbRadio.getChildren().addAll(btnSvePoruke, rbPoslate, rbPrimljene, btnPrikazi);
        hbRadio.setAlignment(Pos.CENTER);

        Button btnPosalji = new Button("Posalji poruku");
        Button btnSacuvaj = new Button("Sacuvaj poruke");
        hbDugmici.getChildren().addAll(btnPosalji, btnSacuvaj);

        btnSvePoruke.setOnAction(e -> {
            taIspis.setText("Dobrodisli, " + tweety.getKorisnickoIme() + "!");
            try {
                List<String> linije = Files.readAllLines(datoteka);

                for (String linija : linije) {
                    tweety.novaPoruka(linija);
                }

                ispisiPorukeSortirano(taIspis);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        btnPrikazi.setOnAction(e -> {
            taIspis.clear();
            if (rbPoslate.isSelected()) {
                for (Poruka poruka : tweety.getPoruke()) {
                    if (poruka instanceof PoslataPoruka) {
                        taIspis.appendText(poruka.toString());
                    }
                }
            }
            if (rbPrimljene.isSelected()) {
                for (Poruka poruka : tweety.getPoruke()) {
                    if (poruka instanceof PrimljenaPoruka) {
                        taIspis.appendText(poruka.toString());
                    }
                }
            }
        });

        btnPosalji.setOnAction(e -> {
            String primalac = tfPrimalac.getText().trim();
            String datum = tfDatum.getText().trim();
            String poruka = taPoruka.getText().trim();

            if (!primalac.equals("") && !datum.equals("") && !poruka.equals("")) {
                PoslataPoruka novaPoruka = new PoslataPoruka(poruka, datum , primalac);
                tweety.novaPoruka(novaPoruka.sacuvajPoruku());
                ispisiPorukeSortirano(taIspis);
            }
        });


        btnSacuvaj.setOnAction(e -> {
            List<String> zaCuvanje = new ArrayList<>();

            for (Poruka poruka : tweety.getPoruke()) {
                zaCuvanje.add(poruka.sacuvajPoruku());
            }
            try {
                Files.write(datoteka, zaCuvanje);
                taIspis.setText("Poruke uspesno sacuvane!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        primaryStage.setScene(new Scene(root, 500, 600));
        primaryStage.setTitle("Sanduce");
        primaryStage.show();
    }

    public static void ispisiPorukeSortirano(TextArea taIspis) {
        Collections.sort(tweety.getPoruke());
        taIspis.clear();
        for (Poruka poruka : tweety.getPoruke()) {
            taIspis.appendText(poruka.toString());
        }
    }
}
