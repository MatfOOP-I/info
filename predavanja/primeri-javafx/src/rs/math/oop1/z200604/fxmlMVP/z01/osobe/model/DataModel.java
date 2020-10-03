package rs.math.oop1.z200604.fxmlMVP.z01.osobe.model;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;

public class DataModel {

   private final ObservableList<Osoba> osobaList = FXCollections.observableArrayList(osoba ->
         new Observable[]{osoba.imeProperty(), osoba.prezimeProperty()});

   private final ObjectProperty<Osoba> currentPerson = new SimpleObjectProperty<>(null);

   public ObjectProperty<Osoba> currentPersonProperty() {
      return currentPerson;
   }

   public final Osoba getCurrentPerson() {
      return currentPersonProperty().get();
   }

   public final void setCurrentPerson(Osoba osoba) {
      currentPersonProperty().set(osoba);
   }

   public ObservableList<Osoba> getOsobaList() {
      return osobaList;
   }

   public void loadData(File file) {
      // mock...
      osobaList.setAll(
            new Osoba("Jacob", "Smith", "jacob.smith@example.com"),
            new Osoba("Isabella", "Johnson", "isabella.johnson@example.com"),
            new Osoba("Ethan", "Williams", "ethan.williams@example.com"),
            new Osoba("Emma", "Jones", "emma.jones@example.com"),
            new Osoba("Michael", "Brown", "michael.brown@example.com")
      );
   }

   public void saveData(File file) {
   }
}