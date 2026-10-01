package primer01_osnove;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Minimalna JavaFX aplikacija.
 *
 * Cilj primera je samo osnovni mentalni model:
 *
 * Application -> Stage -> Scene -> graf JavaFX čvorova.
 */
public class PozdravAplikacija extends Application {

    @Override
    public void start(Stage prozor) {
        Label pitanje = new Label("Kako se zoveš?");
        TextField unosImena = new TextField();
        Button dugme = new Button("Pozdravi");
        Label poruka = new Label();

        /*
         * Event handler se izvršava tek kada korisnik klikne dugme.
         */
        dugme.setOnAction(dogadjaj -> {
            String ime = unosImena.getText().trim();

            if (ime.isEmpty()) {
                poruka.setText("Unesi ime.");
            } else {
                poruka.setText("Zdravo, " + ime + "!");
            }
        });

        VBox koren = new VBox(10);
        koren.setPadding(new Insets(15));
        koren.getChildren().addAll(
                pitanje,
                unosImena,
                dugme,
                poruka
        );

        Scene scena = new Scene(koren, 320, 180);

        prozor.setTitle("Prvi JavaFX primer");
        prozor.setScene(scena);
        prozor.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
