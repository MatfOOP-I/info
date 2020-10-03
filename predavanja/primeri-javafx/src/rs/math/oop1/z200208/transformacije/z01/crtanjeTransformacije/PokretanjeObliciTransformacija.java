package rs.math.oop1.z200208.transformacije.z01.crtanjeTransformacije;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * Changing Text Fonts
 *
 * @author cdea
 */
public class PokretanjeObliciTransformacija extends Application {
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      Application.launch(args);
   }

   @Override
   public void start(Stage primarnaScena) {
      primarnaScena.setTitle("Razni oblici");
      Group koren = new Group();
      Scene scena = new Scene(koren, 550, 850, Color.WHITE);
      final int xOffset = 0;
      final int yOffset = 30;

      // Osmeh
      QuadCurve osmeh = FxUtil.build(new QuadCurve(),
            o -> {
               o.setStartX(50);
               o.setStartY(50);
               o.setEndX(150);
               o.setEndY(50);
               o.setControlX(125);
               o.setControlY(150);
               o.setTranslateX(xOffset);
               o.setTranslateY(yOffset);
               o.setStrokeWidth(3);
               o.setStroke(Color.DARKCYAN);
               o.setFill(Color.WHITE);
            });
      koren.getChildren().add(osmeh);

      // krofna - spoljasnjost
      Ellipse velikiKrug = FxUtil.build(new Ellipse(),
            e -> {
               e.setCenterX(200);
               e.setCenterY(200);
               e.setRadiusX(150);
               e.setRadiusY(75);
               e.setStrokeWidth(10);
               e.setStroke(Color.BLACK);
               e.setFill(Color.WHITE);
            });
      // krofna - rupa
      Ellipse maliKrug = FxUtil.build(new Ellipse(),
            e -> {
               e.setCenterX(200);
               e.setCenterY(200);
               e.setRadiusX(100);
               e.setRadiusY(50);
               e.setStrokeWidth(10);
               e.setStroke(Color.BLACK);
            });
      // napravi krofnu
      Shape krofna = Path.subtract(velikiKrug, maliKrug);
      // prelij je narandzastom glazurom
      krofna.setFill(Color.rgb(255, 200, 0));
      // dodaj senku
      DropShadow senka = new DropShadow();
      senka.setOffsetX(2.0f);
      senka.setOffsetY(2.0f);
      senka.setColor(Color.rgb(60, 60, 60, .588));
      krofna.setEffect(senka);
      // transliraj nanize
      krofna.setTranslateY(osmeh.getBoundsInParent().getMinY() + 30);
      // dodaj u scenu
      koren.getChildren().add(krofna);

      primarnaScena.setScene(scena);
      primarnaScena.show();
   }
}