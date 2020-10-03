package rs.ac.bg.matf.oop_p.p20021.poravnanje;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.transform.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;

public class Tekst extends Application
{
  private FlowPane komande;
  private Label ponavljanjeOpis;
  private TextField ponavljanjeVrednost;
  private Label porukaOpis;
  private TextField porukaVrednost;
  private CheckBox obrisiPrePrikaza;
  private Button ispisi;
  private Pane poMeniSePise;

  /**
   * @param args
   *          the command line arguments
   */
  public static void main(String[] args)
  {
    Application.launch(args);
  }

  @Override
  public void start(Stage primarnaScena) throws Exception
  {

    Scene scena = SceneBuilder.create().width(650).height(400)
        .root(kreirajScenu()).build();
    primarnaScena.setTitle("Ponavljanje");
    komande.layoutXProperty().bind(
        primarnaScena.widthProperty().subtract(primarnaScena.widthProperty())
            .add(1));
    komande.layoutYProperty().bind(
        primarnaScena.heightProperty().subtract(primarnaScena.heightProperty())
            .add(1));
    komande.prefWidthProperty()
        .bind(primarnaScena.widthProperty().subtract(18));
    poMeniSePise.layoutXProperty().bind(komande.layoutXProperty());
    poMeniSePise.layoutYProperty().bind(komande.heightProperty().add(1));
    poMeniSePise.prefWidthProperty().bind(komande.widthProperty());
    poMeniSePise.prefHeightProperty().bind(
        primarnaScena.heightProperty().subtract(komande.heightProperty())
            .subtract(40));
    primarnaScena.setScene(scena);
    primarnaScena.show();
  }

  private Parent kreirajScenu()
  {
    Pane rez = PaneBuilder.create().build();
    komande = kreirajKomande();
    poMeniSePise = kreirajPoMeniSePise();
    rez.getChildren().addAll(komande, poMeniSePise);
    return rez;
  }

  private FlowPane kreirajKomande()
  {
    String kaskadniStil = "-fx-border-color: blue;\n"
        + "-fx-border-insets: 2;\n" + "-fx-border-width: 2;\n"
        + "-fx-border-style: dashed;\n";
    FlowPane panel = FlowPaneBuilder.create().alignment(Pos.CENTER).vgap(10)
        .hgap(20).style(kaskadniStil).build();
    porukaOpis = kreirajPorukaOpis();
    porukaVrednost = kreirajPorukaVrednost();
    ponavljanjeOpis = kreirajPonavljanjeOpis();
    ponavljanjeVrednost = kreirajPonavljanjeVrednost();
    obrisiPrePrikaza = kreirajObrisiPrePrikaza();
    ispisi = kreirajDugmeIspisi();
    panel.getChildren().addAll(porukaOpis, porukaVrednost, ponavljanjeOpis,
        ponavljanjeVrednost, obrisiPrePrikaza, ispisi);
    return panel;
  }

  private Label kreirajPorukaOpis()
  {
    Label oznaka = LabelBuilder.create().text("Unesi poruku: ").build();
    return oznaka;
  }

  private TextField kreirajPorukaVrednost()
  {
    TextField polje = TextFieldBuilder.create().prefWidth(160)
        .text("Java FX 2.0").focusTraversable(false).build();
    return polje;
  }

  private Label kreirajPonavljanjeOpis()
  {
    Label oznaka = LabelBuilder.create().text("Broj poruka: ").build();
    return oznaka;
  }

  private TextField kreirajPonavljanjeVrednost()
  {
    TextField polje = TextFieldBuilder.create().prefWidth(60).text("5")
        .focusTraversable(false).build();
    return polje;
  }

  private CheckBox kreirajObrisiPrePrikaza()
  {
    CheckBox poljeZaPotvrdu = CheckBoxBuilder.create()
        .text("Obriši pre prikaza").selected(true).focusTraversable(false)
        .build();
    return poljeZaPotvrdu;
  }

  private Button kreirajDugmeIspisi()
  {
    Button dugme = ButtonBuilder.create().text("Ispisi")
        .onAction(new EventHandler<ActionEvent>()
        {
          public void handle(ActionEvent event)
          {
            int bp = Integer.parseInt(ponavljanjeVrednost.getText());
            boolean opp = obrisiPrePrikaza.isSelected();
            ispisiPoruku(poMeniSePise, porukaVrednost.getText(), bp, opp);
          }
        }).build();
    return dugme;
  }

  private Pane kreirajPoMeniSePise()
  {
    String kaskadniStil = "-fx-border-color: red;\n"
        + "-fx-border-insets: 2;\n" + "-fx-border-width: 2;\n"
        + "-fx-border-style: solid;\n";
    Pane panel = PaneBuilder.create().style(kaskadniStil).build();
    return panel;
  }

  protected void ispisiPoruku(Pane panel, String poruka, int brojPoruka,
      boolean obrisiNaPocetku)
  {
    if (obrisiNaPocetku)
      panel.getChildren().clear();
    double w = panel.getWidth();
    double h = panel.getHeight();
    panel.setClip(new Rectangle(0, 0, w, h));
    Random rand = new Random(System.currentTimeMillis());
    for (int i = 0; i < brojPoruka; i++)
    {
      int x = rand.nextInt((int) w);
      int y = rand.nextInt((int) h);
      int red = rand.nextInt(255);
      int green = rand.nextInt(255);
      int blue = rand.nextInt(255);
      Text tekst = TextBuilder.create().text(poruka).x(x).y(y)
          .rotate(rand.nextInt(360)).fill(Color.rgb(red, green, blue, .99))
          .build();
      panel.getChildren().add(tekst);
    }

  }
}
