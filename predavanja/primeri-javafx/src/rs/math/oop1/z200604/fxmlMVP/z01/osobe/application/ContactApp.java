package rs.math.oop1.z200604.fxmlMVP.z01.osobe.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import rs.math.oop1.z200604.fxmlMVP.z01.osobe.editor.EditorController;
import rs.math.oop1.z200604.fxmlMVP.z01.osobe.list.ListController;
import rs.math.oop1.z200604.fxmlMVP.z01.osobe.menu.MenuController;
import rs.math.oop1.z200604.fxmlMVP.z01.osobe.model.DataModel;

public class ContactApp extends Application {

   @Override
   public void start(Stage primaryStage) throws Exception {

      BorderPane root = new BorderPane();
      FXMLLoader listLoader = new FXMLLoader(getClass().getResource(
            "/rs/math/oop1/z200604/fxmlMVP/z01/osobe/list/list.fxml"));
      root.setCenter(listLoader.load());
      ListController listController = listLoader.getController();

      FXMLLoader editorLoader = new FXMLLoader(getClass().getResource(
            "/rs/math/oop1/z200604/fxmlMVP/z01/osobe/editor/editor.fxml"));
      root.setRight(editorLoader.load());
      EditorController editorController = editorLoader.getController();

      FXMLLoader menuLoader = new FXMLLoader(getClass().getResource(
            "/rs/math/oop1/z200604/fxmlMVP/z01/osobe/menu/menu.fxml"));
      root.setTop(menuLoader.load());
      MenuController menuController = menuLoader.getController();

      DataModel model = new DataModel();
      listController.initModel(model);
      editorController.initModel(model);
      menuController.initModel(model);

      Scene scene = new Scene(root, 800, 600);
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   // annoying Eclipse launch workaround:
   public static void main(String[] args) {
      launch(args);
   }
}