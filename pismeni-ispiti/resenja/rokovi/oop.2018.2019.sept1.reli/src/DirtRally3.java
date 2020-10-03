import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class DirtRally3 extends Application {

    private static ReliRaspored rr;


    public static void main(String[] args) {
        rr = new ReliRaspored();
        rr.ucitaj("raspored.txt");
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox(10);

        VBox vbLeft = new VBox(10);
        TextArea ta = new TextArea();
        ta.setEditable(false);
        ta.setMinWidth(620);
        ta.setMinHeight(410);
        vbLeft.getChildren().add(ta);

        TextField tfIme = new TextField("Ime");
        RadioButton rbA = new RadioButton("Grupa A");
        RadioButton rbB = new RadioButton("Grupa B");
        TextField tfPogon = new TextField("Pogon");
        ToggleGroup tg2 = new ToggleGroup();
        rbA.setToggleGroup(tg2);
        rbB.setToggleGroup(tg2);
        HBox hbKlasa = new HBox(10);
        hbKlasa.getChildren().addAll(rbA, rbB);
        TextField tfModel = new TextField("Model");
        TextField tfGodiste = new TextField("Godiste");
        Label lblSupercharger = new Label("Supercharger:");
        RadioButton rbDa = new RadioButton("Da");
        RadioButton rbNe = new RadioButton("Ne");
        ToggleGroup tg = new ToggleGroup();
        rbDa.setToggleGroup(tg);
        rbNe.setToggleGroup(tg);
        HBox hbSupercharger = new HBox(10);
        hbSupercharger.getChildren().addAll(lblSupercharger, rbDa, rbNe);
        TextField tfH = new TextField("h?");
        TextField tfM = new TextField("m?");

        Button btnIzlistaj = new Button("Izlistaj");
        btnIzlistaj.setOnAction(e -> {
            rr.sortiraj();
            ta.appendText("\n");
            ta.appendText(rr.toString());
            ta.appendText("\n");
        });
        Button btnDodaj = new Button("Dodaj");
        btnDodaj.setOnAction(e -> {
            List<TextField> tfs = Arrays.asList(tfIme, tfGodiste, tfModel, tfPogon, tfH, tfM);
            if (tfs.stream().anyMatch(el -> el.getText().isEmpty())) {
                ta.appendText("\nNeispravan unos\n");
                return;
            }

            int y, h, m;
            try {
                y = Integer.parseInt(tfGodiste.getText());
                h = Integer.parseInt(tfH.getText());
                m = Integer.parseInt(tfM.getText());
            } catch (NumberFormatException ex) {
                ta.appendText("\nNeispravan broj!\n");
                return;
            }

            Pogon p = Pogon.izNiske(tfPogon.getText());
            ReliAuto auto = null;
            if (rbA.isSelected())
                auto = new GrupaAReliAuto(tfModel.getText(), p, y);
            else if (rbB.isSelected())
                auto = new GrupaBReliAuto(tfModel.getText(), p, y, rbDa.isSelected());
            else {
                ta.appendText("\nOdaberite grupu!\n");
                return;
            }

            ReliVozac vozac = new ReliVozac(tfIme.getText(), auto);
            boolean uspeh = rr.dodaj(vozac, h, m);
            ta.appendText("\n" + (uspeh ? "Dodato u " + h + ":" + m : "Konflikt u rasporedu za vreme: " + h + ":" + m) + "\n"); // lazy
        });
        Button btnBroj = new Button("Broj automobila");
        btnBroj.setOnAction(e -> {
            int y;
            try {
                y = Integer.parseInt(tfGodiste.getText());
            } catch (NumberFormatException ex) {
                ta.appendText("\nNeispravan broj!\n");
                return;
            }
            ta.appendText("\nBroj automobila sa godistem vecim od " + y + ": " + rr.brojAutomobilaSaGodistemVecimOd(y) + "\n"); // lazy
        });
        Button btnSaPogonom = new Button("Sa pogonom");
        btnSaPogonom.setOnAction(e -> {
            Pogon p = Pogon.izNiske(tfPogon.getText());
            ta.appendText("\nSa pogonom " + p.toString() + ":\n");
            String s = String.join("\n", rr.saPogonom(p).stream().map(ReliAuto::toString).collect(Collectors.toList()));
            ta.appendText(s + "\n"); // lazy
        });

        VBox vbRight = new VBox(10);
        vbRight.setMaxWidth(270);
        vbRight.getChildren().addAll(
                tfIme, hbKlasa, tfModel, tfPogon, tfGodiste, hbSupercharger, tfH, tfM,
                btnIzlistaj, btnDodaj, btnBroj, btnSaPogonom
        );

        root.getChildren().addAll(vbLeft, vbRight);
        root.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(root);
        primaryStage.setTitle("DiRT Rally 3.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
