package primer05_zavrsna_aplikacija.prikaz;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import primer05_zavrsna_aplikacija.kontroler.KontrolerZadataka;
import primer05_zavrsna_aplikacija.model.ListaZadataka;
import primer05_zavrsna_aplikacija.model.Prioritet;

/**
 * Ulazna tačka JavaFX aplikacije.
 *
 * Ova klasa povezuje model, kontroler i prikaz.
 */
public class PlanerAplikacija extends Application {

    @Override
    public void start(Stage prozor) {
        ListaZadataka model = new ListaZadataka();

        /*
         * Nekoliko početnih podataka samo da prikaz ne bude prazan.
         */
        model.dodaj("Kupiti kartu", Prioritet.VISOK);
        model.dodaj("Pozvati servis", Prioritet.SREDNJI);

        KontrolerZadataka kontroler =
                new KontrolerZadataka(model);

        PrikazPlanera prikaz =
                new PrikazPlanera(kontroler);

        Parent koren = prikaz.napraviPrikaz();

        prozor.setScene(
                new Scene(koren, 620, 440)
        );

        prozor.setTitle("Planer zadataka");
        prozor.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
