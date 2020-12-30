import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main extends Application {
    private static Bolnica bolnica = new Bolnica();
    private static Random random = new Random();
    private static boolean ucitano = false;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox root = new HBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        VBox vbLevi = new VBox(10);
        VBox vbDesni = new VBox(10);

        root.getChildren().addAll(vbLevi, vbDesni);

        Button btUcitaj = new Button("Ucitaj pacijente");
        Button btSledeci = new Button("Sledeci");
        Label lbBrojDana = new Label("Broj dana:");
        TextField tfBrojDana = new TextField();
        Button btUbrzajVreme = new Button("Ubrzaj vreme!");
        Label lbGreska = new Label("Greska!");
        lbGreska.setVisible(false);
        lbGreska.setTextFill(Color.RED);
        RadioButton rbSve = new RadioButton("Sve");
        RadioButton rbKorona = new RadioButton("Korona");
        Button btnStatistika = new Button("Prikazi statistike");
        ToggleGroup tg = new ToggleGroup();
        rbSve.setToggleGroup(tg);
        rbKorona.setToggleGroup(tg);
        rbSve.setSelected(true);
        Button btnUnesi = new Button("Unesi");

        vbLevi.getChildren().addAll(btUcitaj, btSledeci, lbBrojDana, tfBrojDana, btUbrzajVreme, lbGreska, rbSve, rbKorona, btnStatistika, btnUnesi);

        Label lbCekaju = new Label("Cekaju:");
        TextArea taCekaju = new TextArea();
        taCekaju.setEditable(false);
        Label lbIzolacija = new Label("U izolaciji:");
        TextArea taIzolacija = new TextArea();
        taIzolacija.setEditable(false);
        Label lbZdravi = new Label("Zdravi:");
        TextArea taZdravi = new TextArea();
        taZdravi.setEditable(false);

        vbDesni.getChildren().addAll(lbCekaju, taCekaju, lbIzolacija, taIzolacija, lbZdravi, taZdravi);

        btUcitaj.setOnAction(e -> {

            if (ucitano)
                return;

            bolnica.ucitaj();
            ucitano = true;
            Collections.sort(bolnica.getCekaonica());
            ispisiListUTextArea(bolnica.getCekaonica(), taCekaju);

        });

        btSledeci.setOnAction(e -> {
            if(bolnica.getCekaonica().isEmpty()){
                taCekaju.clear();
                taCekaju.appendText("Niko ne ceka!");
                return;
            }

            bolnica.sledeci();
            ispisiListUTextArea(bolnica.getCekaonica(), taCekaju);
            ispisiListUTextArea(bolnica.getIzolacija(), taIzolacija);
            ispisiListUTextArea(bolnica.getZdravi(), taZdravi);
        });

        btUbrzajVreme.setOnAction(e -> {
            try {
                int brDana = Integer.parseInt(tfBrojDana.getText());
                if(brDana <= 0){
                    lbGreska.setVisible(true);
                    tfBrojDana.clear();
                    return;
                }
                lbGreska.setVisible(false);

                for(Pacijent p : bolnica.getIzolacija()){
                    p.leci(brDana);
                }
                for (int i = 0; i < bolnica.getIzolacija().size(); i++) {
                    if(bolnica.getIzolacija().get(i).izlecen()){
                        bolnica.getZdravi().add(bolnica.getIzolacija().get(i));
                    }
                }
                bolnica.setIzolacija(bolnica.getIzolacija().stream()
                        .filter(pacijentIzolacija ->  !pacijentIzolacija.izlecen())
                        .collect(Collectors.toList()));

                ispisiListUTextArea(bolnica.getIzolacija(), taIzolacija);
                ispisiListUTextArea(bolnica.getZdravi(), taZdravi);

            }
            catch (NumberFormatException ex){
                lbGreska.setVisible(true);
            }
        });

        btnStatistika.setOnAction(e -> {
            long brojPacijenata, brojZarazenih, brojIzlecenih;

            if (rbSve.isSelected()) {
                brojIzlecenih = + bolnica.getZdravi().stream()
                        .filter(Pacijent::isZarazen)
                        .count();
                brojZarazenih = bolnica.getIzolacija().size();
                brojPacijenata = brojZarazenih + bolnica.getZdravi().size();

                taIzolacija.appendText("\nProcenat zarazenih u odnosu na broj testiranih: " + (100.0 * brojZarazenih / brojPacijenata ) + "%\n");
                taZdravi.appendText("\nProcenat izlecenih u odnosu na broj zarazenih: " + (100.0 * brojIzlecenih / (brojZarazenih+brojIzlecenih)) + "%\n");
            }
            else {
                brojZarazenih = bolnica.getIzolacija().stream()
                        .filter(p -> p.getDijagnoza() instanceof Korona)
                        .count();
                brojIzlecenih = bolnica.getZdravi().stream()
                        .filter(p -> p.getDijagnoza() instanceof Korona && p.isZarazen())
                        .count();

                taIzolacija.appendText("\nProcenat zarazenih u odnosu na broj testiranih: " + (100.0 * brojZarazenih / Korona.getBrojTestiranih()) + "%\n");
                taZdravi.appendText("\nProcenat izlecenih u odnosu na broj zarazenih: " + (100.0 * brojIzlecenih / (brojZarazenih+brojIzlecenih)) + "%\n");
            }
        });

        btnUnesi.setOnAction(e -> bolnica.unesi());

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Bolnica");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static <T> void ispisiListUTextArea(List<T> lista, TextArea ta){
        ta.clear();
        for(T x : lista){
            ta.appendText(x + "\n");
        }
    }

}
