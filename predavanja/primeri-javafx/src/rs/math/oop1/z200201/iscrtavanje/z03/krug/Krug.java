package rs.math.oop1.z200201.iscrtavanje.z03.krug;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Krug extends Application {
   @Override
   public void start(Stage etapa) {
      Parent koren = null;
      try {
         koren = FXMLLoader.load(getClass().getResource("krug.fxml"));
      } catch (IOException e) {
         e.printStackTrace();
      }
      etapa.setScene(new Scene(koren));
      etapa.show();
   }

   public static void main(String a[]) {
      Application.launch(a);
   }
}
