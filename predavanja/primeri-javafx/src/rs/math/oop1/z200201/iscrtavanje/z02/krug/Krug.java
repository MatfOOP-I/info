package rs.math.oop1.z200201.iscrtavanje.z02.krug;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Krug extends Application {
   @Override
   public void start(Stage etapa) {
      Group koren = FxUtil.build(new Group(),
            gr -> {
               gr.getChildren().addAll(new Circle(50.0f, 50.0f, 50.0f, Color.RED));
            });
      Scene scena = FxUtil.build(new Scene(koren, 100, 100),
            sc -> {
               sc.setRoot(koren);
               sc.setCursor(Cursor.HAND);
            });
      etapa.setScene(scena);
      etapa.show();
   }

   public static void main(String a[]) {
      Application.launch(a);
   }
}
