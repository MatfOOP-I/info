package racunari;

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
import java.util.*;

public class FarmaRacunara extends Application {

    private Map<Racunar, List<Integer>> racunari = new TreeMap<>();
    private Korisnik k = new Korisnik("John", 5);
    private Racunar izabrani = null;
    private static Random rand = new Random();

    public static void main(String[] args) {
        launch(args);
    }

    public void ucitaj() {
        try {
            List<String> linije = Files.readAllLines(Paths.get("racunari.txt"));
            for (String linija : linije) {
                String[] tokeni = linija.split(",");
                String tip = tokeni[0].trim();
                String ime = tokeni[1].trim();
                double cenovniKoef = Double.parseDouble(tokeni[2].trim());
                List<Integer> trajanje = new ArrayList<>();

                if (tip.equals("c")) {
                    int velicinaDiska = Integer.parseInt(tokeni[3].trim());
                    boolean backup = tokeni[4].trim().equals("da");

                    for (int i = 5; i < tokeni.length; i++) {
                        trajanje.add(Integer.parseInt(tokeni[i].trim()));
                    }

                    RacunarZaCuvanje c = new RacunarZaCuvanje(ime, cenovniKoef, velicinaDiska,backup);
                    racunari.put(c, trajanje);
                    k.dodajRacunar(c);
                } else if (tip.equals("o")) {
                    int brojProcesora = Integer.parseInt(tokeni[3].trim());

                    for (int i = 4; i < tokeni.length; i++) {
                        trajanje.add(Integer.parseInt(tokeni[i].trim()));
                    }

                    RacunarZaObradu o = new RacunarZaObradu(ime, cenovniKoef, brojProcesora);
                    racunari.put(o, trajanje);
                    k.dodajRacunar(o);
                } else {
                    System.out.println("Ovo ne sme da se desi! tip="+tip);
                }
            }
        } catch (IOException e) {
            System.out.println("Datoteka nije uspesno ucitana!");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10,10,10,10));

        Button btnUcitaj = new Button("Ucitaj");
        TextArea taPodaci = new TextArea();

        HBox hbOpcije = new HBox(10);
        Label lblPrioritet = new Label("Prioritet");
        RadioButton rbStandard = new RadioButton("Standardni");
        RadioButton rbVip = new RadioButton("VIP");
        ToggleGroup tgOpcije = new ToggleGroup();
        rbStandard.setToggleGroup(tgOpcije);
        rbStandard.setSelected(true);
        rbVip.setToggleGroup(tgOpcije);
        hbOpcije.getChildren().addAll(lblPrioritet,rbStandard,rbVip);

        HBox hbKoristi = new HBox(10);
        Label lblIme = new Label("Ime");
        Label lblVreme = new Label("Vreme");
        TextField tfIme = new TextField();
        TextField tfVreme = new TextField();
        Button btnZauzmi = new Button("Koristi");
        hbKoristi.getChildren().addAll(lblIme, tfIme, lblVreme, tfVreme, btnZauzmi);

        Label lblLog = new Label("Log:");
        TextArea taLog = new TextArea();
        Button btnObracunaj = new Button("Obracunaj dugovanja");
        Label lblDug = new Label("Ukupna dugovanja: ");

        root.getChildren().addAll(btnUcitaj, taPodaci, hbOpcije, hbKoristi, lblLog, taLog, btnObracunaj, lblDug);

        btnUcitaj.setOnAction(event -> {
            ucitaj();
            for (Map.Entry<Racunar, List<Integer>> e : racunari.entrySet()) {
                taPodaci.appendText(e.getKey().toString()+" vremena: "+e.getValue()+"\n");
            }
        });

        btnZauzmi.setOnAction(event -> {
            int prioritet, vreme;
            String ime;

            if (rbStandard.isSelected())
                prioritet = 1;
            else
                prioritet = 2;

            if (tfIme.getText().equals("")) {
                taLog.appendText("Unesite ime racunara!\n");
            } else if (tfVreme.getText().equals("")) {
                taLog.appendText("Unesite vreme zauzimanja!\n");
            } else {
                ime = tfIme.getText().trim();
                vreme = Integer.parseInt(tfVreme.getText().trim());

                for (Racunar r : racunari.keySet()) {
                    if (r.getIme().equals(ime))
                        izabrani = r;
                }

                if (izabrani == null) {
                    taLog.appendText("Ne postoji racunar sa trazenim imenom!\n");
                } else {
                    if (prioritet == 1) {
                        if (rand.nextBoolean()) {
                            taLog.appendText(izabrani.getIme() + " je uspesno iskoriscen!\n");
                            racunari.get(izabrani).add(vreme);
                        } else {
                            taLog.appendText(izabrani.getIme() + " je trenutno zauzet, pokusajte malo kasnije!\n");
                        }
                    } else {
                        if (k.getVipKrediti() > 0) {
                            k.umanjiVipKredite();
                            taLog.appendText("[VIP] " + izabrani.getIme() + " je iskoriscen!\n");
                            racunari.get(izabrani).add(vreme);
                        } else {
                            taLog.appendText("Nemate dovoljno VIP kredita!\n");
                        }
                    }
                }
            }

        });

        btnObracunaj.setOnAction(event -> {
            taLog.appendText("------------Obracun dugovanja po racunaru:\n");
            for (Map.Entry<Racunar, List<Integer>> e : racunari.entrySet()) {
                double cena = e.getKey().izracunajCenu(e.getValue());
                k.azurirajDug(e.getKey(), cena);
                taLog.appendText(e.getKey().getIme()+" "+cena+"\n");
            }

            lblDug.setText("Ukupna dugovanja korisnika "+k.getKorisnickoIme()+": "+k.ukupanDug());
        });

        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setTitle("Farma racunara");
        primaryStage.show();
    }
}
