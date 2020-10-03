package pokemoni;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PokemonArena extends Application {
    private static final String separator = "------------------------------------------------------------------------\n";
    public static void main(String[] args) {
        launch(args);
    }

    private static List<Pokemon> pokemoni = new ArrayList<>();
    private static Pokemon pokemon1 = null;
    private static Pokemon pokemon2 = null;

    public static void ucitaj() {
        try {
            List<String> linije = Files.readAllLines(Paths.get("pokemoni.txt"));
            for (String linija: linije) {
                String[] tokeni = linija.split(",");
                System.out.println(Arrays.toString(tokeni));
                String tip = tokeni[0].trim();
                String ime = tokeni[1].trim();
                int nivo = Integer.parseInt(tokeni[2].trim());
                String imeMagije1 = tokeni[3].trim();
                int snaga1 = Integer.parseInt(tokeni[4].trim());
                String imeMagije2 = tokeni[5].trim();
                int snaga2 = Integer.parseInt(tokeni[6].trim());
                if (tip.equals("p")) {
                    pokemoni.add(new Igrac(ime, nivo, new Magija(snaga1, imeMagije1), new Magija(snaga2, imeMagije2)));
                } else if (tip.equals("n")) {
                    pokemoni.add(new Neprijatelj(ime, nivo, new Magija(snaga1, imeMagije1), new Magija(snaga2, imeMagije2)));
                } else {
                    System.out.println("Ovo ne sme da se desi! tip=" + tip);
                }

            }
        } catch (IOException e) {
            System.out.println("Datoteka nije uspesno ucitana!");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10 , 10, 10, 10));
        Button btUcitaj = new Button("Ucitaj");
        TextArea taPokemoni = new TextArea();
        TextArea taBorba = new TextArea();

        RadioButton rbMagija1 = new RadioButton("Magija 1");
        rbMagija1.setSelected(true);
        RadioButton rbMagija2 = new RadioButton("Magija 2");
        Button btIzaberiMagiju = new Button("Izaberi magiju");
        ToggleGroup tg = new ToggleGroup();
        rbMagija1.setToggleGroup(tg);
        rbMagija2.setToggleGroup(tg);
        Button btSimuliraj = new Button("Simuliraj");

        HBox hbBottom = new HBox(10);
        hbBottom.getChildren().addAll(btIzaberiMagiju, btSimuliraj);

        btUcitaj.setOnAction(e -> {
            ucitaj();
            Collections.sort(pokemoni);

            for (Pokemon p: pokemoni)
                taPokemoni.appendText(p + "\n");

            // Biramo pokemone
            pokemon1 = pokemoni.get(0);

            // Trazimo prvog koji je neprijateljski
            for (Pokemon p: pokemoni) {
                if (p instanceof Neprijatelj) {
                    pokemon2 = p;
                    break;
                }
            }
            if (pokemon2 == null) {
                System.out.println("Ovo ne sme da se desi! :)");
            }

            rbMagija1.setText(pokemon1.getMagija1().toString());
            rbMagija2.setText(pokemon1.getMagija2().toString());

            taPokemoni.appendText("\nIzabrani pokemoni:\n" + pokemon1 + "\n");
            taPokemoni.appendText(pokemon2 + "\n");
        });

        btIzaberiMagiju.setOnAction(e -> {
            if (rbMagija1.isSelected()) {
                ((Igrac)pokemon1).setIzabranaMagija(1);
                System.out.println("Izabrana je magija 1");
                taBorba.appendText("[igrac] Bira magiju " + pokemon1.getMagija1() + "\n");
                taBorba.appendText(separator);
            } else if (rbMagija2.isSelected()) {
                ((Igrac)pokemon1).setIzabranaMagija(2);
                System.out.println("Izabrana je magija 2");
                taBorba.appendText("[igrac] Bira magiju " + pokemon1.getMagija2() + "\n");
                taBorba.appendText(separator);
            } else {
                System.out.println("Ovo ne sme da se desi! :D");
            }
        });

        btSimuliraj.setOnAction(e -> {
            // Proveravamo da li je neko nastradao
            if (pokemon1.getZivot() <= 0) {
                taBorba.appendText("Pobedio je CPU\n");
            } else if (pokemon2.getZivot() <= 0) {
                taBorba.appendText("Pobedio je igrac\n");
            } else {
                pokemon1.baciMagiju(pokemon2);
                pokemon2.baciMagiju(pokemon1);
                taBorba.appendText("[igrac] " + pokemon1 + " je bacio " + pokemon1.getPoslednjaBacena() + "\n");
                taBorba.appendText("[cpu] " + pokemon2 + " je bacio " + pokemon2.getPoslednjaBacena() + "\n");
                taBorba.appendText("[igrac] " + pokemon1.getZivot() + "%\n");
                taBorba.appendText("[cpu] " + pokemon2.getZivot() + "%\n");
                taBorba.appendText(separator);
            }
        });

        root.getChildren().addAll(btUcitaj, taPokemoni, taBorba, rbMagija1, rbMagija2, hbBottom);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Pokemon Arena");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
