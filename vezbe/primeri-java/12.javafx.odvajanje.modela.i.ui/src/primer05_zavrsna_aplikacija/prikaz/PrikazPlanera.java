package primer05_zavrsna_aplikacija.prikaz;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import primer05_zavrsna_aplikacija.kontroler.KontrolerZadataka;
import primer05_zavrsna_aplikacija.kontroler.RezultatOperacije;
import primer05_zavrsna_aplikacija.model.Prioritet;
import primer05_zavrsna_aplikacija.model.Zadatak;

/**
 * JavaFX prikaz.
 *
 * Ova klasa sme da zna za kontrole, layout i formatiranje.
 * Poslovna pravila ne treba da budu ovde.
 */
public class PrikazPlanera {
    private final KontrolerZadataka kontroler;

    private final TextField unosOpisa = new TextField();
    private final ToggleGroup grupaPrioriteta = new ToggleGroup();
    private final HBox izborPrioriteta = new HBox(5);
    private final ListView<String> listaZadataka =
            new ListView<>();
    private final Label poruka = new Label();

    public PrikazPlanera(KontrolerZadataka kontroler) {
        this.kontroler = kontroler;

        unosOpisa.setPromptText("Opis zadatka");

        napraviIzborPrioriteta();
    }

    /**
     * Pravi po jedan RadioButton za svaki prioritet. Sva dugmad su u istoj
     * ToggleGroup, pa u jednom trenutku može biti izabrano samo jedno.
     *
     * Prioritet čuvamo u userData dugmeta, da ga kasnije pročitamo bez
     * poređenja teksta.
     */
    private void napraviIzborPrioriteta() {
        for (Prioritet prioritet : Prioritet.values()) {
            RadioButton dugme = new RadioButton(prioritet.name());
            dugme.setUserData(prioritet);
            dugme.setToggleGroup(grupaPrioriteta);
            izborPrioriteta.getChildren().add(dugme);

            /*
             * Jedno dugme mora biti izabrano od početka. Klik na već
             * izabrani RadioButton ne poništava izbor, pa posle toga
             * uvek postoji izabrani prioritet.
             */
            if (prioritet == Prioritet.SREDNJI) {
                dugme.setSelected(true);
            }
        }
    }

    private Prioritet izabraniPrioritet() {
        Toggle izabrano = grupaPrioriteta.getSelectedToggle();
        return (Prioritet) izabrano.getUserData();
    }

    /**
     * Pravi i vraća kompletan graf JavaFX kontrola.
     */
    public Parent napraviPrikaz() {
        Label naslov = new Label("Planer zadataka");

        Button dodaj = new Button("Dodaj");
        Button zavrsi = new Button("Završi");
        Button ukloni = new Button("Ukloni");

        /*
         * Handler samo:
         *
         * 1. pročita UI;
         * 2. pozove kontroler;
         * 3. prikaže rezultat;
         * 4. osveži prikaz.
         */
        dodaj.setOnAction(dogadjaj -> dodajZadatak());
        zavrsi.setOnAction(dogadjaj -> zavrsiZadatak());
        ukloni.setOnAction(dogadjaj -> ukloniZadatak());

        HBox unos = new HBox(
                10,
                unosOpisa,
                izborPrioriteta,
                dodaj
        );

        HBox akcije = new HBox(
                10,
                zavrsi,
                ukloni
        );

        VBox centar = new VBox(
                10,
                unos,
                listaZadataka,
                akcije,
                poruka
        );

        BorderPane koren = new BorderPane();
        koren.setPadding(new Insets(15));
        koren.setTop(naslov);
        BorderPane.setMargin(naslov, new Insets(0, 0, 10, 0));
        koren.setCenter(centar);

        osveziPrikaz();

        return koren;
    }

    private void dodajZadatak() {
        RezultatOperacije rezultat =
                kontroler.dodajZadatak(
                        unosOpisa.getText(),
                        izabraniPrioritet()
                );

        poruka.setText(rezultat.poruka());

        if (rezultat.uspesno()) {
            unosOpisa.clear();
            osveziPrikaz();
        }
    }

    private void zavrsiZadatak() {
        int indeks =
                listaZadataka.getSelectionModel().getSelectedIndex();

        RezultatOperacije rezultat =
                kontroler.zavrsiZadatak(indeks);

        poruka.setText(rezultat.poruka());

        if (rezultat.uspesno()) {
            osveziPrikaz();
        }
    }

    private void ukloniZadatak() {
        int indeks =
                listaZadataka.getSelectionModel().getSelectedIndex();

        RezultatOperacije rezultat =
                kontroler.ukloniZadatak(indeks);

        poruka.setText(rezultat.poruka());

        if (rezultat.uspesno()) {
            osveziPrikaz();
        }
    }

    /**
     * Formatiranje je odluka prikaza, ne modela.
     */
    private void osveziPrikaz() {
        int izabrani =
                listaZadataka.getSelectionModel().getSelectedIndex();

        List<String> redovi = new ArrayList<>();
        for (Zadatak zadatak : kontroler.getZadaci()) {
            redovi.add(formatiraj(zadatak));
        }
        listaZadataka.getItems().setAll(redovi);

        // setAll poništava izbor; vraćamo ga ako taj indeks još postoji.
        if (izabrani >= 0
                && izabrani < listaZadataka.getItems().size()) {
            listaZadataka.getSelectionModel().select(izabrani);
        }
    }

    private String formatiraj(Zadatak zadatak) {
        String oznaka =
                zadatak.isZavrsen() ? "✓" : " ";

        return String.format(
                "[%s] %s | %s",
                oznaka,
                zadatak.getPrioritet(),
                zadatak.getOpis()
        );
    }
}
