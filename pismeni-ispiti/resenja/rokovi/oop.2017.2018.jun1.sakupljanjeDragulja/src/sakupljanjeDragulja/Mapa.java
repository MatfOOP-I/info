package sakupljanjeDragulja;

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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mapa extends Application {
    private static List<ObjekatIgre> objekti = new ArrayList<>();
    private static int sakupljenoDragulja = 0;

    public static void main(String[] args) {
        launch(args);
    }

    void ucitaj() {
        try {
            List<String> linije = Files.readAllLines(Paths.get("objekti.txt"));
            for (String linija : linije) {
                String[] tokeni = linija.split(",");
                String tip = tokeni[0].trim();
                String ime = tokeni[1].trim();
                int X = Integer.parseInt(tokeni[2].trim());
                int Y = Integer.parseInt(tokeni[3].trim());
                if (tip.equals("t")) {
                    double maxTezina = Double.parseDouble(tokeni[4].trim());
                    objekti.add(new Tragac(ime, X, Y, new Ranac(maxTezina)));
                } else if (tip.equals("r")) {
                    double tezina = Double.parseDouble(tokeni[4].trim());
                    int vremeTrajanja = Integer.parseInt(tokeni[5].trim());
                    objekti.add(new Rudnik(ime, X, Y, tezina, vremeTrajanja));
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
        root.setPadding(new Insets(10 , 10, 10, 10));
        Button btUcitaj = new Button("Ucitaj");
        TextArea taObjekti = new TextArea();
        TextArea taMapa = new TextArea();

        RadioButton rbDD = new RadioButton("Dole ili Desno(x++ ili y++)");
        RadioButton rbGL = new RadioButton("Gore ili Levo(x-- ili y--)");
        Button btIzaberiSmer = new Button("Izaberi smer");
        ToggleGroup tg = new ToggleGroup();
        rbDD.setToggleGroup(tg);
        rbGL.setToggleGroup(tg);
        Button btSimuliraj = new Button("Simuliraj potez");

        HBox hbBottom = new HBox(10);
        hbBottom.getChildren().addAll(btIzaberiSmer, btSimuliraj);

        btUcitaj.setOnAction(e -> {
            ucitaj();
            Collections.sort(objekti);

            for (ObjekatIgre o: objekti)
                taObjekti.appendText(o + "\n");
        });

        btIzaberiSmer.setOnAction(e -> {
            if (rbDD.isSelected()) {
                Tragac.setSmerKretanja("dd");
            } else if (rbGL.isSelected()) {
                Tragac.setSmerKretanja("gl");
            } else {
                System.out.println("A ni ovo Boga mi ne sme da se desi :P");
            }
        });

        btSimuliraj.setOnAction(e -> {
            // Igranje poteza
            for (ObjekatIgre o : objekti) {
                o.izvrsiAkciju();
            }

            for (ObjekatIgre o : objekti) {
                // Tragaci pokusavaju da sakupe dragulje
                if (o instanceof Tragac) {
                    Tragac t = (Tragac) o;
                    for (ObjekatIgre o2 : objekti) {
                        if (o2 instanceof Rudnik && t.getX() == o2.getX() && t.getY() == o2.getY() && ((Rudnik)o2).isOtvoren()) {
                            if (t.pokupiDragulj((Rudnik) o2)) {
                                sakupljenoDragulja++;
                                taMapa.appendText(t.getNaziv() + " je sakupio " + o2.getNaziv() + "!\n");
                            } else {
                                taMapa.appendText(t.getNaziv()+" ne moze da ponese "+o2.getNaziv()+"!\n");
                            }
                        }
                    }
                }
            }
            taMapa.appendText("Stanje table:\nSakupljeno dragulja: "+sakupljenoDragulja+"\n");
            for (ObjekatIgre o : objekti) {
                taMapa.appendText(o+"\n");
            }
            taMapa.appendText("-----------------------------------------------------------------\n");
        });

        rbDD.setSelected(true);

        root.getChildren().addAll(btUcitaj, taObjekti, taMapa, rbDD, rbGL, hbBottom);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Sakupljanje Dragulja");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
