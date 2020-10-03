package rs.math.oop1.z200604.fxmlMVP.z01.osobe.list;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import rs.math.oop1.z200604.fxmlMVP.z01.osobe.model.DataModel;
import rs.math.oop1.z200604.fxmlMVP.z01.osobe.model.Osoba;

public class ListController {

    @FXML
    private ListView<Osoba> listView ;

    private DataModel model ;

    public void initModel(DataModel model) {
        // ensure model is only set once:
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }

        this.model = model ;
        listView.setItems(model.getOsobaList());

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> 
            model.setCurrentPerson(newSelection));

        model.currentPersonProperty().addListener((obs, oldPerson, newPerson) -> {
            if (newPerson == null) {
                listView.getSelectionModel().clearSelection();
            } else {
                listView.getSelectionModel().select(newPerson);
            }
        });
        
        listView.setCellFactory(lv -> new ListCell<Osoba>() {
            @Override
            public void updateItem(Osoba person, boolean empty) {
                super.updateItem(person, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(person.getIme() + " " + person.getPrezime());
                }
            }
        });
    }
}