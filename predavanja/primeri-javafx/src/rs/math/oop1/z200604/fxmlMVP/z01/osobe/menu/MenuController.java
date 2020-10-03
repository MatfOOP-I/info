package rs.math.oop1.z200604.fxmlMVP.z01.osobe.menu;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.stage.FileChooser;
import rs.math.oop1.z200604.fxmlMVP.z01.osobe.model.DataModel;

public class MenuController {

    private DataModel model ;

    @FXML
    private MenuBar menuBar ;

    public void initModel(DataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model ;
    }

    @FXML
    public void load() {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(menuBar.getScene().getWindow());
        if (file != null) {
            try {
                model.loadData(file);
            } catch (Exception exc) {
                // handle exception...
            }
        }
    }

    @FXML
    public void save() {

        // similar to load...

    }
    
    @FXML
    public void exit() {
        menuBar.getScene().getWindow().hide();
    }
}
