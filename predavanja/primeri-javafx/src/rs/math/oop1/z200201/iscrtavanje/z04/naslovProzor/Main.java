package rs.math.oop1.z200201.iscrtavanje.z04.naslovProzor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

   @Override
   public void start(Stage primarnaEtapa) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
      primarnaEtapa.setTitle("Hello world!");
      primarnaEtapa.setScene(new Scene(root, 300, 275));
      primarnaEtapa.show();
   }

   public static void main(String[] args) {
      launch(args);
   }
}
