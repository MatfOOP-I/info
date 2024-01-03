package com.example.primerispita;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ZadatakJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox koren = new VBox(10);
        koren.setPadding(new Insets(10, 10, 10, 10));
        koren.setAlignment(Pos.CENTER);

        Label lbPrikaz = new Label("Odaberite prikaz rezultata:");
        Label lbGreska = new Label();
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(0, 0, 0, 100));
        Button btPrikazi = new Button("Prikazi");
        Button btOcisti = new Button("Ocisti");
        TextArea taIspis = new TextArea();
        koren.getChildren().addAll(lbPrikaz, lbGreska, hBox, btPrikazi, btOcisti, taIspis);

        // hb
        RadioButton rbRastuce = new RadioButton("Rastuce");
        RadioButton rbOpadajuce = new RadioButton("Opadajuce");

        ToggleGroup tg = new ToggleGroup();
        rbRastuce.setToggleGroup(tg);
        rbOpadajuce.setToggleGroup(tg);

        hBox.getChildren().addAll(rbRastuce, rbOpadajuce);

        ////////////////////////////////////////////////////////////////////////////////////////

        TreeMap<String, Integer> timovi = procitajIzDatoteke();
        List<Map.Entry<String, Integer>> listaZaSortiranje = new ArrayList<>(timovi.entrySet());
        listaZaSortiranje.sort((e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));

        btPrikazi.setOnAction(e -> {
            lbGreska.setText("");
            taIspis.clear();

            if (rbRastuce.isSelected()) {
                for (Map.Entry<String, Integer> element : listaZaSortiranje) {
                    String imeTima = element.getKey();
                    int poeni = element.getValue();
                    taIspis.appendText(imeTima + ": " + (poeni == Integer.MIN_VALUE ? "d" : poeni));
                    taIspis.appendText("\n");
                }
            } else if (rbOpadajuce.isSelected()) {
                for (int i = listaZaSortiranje.size() - 1; i >= 0; i--) {
                    Map.Entry<String, Integer> element = listaZaSortiranje.get(i);
                    String imeTima = element.getKey();
                    int poeni = element.getValue();
                    taIspis.appendText(imeTima + ": " + (poeni == Integer.MIN_VALUE ? "d" : poeni));
                    taIspis.appendText("\n");
                }
            } else {
                lbGreska.setText("ODABERITE PRIKAZ!!!");
                lbGreska.setTextFill(Color.RED);
            }
        });

        btOcisti.setOnAction(e -> {
            taIspis.clear();
            lbGreska.setText("");

            rbRastuce.setSelected(false);
            rbOpadajuce.setSelected(false);
        });

        // scena
        Scene scena = new Scene(koren, 400, 300);
        stage.setScene(scena);
        stage.setTitle("HACKATHON");
        stage.show();

    }

    private TreeMap<String, Integer> procitajIzDatoteke() throws IOException {
        TreeMap<String, Integer> timovi = new TreeMap<>();

        Path putanja = Paths.get("Rezultati.txt");

        try (Scanner ulaz = new Scanner(putanja)) {
            while (ulaz.hasNext()) {
                String imeTima = ulaz.next();

                if (ulaz.hasNextInt()) {
                    int brojPoena = ulaz.nextInt();
                    timovi.put(imeTima, brojPoena);
                } else {
                    ulaz.next();
                    timovi.put(imeTima, Integer.MIN_VALUE);
                }
            }
        }

        return timovi;
    }
}
