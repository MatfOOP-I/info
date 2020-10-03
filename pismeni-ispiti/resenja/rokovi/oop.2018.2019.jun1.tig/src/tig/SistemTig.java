package tig;

import javafx.application.Application;
import javafx.geometry.Insets;
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
import java.util.LinkedList;
import java.util.List;

public class SistemTig extends Application {
    private List<Izmena> izmene = new ArrayList<>();

    private void azurirajIzmene(TextArea taLog)
    {
        taLog.clear();
        izmene.forEach(i -> {
            taLog.appendText(i.toString() + "\n\n");
        });
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        HBox hbTop = new HBox(10);
        Button btUcitaj = new Button("Ucitaj");
        Button btSacuvaj = new Button("Sacuvaj");
        hbTop.getChildren().addAll(btUcitaj, btSacuvaj);

        TextArea taLog = new TextArea();
        taLog.setPrefRowCount(60);

        HBox hbBottom = new HBox(10);

        // VBLeft
        VBox vbLeft = new VBox(10);
        Label labAutor = new Label("Autor");
        TextField tfAutor = new TextField();
        Label labPoruka = new Label("Poruka");
        TextField tfPoruka = new TextField();
        Label labDatum = new Label("Datum");
        TextField tfDatum = new TextField();
        vbLeft.getChildren().addAll(labAutor, tfAutor, labPoruka, tfPoruka, labDatum, tfDatum);

        // VBRight
        VBox vbRight = new VBox(10);
        RadioButton rb1 = new RadioButton("Nova funkcionalnost");
        RadioButton rb2 = new RadioButton("Ispravljen bag");
        RadioButton rb3 = new RadioButton("Baterija testova");
        ToggleGroup tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        rb1.setSelected(true);
        Button btDodaj = new Button("Dodaj");
        vbRight.getChildren().addAll(rb1, rb2, rb3, btDodaj);

        hbBottom.getChildren().addAll(vbLeft, vbRight);

        root.getChildren().addAll(hbTop, taLog, hbBottom);

        btUcitaj.setOnAction(e -> {
            izmene.clear();
            taLog.clear();
            Izmena.postaviSledeciId(1);

            try {
                List<String> linije = Files.readAllLines(Paths.get("izmene.txt"));
                for (String linija: linije) {
                    System.out.println("Parsiram '" + linija + "'");
                    String[] tokeni = linija.split(",");
                    String tip = tokeni[0].trim();
                    String autor = tokeni[1].trim();
                    int id = Integer.parseInt(tokeni[2].trim());
                    System.out.println("id=" + id);
                    String datum = tokeni[3].trim();
                    String poruka = tokeni[4].trim();

                    System.out.println();

                    Zaglavlje z = new Zaglavlje(autor, datum);

                    Izmena i = null;
                    if (tip.equals("ir")) {
                        // IzmenaRegularna
                        int tipIzmene = Integer.parseInt(tokeni[5].trim());
                        i = new IzmenaRegularna(z, poruka, id, TipRegularneIzmene.izBroja(tipIzmene));
                        izmene.add(i);
                    } else if (tip.equals("iz")) {
                        // IzmenaZahtev
                        i = new IzmenaZahtev(z, poruka, id);
                        izmene.add(i);
                    } else if (tip.equals("ipz")) {
                        // IzmenaPrihvatanjeZahteva
                        int idZahteva = Integer.parseInt(tokeni[5].trim());
                        i = new IzmenaPrihvatanjeZahteva(z, poruka, id, idZahteva);
                        izmene.add(i);
                    } else {
                        System.out.println("Greska pri parsiranju linije '" + linija + "'");
                    }
                }

                izmene.sort((i1, i2) -> Integer.compare(i2.getId(), i1.getId()));

                azurirajIzmene(taLog);

                // Azuriramo poslednji dostupni id
                int poslednjId = izmene.get(0).getId();
                Izmena.postaviSledeciId(poslednjId + 1);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        btDodaj.setOnAction(e -> {
            String autor, datum, poruka;
            if (tfAutor.getText().isEmpty() || tfDatum.getText().isEmpty() || tfDatum.getText().isEmpty())
                return;
            autor = tfAutor.getText().trim();
            datum = tfDatum.getText().trim();
            poruka = tfPoruka.getText().trim();

            Zaglavlje z = new Zaglavlje(autor, datum);

            // Proveravamo tip za izmenu
            TipRegularneIzmene tipRegularneIzmene;
            if (rb1.isSelected()) tipRegularneIzmene = TipRegularneIzmene.NovaFunkcionalnost;
            else if (rb2.isSelected()) tipRegularneIzmene = TipRegularneIzmene.IspravljenBag;
            else if (rb3.isSelected()) tipRegularneIzmene = TipRegularneIzmene.BaterijaTestova;
            else {
                System.out.println("Problem pri odabiru radio button komponente.");
                return;
            }

            Izmena i = new IzmenaRegularna(z, poruka, tipRegularneIzmene);
            izmene.add(0, i);
            azurirajIzmene(taLog);
        });

        btSacuvaj.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            izmene.forEach(i -> sb.append(i.serijalizuj()).append('\n'));
            Path outputPath = Paths.get("izmene.txt");

            // Ne mora se pisati u datoteku na ovaj nacin, u redu je bilo koje
            // resenje koje niz serijalizovanih vrednosti upise u datoteku.
            // Na primer moze se generisat List<String> umesto String i slicno.
            // U ovom resenju je odabrano .getBytes() kao primer kako se 1 String
            // moze upisati u datoteku :)

            try {
                Files.write(outputPath, sb.toString().getBytes());
                taLog.setText("Podaci sacuvani u izmene.txt");
            } catch (IOException ex) {
                System.out.println("Neuspelo pisanje!");
            }
        });

        Scene scene = new Scene(root, 500, 800);
        stage.setScene(scene);
        stage.setTitle("The Tig");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
