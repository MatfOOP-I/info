package rs.math.oop1.z200207.oblici.z01.crtanjeOblika;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * Changing Text Fonts
 *
 * @author cdea
 */
public class PokretanjeOblici extends Application {
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
      final int yOffset = 0;
      // Kubna kriva
      CubicCurve kubnaKriva = FxUtil.build(new CubicCurve(),
            kr -> {
               // start pt (x1,y1)
               kr.setStartX(xOffset + 50);
               kr.setStartY(yOffset + 75);
               // control pt1
               kr.setControlX1(xOffset + 80);
               kr.setControlY1(yOffset -25);
               // control pt2
               kr.setControlX2(xOffset + 110);
               kr.setControlY2(xOffset + 175);
               // end pt (x2,y2)
               kr.setEndX(xOffset +140);
               kr.setEndY(yOffset + 75);
               kr.setStrokeType(StrokeType.CENTERED);
               kr.setStrokeWidth(1);
               kr.setStroke(Color.DARKBLUE);
               kr.setFill(Color.WHITE);
            });
      koren.getChildren().add(kubnaKriva);

      // Sladoled
      final int xOffset2 = -40;
      final int yOffset2 = 50;
      MoveTo pomeriPrema = FxUtil.build(new MoveTo(),
            pp -> {
               pp.setX(xOffset2 +50);
               pp.setY(yOffset2 +150);
            });
      QuadCurveTo cetvornaKrivaPrema = FxUtil.build(new QuadCurveTo(),
            ck -> {
               ck.setX(xOffset2 +150);
               ck.setY(yOffset2 +150);
               ck.setControlX(xOffset2 +100);
               ck.setControlY(yOffset2 +50);
            });
      LineTo linijaPrema1 = FxUtil.build(new LineTo(),
            l -> {
               l.setX(xOffset2 +50);
               l.setY(yOffset2 +150);
            });
      LineTo linijaPrema2 = FxUtil.build(new LineTo(),
            l -> {
               l.setX(xOffset2 +100);
               l.setY(yOffset2 +275);
            });
      LineTo linijaPrema3 = FxUtil.build(new LineTo(),
            l -> {
               l.setX(xOffset2 +150);
               l.setY(yOffset2 +150);
            });
      Path putanja = FxUtil.build(new Path(),
            p -> {
               p.getElements().addAll(pomeriPrema, cetvornaKrivaPrema, linijaPrema1, linijaPrema2, linijaPrema3);
               p.setTranslateX(30);
               p.setStrokeWidth(3);
               p.setStroke(Color.DARKORCHID);
            });
      koren.getChildren().add(putanja);
      primarnaScena.setScene(scena);
      primarnaScena.show();
   }
}