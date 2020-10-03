package rs.math.oop1.z200604.fxmlMVP.z01.osobe.editor;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import rs.math.oop1.z200604.fxmlMVP.z01.osobe.model.DataModel;

public class EditorController {

    @FXML
    private TextField firstNameField ;
    @FXML
    private TextField lastNameField ;
    @FXML
    private TextField emailField ;

    private DataModel model ;

    public void initModel(DataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model ;
        model.currentPersonProperty().addListener((obs, oldPerson, newPerson) -> {
            if (oldPerson != null) {
                firstNameField.textProperty().unbindBidirectional(oldPerson.imeProperty());
                lastNameField.textProperty().unbindBidirectional(oldPerson.prezimeProperty());
                emailField.textProperty().unbindBidirectional(oldPerson.emailProperty());
            }
            if (newPerson == null) {
                firstNameField.setText("");
                lastNameField.setText("");
                emailField.setText("");
            } else {
                firstNameField.textProperty().bindBidirectional(newPerson.imeProperty());
                lastNameField.textProperty().bindBidirectional(newPerson.prezimeProperty());
                emailField.textProperty().bindBidirectional(newPerson.emailProperty());
            }
        });
    }
}