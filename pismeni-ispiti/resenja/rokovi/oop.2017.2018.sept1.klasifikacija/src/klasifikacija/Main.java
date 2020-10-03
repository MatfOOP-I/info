package klasifikacija;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application
{
    private List<Podatak> podaci;
    private Klasifikator klasifikator;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        Button btUcitajPodatke = new Button("Ucitaj podatke");
        TextArea taKlasifikacija = new TextArea();
        RadioButton rbNasumicni = new RadioButton("Nasumicni klasifikator");
        RadioButton rbKNN = new RadioButton("KNN klasifikator");
        Button btKlasifikuj = new Button("Klasifikuj");
        Label lblSusedi = new Label("Broj suseda");
        TextField tfSusedi = new TextField();
        Label lblGreska = new Label("Preciznost");
        TextField tfGreska = new TextField();
        ToggleGroup tg = new ToggleGroup();

        rbNasumicni.setToggleGroup(tg);
        rbKNN.setToggleGroup(tg);

        root.getChildren().addAll(btUcitajPodatke, taKlasifikacija, rbNasumicni, rbKNN, btKlasifikuj, lblSusedi, tfSusedi, lblGreska, tfGreska);

        btUcitajPodatke.setOnAction(e ->
        {
            taKlasifikacija.clear();
            podaci = Podatak.ucitajPodatke();
            for (Podatak p : podaci)
                taKlasifikacija.appendText(p + "\n");
        });

        btKlasifikuj.setOnAction(e ->
        {
            try
            {
                if (rbNasumicni.isSelected())
                    klasifikator = new NasumicniKlasifikator(podaci);
                else
                        klasifikator = new KSuseda(podaci, Integer.parseInt(tfSusedi.getText()));

                List<Pol> labele = klasifikator.klasifikuj();

                taKlasifikacija.clear();

                for (int i = 0; i < podaci.size(); i++)
                {
                    taKlasifikacija.appendText(podaci.get(i).toString());
                    taKlasifikacija.appendText(" (" + labele.get(i).toString() + ")\n");
                }

                tfGreska.setText("" + klasifikator.greska(labele));
            } catch (NumberFormatException exc)
            {
                tfSusedi.setText("Morate uneti broj suseda za KNN.");
            }
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Klasfikacija");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
