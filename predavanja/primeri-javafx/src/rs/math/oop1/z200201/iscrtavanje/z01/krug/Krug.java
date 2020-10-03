package rs.math.oop1.z200201.iscrtavanje.z01.krug;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Krug extends Application {
   @Override
   public void start(Stage etapa) {
      Group koren = new Group();
      Scene scena = new Scene(koren, 100, 100);

      Circle krug = new Circle(50.0f, 50.0f, 50.0f, Color.RED);

      koren.getChildren().add(krug);
      etapa.setScene(scena);
      etapa.show();
   }

   public static void main(String a[]) {
      Application.launch(a);
   }
}
