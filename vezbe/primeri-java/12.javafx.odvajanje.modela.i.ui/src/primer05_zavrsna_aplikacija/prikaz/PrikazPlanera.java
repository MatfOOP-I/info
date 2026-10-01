package primer05_zavrsna_aplikacija.prikaz;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    private final ChoiceBox<Prioritet> izborPrioriteta =
            new ChoiceBox<>();
    private final ListView<String> listaZadataka =
            new ListView<>();
    private final Label poruka = new Label();

    public PrikazPlanera(KontrolerZadataka kontroler) {
        this.kontroler = kontroler;

        izborPrioriteta.getItems().addAll(Prioritet.values());
        izborPrioriteta.setValue(Prioritet.SREDNJI);

        unosOpisa.setPromptText("Opis zadatka");
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
        koren.setCenter(centar);

        osveziPrikaz();

        return koren;
    }

    private void dodajZadatak() {
        RezultatOperacije rezultat =
                kontroler.dodajZadatak(
                        unosOpisa.getText(),
                        izborPrioriteta.getValue()
                );

        poruka.setText(rezultat.getPoruka());

        if (rezultat.isUspesno()) {
            unosOpisa.clear();
            osveziPrikaz();
        }
    }

    private void zavrsiZadatak() {
        int indeks =
                listaZadataka.getSelectionModel().getSelectedIndex();

        RezultatOperacije rezultat =
                kontroler.zavrsiZadatak(indeks);

        poruka.setText(rezultat.getPoruka());

        if (rezultat.isUspesno()) {
            osveziPrikaz();
        }
    }

    private void ukloniZadatak() {
        int indeks =
                listaZadataka.getSelectionModel().getSelectedIndex();

        RezultatOperacije rezultat =
                kontroler.ukloniZadatak(indeks);

        poruka.setText(rezultat.getPoruka());

        if (rezultat.isUspesno()) {
            osveziPrikaz();
        }
    }

    /**
     * Formatiranje je odluka prikaza, ne modela.
     */
    private void osveziPrikaz() {
        listaZadataka.getItems().clear();

        for (Zadatak zadatak : kontroler.getZadaci()) {
            listaZadataka.getItems().add(
                    formatiraj(zadatak)
            );
        }
    }

    private String formatiraj(Zadatak zadatak) {
        String oznaka =
                zadatak.isZavrsen() ? "✓" : " ";

        return String.format(
                "[%s] %-7s | %s",
                oznaka,
                zadatak.getPrioritet(),
                zadatak.getOpis()
        );
    }
}
