package rs.math.oop1.z200402.pano.z01.odgovorNaAkciju;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class PokreniDugmePano extends Application {

   private Button ispisi;
   private Pane poMeniSePise;

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      Application.launch(args);
   }

   @Override
   public void start(Stage primarnaScena) throws Exception {
      Scene scena = new Scene(kreirajScenu(), 600, 400);
      primarnaScena.setTitle("PokreniDugmePano 2");
      primarnaScena.setScene(scena);
      primarnaScena.show();
   }

   private Parent kreirajScenu() {
      ispisi = kreirajDugmeIspisi();
      poMeniSePise = kreirajPanelPoMeniSePise();
      Pane rez = FxUtil.build(new Pane(),
            p -> {
               p.getChildren().add(ispisi);
               p.getChildren().add(poMeniSePise);
            });
      return rez;
   }

   private Button kreirajDugmeIspisi() {
      Button dugme = FxUtil.build(new Button(),
            b -> {
               b.setLayoutX(250);
               b.setLayoutY(20);
               b.setText("Ispisi");
               b.setOnAction(
                     ev -> ispisiPoruku(poMeniSePise)
               );
            });
      return dugme;
   }

   private Pane kreirajPanelPoMeniSePise() {
      Pane panel = FxUtil.build(new Pane(),
            p -> {
               p.setLayoutX(0);
               p.setLayoutY(120);
               p.setPrefHeight(280);
               p.setPrefWidth(600);
            });
      return panel;
   }

   protected void ispisiPoruku(Pane panel) {
      panel.getChildren().clear();
      Random rand = new Random(System.currentTimeMillis());
      for (int i = 0; i < 25; i++) {
         int x = rand.nextInt((int) panel.getWidth());
         int y = rand.nextInt((int) panel.getHeight());
         int red = rand.nextInt(255);
         int green = rand.nextInt(255);
         int blue = rand.nextInt(255);
         Text text = new Text(x, y, "Vado je bio ovde!!!");
         int rot = rand.nextInt(360);
         text.setFill(Color.rgb(red, green, blue, .99));
         text.setRotate(rot);
         panel.getChildren().add(text);
      }
   }
}
