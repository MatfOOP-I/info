package busplus;

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

import java.util.Collections;
import java.util.List;

public class GSPVoziloGUI extends Application {

    private static GSPVozilo gsp = new GSPVozilo();
    private static List<BusPlus> kartice = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        HBox goreHB = new HBox(10);
        TextArea taL = new TextArea();
        taL.setMinHeight(380);
        taL.setEditable(false);
        TextArea taD = new TextArea();
        taD.setEditable(false);
        taD.setMinHeight(380);
        goreHB.getChildren().addAll(taL, taD);

        HBox doleHB = new HBox(56);
        VBox doleLevo = new VBox(10);
        Button putniciBtn = new Button("Putnici u vozilu");
        HBox noviP = new HBox(10);
        RadioButton personBtn = new RadioButton("Personalizovana");
        RadioButton nepersonBtn = new RadioButton("Nepersonalizovana");
        personBtn.setSelected(true);
        ToggleGroup tg = new ToggleGroup();
        personBtn.setToggleGroup(tg);
        nepersonBtn.setToggleGroup(tg);
        noviP.getChildren().addAll(personBtn, nepersonBtn);
        Button noviPutnikBtn = new Button("Novi putnik");
        doleLevo.getChildren().addAll(putniciBtn, noviP, noviPutnikBtn);

        VBox doleDesno = new VBox(10);
        Button kontrolaBtn = new Button("Kontrola");
        Button izbaciBtn = new Button("Napustanje vozila");
        doleDesno.getChildren().addAll(kontrolaBtn, izbaciBtn);

        doleHB.getChildren().addAll(doleLevo, doleDesno);

        root.getChildren().addAll(goreHB, doleHB);

        putniciBtn.setOnAction(e -> {
            if(gsp == null) {
                taL.setText("Vozilo je u kvaru!\n");
                return;
            }
            if (!gsp.putniciUVozilu("putnici.txt")) {
                taL.setText("Vozilo trenutno bez putnika!\n");
                return;
            }

            prikaziKartice(taL);
        });

        noviPutnikBtn.setOnAction(e -> {
            int vrstaKarte;
            if(personBtn.isSelected())
                vrstaKarte = 1;
            else vrstaKarte = 2;

            BusPlus noviPutnik = gsp.noviPutnik(vrstaKarte);
            taL.appendText("\nNovi putnik u vozilu:\n");
            taL.appendText(noviPutnik.toString()+"\n");
        });

        kontrolaBtn.setOnAction(e -> {
            taD.appendText("Kontrola:\n");
            taD.appendText(gsp.kontrola());
        });

        izbaciBtn.setOnAction(e -> {
            if(gsp.izbaciPutnike()) {
                taD.appendText("\nPutnici sa nevalidnim kartama napustili vozilo.\n");
                taD.appendText("\nU vozilu:\n");
                prikaziKartice(taD);
            }
            else
                taD.appendText("\nSve karte su validne!");
        });

        primaryStage.setTitle("Gradski prevoz");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }

    private static void prikaziKartice(TextArea ta) {
        kartice = gsp.getKartice();
        Collections.sort(kartice);

        for(BusPlus k : kartice) {
            ta.appendText(k.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
