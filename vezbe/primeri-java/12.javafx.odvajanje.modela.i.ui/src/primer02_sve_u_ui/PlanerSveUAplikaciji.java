package primer02_sve_u_ui;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Primer je NAMERNO loše organizovan.
 *
 * Program radi, ali jedna klasa:
 *
 * - pravi UI;
 * - čuva stanje programa;
 * - proverava pravila;
 * - menja podatke;
 * - formatira podatke;
 * - reaguje na događaje.
 *
 * Sledeći primeri služe da ovu odgovornost razdvoje.
 */
public class PlanerSveUAplikaciji extends Application {

    /*
     * Domensko stanje se nalazi direktno u JavaFX klasi.
     */
    private final List<String> zadaci = new ArrayList<>();

    private final ListView<String> lista = new ListView<>();
    private final Label poruka = new Label();

    @Override
    public void start(Stage prozor) {
        TextField unos = new TextField();
        unos.setPromptText("Opis zadatka");

        Button dodaj = new Button("Dodaj");
        Button zavrsi = new Button("Završi izabrani");
        Button ukloni = new Button("Ukloni izabrani");

        dodaj.setOnAction(dogadjaj -> {
            String opis = unos.getText().trim();

            /*
             * Validacija domena živi u UI handleru.
             */
            if (opis.length() < 3) {
                poruka.setText("Opis mora imati bar 3 znaka.");
                return;
            }

            /*
             * UI direktno menja stanje aplikacije.
             */
            zadaci.add(opis);
            unos.clear();
            osveziListu();
            poruka.setText("Zadatak je dodat.");
        });

        zavrsi.setOnAction(dogadjaj -> {
            int indeks = lista.getSelectionModel().getSelectedIndex();

            if (indeks < 0) {
                poruka.setText("Izaberi zadatak.");
                return;
            }

            String zadatak = zadaci.get(indeks);

            if (!zadatak.startsWith("✓ ")) {
                zadaci.set(indeks, "✓ " + zadatak);
            }

            osveziListu();
        });

        ukloni.setOnAction(dogadjaj -> {
            int indeks = lista.getSelectionModel().getSelectedIndex();

            if (indeks >= 0) {
                zadaci.remove(indeks);
                osveziListu();
            }
        });

        HBox dugmad = new HBox(10, dodaj, zavrsi, ukloni);

        VBox koren = new VBox(
                10,
                new Label("Moji zadaci"),
                unos,
                dugmad,
                lista,
                poruka
        );

        koren.setPadding(new Insets(15));

        prozor.setScene(new Scene(koren, 520, 420));
        prozor.setTitle("Planer — loše organizovan primer");
        prozor.show();
    }

    private void osveziListu() {
        lista.getItems().setAll(zadaci);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
