package sistemZaPreporucivanje;

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
import java.util.*;

public class Sistem extends Application {

    private Map<ZabavniSadrzaj, List<Integer>> zabavniProgram = new TreeMap<>();
    private Korisnik k = new Korisnik("Pluto");
    private List<ZabavniSadrzaj> preporuceno = new ArrayList<>();
    private static Random rand = new Random();
    private int odabrano;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);

        Button btnUcitaj = new Button("Ucitaj");
        TextArea taPodaci = new TextArea();
        HBox hbOpcije = new HBox(10);
        HBox hbUslov = new HBox(10);
        Label lblPreporuke = new Label("Preporuke:");
        TextArea taPreporuke = new TextArea();
        HBox hbOcena = new HBox(10);

        root.setPadding(new Insets(10));
        root.getChildren().addAll(btnUcitaj, taPodaci, hbOpcije, hbUslov, lblPreporuke, taPreporuke, hbOcena);

        RadioButton rbUslov1 = new RadioButton("Izvodjac/Glumac");
        RadioButton rbUslov2 = new RadioButton("Zanr/Godina");
        ToggleGroup tgUslov = new ToggleGroup();
        rbUslov1.setSelected(true);
        rbUslov1.setToggleGroup(tgUslov);
        rbUslov2.setToggleGroup(tgUslov);
        Button btnPreporuka = new Button("Preporuka");

        hbOpcije.setAlignment(Pos.CENTER);
        hbOpcije.getChildren().addAll(rbUslov1, rbUslov2);

        Label lblUslov = new Label("Unesite uslov pretrage: ");
        TextField tfUslov = new TextField();

        hbUslov.setAlignment(Pos.CENTER);
        hbUslov.getChildren().addAll(lblUslov, tfUslov, btnPreporuka);


        Label lblOcena = new Label("Ocenite sadrzaj: ");
        TextField tfOcena = new TextField();
        Button btnOceni = new Button("Oceni");

        hbOcena.setAlignment(Pos.CENTER);
        hbOcena.getChildren().addAll(lblOcena, tfOcena, btnOceni);


        btnUcitaj.setOnAction(event -> {
            Path input = Paths.get("zabava.txt");

            try (Scanner sc = new Scanner(Files.newBufferedReader(input))) {
                while (sc.hasNextLine()) {
                    String red = sc.nextLine();
                    String[] tokeni = red.split(",");

                    if (tokeni[0].trim().charAt(0) == 'f') {
                        String naziv = tokeni[1].trim();
                        int duzina = Integer.parseInt(tokeni[2].trim());
                        int godina = Integer.parseInt(tokeni[3].trim());
                        String glumac = tokeni[4].trim();
                        List<Integer> ocene = new ArrayList<>();
                        for (int i=5; i<tokeni.length; i++) {
                            ocene.add(Integer.parseInt(tokeni[i].trim()));
                        }

                        zabavniProgram.put(new Film(naziv, duzina, godina, glumac), ocene);
                    }

                    else {
                        String naziv = tokeni[1].trim();
                        int duzina = Integer.parseInt(tokeni[2].trim());
                        String izvodjac = tokeni[3].trim();
                        String zanr = tokeni[4].trim();
                        List<Integer> ocene = new ArrayList<>();
                        for (int i=5; i<tokeni.length; i++) {
                            ocene.add(Integer.parseInt(tokeni[i].trim()));
                        }

                        zabavniProgram.put(new Pesma(naziv, duzina, izvodjac, zanr), ocene);
                    }
                }

                for (Map.Entry<ZabavniSadrzaj, List<Integer>> e : zabavniProgram.entrySet()) {
                    Double avg = e.getValue().stream().mapToInt(a -> a).average().orElse(0.0);
                    taPodaci.appendText(e.getKey().toString() + " " + Math.floor(avg*100)/100 + "\n");
                }

                lblPreporuke.setText("Preporuke:");

            } catch (IOException e) {
                System.err.println("Neuspelo citanje iz datoteke!");
            }

        });

        btnPreporuka.setOnAction(event -> {
            lblPreporuke.setText("Preporuke:");
            int opcija;

            if (rbUslov1.isSelected())
                opcija = 1;
            else
                opcija = 2;

            String uslov = tfUslov.getText();

            taPreporuke.clear();
            preporuceno.clear();
            for (Map.Entry<ZabavniSadrzaj, List<Integer>> e : zabavniProgram.entrySet()) {
                if (e.getKey().zaPreporuku(uslov, opcija, k.getOcenjenSadrzaj().keySet())) {
                    taPreporuke.appendText(e.getKey().toString() + "\n");
                    preporuceno.add(e.getKey());
                }
            }

            if (preporuceno.size() > 0) {
                odabrano = rand.nextInt(preporuceno.size());
                taPreporuke.appendText("\n" + k.getNadimak() + " je odabrao " + preporuceno.get(odabrano).getNaziv());
            }
            else {
                taPreporuke.setText("Nijedan sadržaj ne zadovoljava zadate uslove!");
            }
        });

        btnOceni.setOnAction(event -> {
            tfUslov.clear();

            if (preporuceno.size() == 0) {
                return;
            }

            try {
                int ocena = Integer.parseInt(tfOcena.getText());
                k.oceniSadrzaj(preporuceno.get(odabrano), ocena);
                taPreporuke.clear();

                lblPreporuke.setText("Ocenjen sadrzaj: ");

                for (Map.Entry<ZabavniSadrzaj, Integer> e : k.getOcenjenSadrzaj().entrySet()) {
                    taPreporuke.appendText(e.getKey().toString() + " " + e.getValue() + "\n");
                }

            } catch (NumberFormatException e) {
                taPreporuke.appendText("\nNesipravna vrednost za ocenu!");
                return;
            }

            preporuceno.clear();
            tfOcena.clear();
        });


        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.setTitle("Sistem za preporucivanje");
        primaryStage.show();
    }

}
