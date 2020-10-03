package rs.math.oop1.z200208.transformacije.z02.bojenjePrelivi;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PokretanjeBojenjeOblici extends Application {
   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      Application.launch(args);
   }

   @Override
   public void start(Stage primarnaScena) {
      primarnaScena.setTitle("Bojenje objekata i prelivi");
      Group koren = new Group();
      Scene scena = new Scene(koren, 350, 300, Color.WHITE);
      RadialGradient radijalniPreliv = FxUtil.build(new RadialGradient(
                  0, .1, 80, 45, 120,
                  false, CycleMethod.NO_CYCLE,
                  new Stop(0, Color.RED),
                  new Stop(1, Color.BLACK)),
            rg -> {
            });
      Ellipse elipsa = FxUtil.build(new Ellipse(),
            el -> {
               el.setCenterX(100);
               el.setCenterY(50 + 70 / 2);
               el.setRadiusX(50);
               el.setRadiusY(70 / 2);
               el.setFill(radijalniPreliv);
            });
      koren.getChildren().add(elipsa);

      Line crnaLinija = FxUtil.build(new Line(),
            l -> {
               l.setStartX(170);
               l.setStartY(30);
               l.setEndX(20);
               l.setEndY(140);
               l.setFill(Color.BLACK);
               l.setStrokeWidth(10.0f);
               l.setTranslateY(elipsa.prefHeight(-1) + elipsa.getLayoutY() + 10);
            });
      koren.getChildren().add(crnaLinija);

      LinearGradient linearniPreliv = new LinearGradient(50, 50, 50, 100, false,
            CycleMethod.NO_CYCLE, new Stop(0.1f, Color.rgb(255, 200, 0, .784)),
            new Stop(1.0f, Color.rgb(0, 0, 0, .784)));
      Rectangle pravougaonik = FxUtil.build(new Rectangle(),
            r -> {
               r.setX(50);
               r.setY(50);
               r.setWidth(100);
               r.setHeight(70);
               r.setFill(linearniPreliv);
               r.setTranslateY(elipsa.prefHeight(-1) + elipsa.getLayoutY() + 10);
            });
      koren.getChildren().add(pravougaonik);

      LinearGradient ciklicniPreliv = new LinearGradient(50, 50, 70, 70,
            false, CycleMethod.REFLECT,
            new Stop(0f, Color.rgb(0, 255, 0, .784)),
            new Stop(1.0f, Color.rgb(0, 0, 0, .784)));
      Rectangle zaobljeniPravougaonik = FxUtil.build(new Rectangle(),
            r -> {
               r.setX(50);
               r.setY(50);
               r.setWidth(100);
               r.setHeight(70);
               r.setArcWidth(20);
               r.setArcHeight(20);
               r.setTranslateY(elipsa.prefHeight(-1) + elipsa.getLayoutY() + 10
                     + pravougaonik.prefHeight(-1) + pravougaonik.getLayoutY() + 10);
            });
      zaobljeniPravougaonik.setFill(ciklicniPreliv);
      koren.getChildren().add(zaobljeniPravougaonik);
      primarnaScena.setScene(scena);
      primarnaScena.show();
   }
}
