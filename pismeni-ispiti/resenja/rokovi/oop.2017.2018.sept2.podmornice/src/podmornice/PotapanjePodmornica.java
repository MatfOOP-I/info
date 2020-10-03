package podmornice;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.Scanner;

public class PotapanjePodmornica extends Application {

    private Igrac c, r;
    private int pobedeR, pobedeC;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Button btnInit = new Button("Inicijalizuj igru");
        Label lblPotezi = new Label("Istorija poteza:");
        TextArea taPotezi = new TextArea();

        HBox hb = new HBox(10);
        Button btnPotez = new Button("Odigraj potez");

        Label lblX = new Label("x:");
        TextField tfX = new TextField();
        tfX.setMaxWidth(50);
        Label lblY = new Label("y:");
        TextField tfY = new TextField();
        tfY.setMaxWidth(50);
        hb.getChildren().addAll(lblX, tfX, lblY, tfY, btnPotez);

        Label lblPobede = new Label("Pobede:");

        HBox hbPobede = new HBox(10);
        Label lblC = new Label("C:");
        TextField tfC = new TextField();
        tfC.setMaxWidth(50);
        Label lblR = new Label("R:");
        TextField tfR = new TextField();
        tfR.setMaxWidth(50);
        Button btnSacuvaj = new Button("Sacuvaj");
        hbPobede.getChildren().addAll(lblC, tfC, lblR, tfR, btnSacuvaj);
        root.getChildren().addAll(btnInit, lblPotezi, taPotezi, hb, hbPobede);


        btnInit.setOnAction(event -> {
            c = new Covek();
            r = new Racunar();
            c.setProtivnik(r);
            r.setProtivnik(c);

            taPotezi.setText("Covek:\n");
            for (Podmornica p : c.getPodmornice().keySet())
                taPotezi.appendText(p.toString());

            taPotezi.appendText("\nRacunar:\n");
            for (Podmornica p : r.getPodmornice().keySet())
                taPotezi.appendText(p.toString());

            Path path = Paths.get("pobede.txt");

            try (Scanner sc = new Scanner(path)) {
                String line = "";
                while (sc.hasNextLine()) {
                    line = sc.nextLine();
                }

                String[] tokeni = line.split(" ");
                pobedeC = Integer.parseInt(tokeni[0].trim());
                pobedeR = Integer.parseInt(tokeni[1].trim());

                tfC.setText("" + pobedeC);
                tfR.setText("" + pobedeR);
            } catch (IOException e) {
                taPotezi.setText("Problem sa ucitavnajem");
            }

            taPotezi.appendText("---------------------------------------------------\n");
        });

        btnPotez.setOnAction(event -> {
            int x, y;
            Random random = new Random();
            try {
                x = Integer.parseInt(tfX.getText());
                y = Integer.parseInt(tfY.getText());

                if (x < 0 || x > 9 || y < 0 || y > 9)
                    throw new NumberFormatException();

                Polje k = new Polje(x, y);
                boolean p = c.odigrajPotez(k);
                taPotezi.appendText("Covek gadja " + k + " i " + (p ? "pogadja" : "promasuje") + "!\n");

                if (p && c.pobedio()) {
                    taPotezi.appendText("COVEK JE POBEDIO!\n");
                    tfC.setText("" + (pobedeC + 1));
                    return;
                }

                x = random.nextInt(10);
                y = random.nextInt(10);
                k = new Polje(x, y);
                p = r.odigrajPotez(k);
                taPotezi.appendText("Racunar gadja " + k + " i " + (p ? "pogadja" : "promasuje") + "!\n");

                taPotezi.appendText("---------------------------------------------------\n");

                if (p && r.pobedio()) {
                    taPotezi.appendText("RACUNAR JE POBEDIO!\n");
                    tfR.setText("" + (pobedeR + 1));
                }

            } catch (NumberFormatException e) {
                taPotezi.appendText("Unesite ispravne vrednosti za koordinate!\n");
            }
        });

        btnSacuvaj.setOnAction(event -> {
            int novoC = Integer.parseInt(tfC.getText());
            int novoR = Integer.parseInt(tfR.getText());

            if (novoC != pobedeC || novoR != pobedeR) {
                Path path = Paths.get("pobede.txt");

                try {
                    String s = "\n" + novoC + " " + novoR;
                    Files.write(path, s.getBytes(), StandardOpenOption.APPEND);
                } catch (IOException e) {
                    taPotezi.setText("Greska pri cuvanju rezultata!");
                }

            }
        });

        primaryStage.setScene(new Scene(root, 300, 350));
        primaryStage.setTitle("Potapanje podmornica");
        primaryStage.show();
    }
}
