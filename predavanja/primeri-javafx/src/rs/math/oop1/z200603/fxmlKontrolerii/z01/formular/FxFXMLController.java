package rs.math.oop1.z200603.fxmlKontrolerii.z01.formular;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FxFXMLController
{
   @FXML
   // The reference of inputText will be injected by the FXML loader
   private TextField inputText;

   // The reference of outputText will be injected by the FXML loader
   @FXML
   private TextArea outputText;

   // location and resources will be automatically injected by the FXML loader
   @FXML
   private URL location;

   @FXML
   private ResourceBundle resources;

   // Add a public no-args constructor
   public FxFXMLController()
   {
   }

   @FXML
   private void initialize()
   {
   }

   @FXML
   private void printOutput()
   {
      outputText.setText(inputText.getText());
   }
}
