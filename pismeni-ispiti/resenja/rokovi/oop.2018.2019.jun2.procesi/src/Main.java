import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Main extends Application {

    private MenadzerProcesa mp;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox(10);

        VBox vbLeft = new VBox(10);
        TextArea ta = new TextArea();
        ta.setEditable(false);
        ta.setMaxWidth(400);
        ta.setMinHeight(400);
        TextField tf = new TextField();
        tf.setMaxWidth(300);
        vbLeft.getChildren().add(ta);

        Button btnIzlistaj = new Button("Izlistaj");
        btnIzlistaj.setOnAction(e -> {
            if (this.mp == null) {
                this.mp = new MenadzerProcesa();
                if (!this.mp.ucitajProcese("procesi.txt"))
                    ta.appendText("Neuspelo ucitavanje!");
            }

            List<Proces> procesi = this.mp.getProcesi();
            procesi.sort((p1, p2) -> {
                if (p1 instanceof AktivanProces && !(p2 instanceof AktivanProces))
                    return -1;
                else if (p2 instanceof AktivanProces && !(p1 instanceof AktivanProces))
                    return 1;
                else
                    return 0;
            });

            ta.appendText("\n");
            for (Proces p : procesi)
                ta.appendText(p.toString() + "\n");
        });
        Button btnMemorijskiNajzahtevniji = new Button("Memorijski najzahtevniji");
        btnMemorijskiNajzahtevniji.setOnAction(e -> {
            ta.appendText("\nMemorijski najzahtevniji:\n");
            ta.appendText(this.mp.memorijskiNajzahtevniji(0).toString() + "\n");
        });
        Button btnSistemskiProcesi = new Button("Sistemski procesi");
        btnSistemskiProcesi.setOnAction(e -> {
            StringBuilder sb = new StringBuilder("\nSistemski procesi:\n");
            for (Proces p : this.mp.sistemskiProcesi()) {
                sb.append(p);
                sb.append('\n');
            }
            ta.appendText(sb.toString());
        });
        Button btnCPU = new Button("Ukupna iskoriscenost CPU");
        btnCPU.setOnAction(e -> {
            ta.appendText("\nIskoriscenost CPU: " + this.mp.ukupnaIskoriscenostCPU() + "%\n");
        });
        Button btnKill = new Button("Zaustavi proces");
        btnKill.setOnAction(e -> {
            int pid = -1;
            try {
                pid = Integer.parseInt(tf.getText());
            } catch (NumberFormatException ex) {
                ta.appendText("\nLos pid: " + tf.getText() + "\n");
                return;
            }
            if (this.mp.zaustaviProces(pid))
                ta.appendText("\nZaustavljen proces: " + pid + "\n");
            else
                ta.appendText("\nLos pid: " + pid + "\n");
        });

        VBox vbRight = new VBox(10);
        vbRight.getChildren().addAll(btnIzlistaj, btnMemorijskiNajzahtevniji, btnSistemskiProcesi,
                                btnCPU, tf, btnKill);

        root.getChildren().addAll(vbLeft, vbRight);
        root.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Proces menadzer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
