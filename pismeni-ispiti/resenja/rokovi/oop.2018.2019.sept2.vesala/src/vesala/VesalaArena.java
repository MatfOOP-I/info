package vesala;

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
import java.util.List;
import java.util.Random;

public class VesalaArena extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private LjudskiIgrac i1;
    private KompjuterskiIgrac i2;
    private List<Rec> recnik;
    private int naRedu = 0;
    private Rec trazenaRec;

    private void ispisiRecIIsprobanaSlova(TextArea taPoljeZaIgru){
        taPoljeZaIgru.clear();
        taPoljeZaIgru.appendText("Trazena Rec:\n");
        taPoljeZaIgru.appendText(trazenaRec.pogodjenaSlovaReci());
        taPoljeZaIgru.appendText("\n\n");
        if (!trazenaRec.getIsprobanaSlova().isEmpty()){
            taPoljeZaIgru.appendText("Isprobana slova:\n");
            for (int i = 0; i < trazenaRec.getIsprobanaSlova().size(); i++) {
                taPoljeZaIgru.appendText(trazenaRec.getIsprobanaSlova().get(i).toString());
                if ( i < trazenaRec.getIsprobanaSlova().size()-1)
                    taPoljeZaIgru.appendText(", ");
            }
            taPoljeZaIgru.appendText("\n\n");
        }
    }

    private void ispisiImeIgracaNaRedu(TextArea taPoljeZaIgru) {
        taPoljeZaIgru.appendText("Na redu je igrac: ");
        if (naRedu == 0)
            taPoljeZaIgru.appendText(i1.getIme());
        else
            taPoljeZaIgru.appendText(i2.getIme());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        i1 = new LjudskiIgrac("Marko", 0, 0, 0);
        i2 = new KompjuterskiIgrac("Deep Blue", 9, 24, 36);
        recnik = new ArrayList<>();

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Button btnUnesiteReci = new Button("Unesite reci");
        TextArea taReci = new TextArea();

        HBox hbNewGame = new HBox(10);
        Button btnNewGame = new Button("Zapocnite igru");
        ToggleGroup tgTezina = new ToggleGroup();
        RadioButton rbLako = new RadioButton("Lako");
        RadioButton rbSrednje = new RadioButton("Srednje");
        RadioButton rbTesko = new RadioButton("Tesko");
        rbLako.setToggleGroup(tgTezina);
        rbSrednje.setToggleGroup(tgTezina);
        rbTesko.setToggleGroup(tgTezina);
        hbNewGame.setPadding(new Insets(10, 10, 10,30));

        hbNewGame.getChildren().addAll(btnNewGame, rbLako, rbSrednje, rbTesko);

        HBox hbUnesiteSlovo = new HBox(10);
        Button btnUnesiteSlovo = new Button("Unesite slovo");
        TextField tfSlovo = new TextField();

        hbUnesiteSlovo.getChildren().addAll(btnUnesiteSlovo, tfSlovo);

        Button btnOdigrajPotez = new Button("Odigraj potez");
        TextArea taPoljeZaIgru = new TextArea();

        root.getChildren().addAll(btnUnesiteReci, taReci, hbNewGame, hbUnesiteSlovo, btnOdigrajPotez, taPoljeZaIgru);

        btnUnesiteReci.setOnAction(event -> {
            Path ulaznaPutanja = Paths.get("recnik.txt");

            try {
                List<String> linije = Files.readAllLines(ulaznaPutanja);
                recnik.clear();
                for (String linija : linije) {
                    String reci[] = linija.trim().split(",");
                    recnik.add(new Rec(reci[0].trim(), reci[1].trim()));
                }
            } catch (IOException e) {
                System.out.println("Nije uspelo citanje iz datoteke!");
            }

            recnik.sort((rec1, rec2) -> {
                if (rec1.getTezina() != rec2.getTezina())
                    return Integer.compare(rec1.getTezina(), rec2.getTezina());
                else
                    return rec1.getRec().compareTo(rec2.getRec());
            });

            taReci.clear();
            for (Rec rec : recnik)
                taReci.appendText(rec + "\n");
        });

        btnNewGame.setOnAction(event -> {
            int tezina = 0;
            if(rbLako.isSelected())
                tezina = 1;
            else if(rbSrednje.isSelected())
                tezina = 2;
            else
                tezina = 3;

            int minIndRecnik = 0;
            int maxIndRecnik = 0;
            for (int i = 0; i < recnik.size(); i++) {
                if (recnik.get(i).getTezina()==tezina){
                    minIndRecnik = i;
                    break;
                }
            }

            for (int i = recnik.size()-1; i >= 0; i--) {
                if (recnik.get(i).getTezina()==tezina){
                    maxIndRecnik = i;
                    break;
                }
            }

            Random random = new Random();
            int randWordInd = minIndRecnik + random.nextInt(maxIndRecnik-minIndRecnik+1);

            trazenaRec = recnik.get(randWordInd);
            ispisiRecIIsprobanaSlova(taPoljeZaIgru);
            ispisiImeIgracaNaRedu(taPoljeZaIgru);
        });

        btnUnesiteSlovo.setOnAction(event -> {
            i1.setIzabranoSlovo(tfSlovo.getCharacters().toString().trim().charAt(0));
        });

        btnOdigrajPotez.setOnAction(event -> {
            Igrac trenutniIgrac;
            if (naRedu == 0) {
                trenutniIgrac = i1;
                naRedu = 1;
            }
            else {
                trenutniIgrac = i2;
                naRedu = 0;
            }
            char odabranoSlovo = trenutniIgrac.odaberiSlovo(trazenaRec);
            trazenaRec.dodajIsprobanoSlovo(odabranoSlovo);
            ispisiRecIIsprobanaSlova(taPoljeZaIgru);
            if (trazenaRec.getRec().indexOf(odabranoSlovo) != -1) {
                taPoljeZaIgru.appendText("Uspesno pronadjeno slovo " + odabranoSlovo + "!\n\n");
                naRedu = (naRedu+1) % 2;
            }

            if (trazenaRec.getRec().equals(trazenaRec.pogodjenaSlovaReci())) {
                taPoljeZaIgru.appendText("Pobedio je " + trenutniIgrac.getIme());
                return;
            }
            ispisiImeIgracaNaRedu(taPoljeZaIgru);

            if (trazenaRec.getIsprobanaSlova().size() == 6) {
                taPoljeZaIgru.appendText("\n\n" + trazenaRec.getNagovestaj());
            }
        });
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
