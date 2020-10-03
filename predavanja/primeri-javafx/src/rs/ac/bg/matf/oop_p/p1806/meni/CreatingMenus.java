package rs.ac.bg.matf.oop_p.p1806.meni;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;

public class CreatingMenus extends Application
{
	/**
	 * @param args
	 *          the command line arguments
	 */
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage primarnaScena)
	{
		primarnaScena.setTitle("Kreiranje menija");
		Group koren = new Group();
		Scene scena = new Scene(koren, 300, 250, Color.WHITE);
		MenuBar linijaMenija = new MenuBar();
		// File menu - new, save, exit
		Menu datoteka = new Menu("File");
		datoteka.getItems().add(new MenuItem("New"));
		datoteka.getItems().add(new MenuItem("Save"));
		datoteka.getItems().add(new SeparatorMenuItem());
		datoteka.getItems().add(new MenuItem("Exit"));
		linijaMenija.getMenus().add(datoteka);
		// Cameras menu - camera 1, camera 2
		Menu kamere = new Menu("Cameras");
		kamere.getItems().add(
				CheckMenuItemBuilder.create().text("Show Camera 1").selected(true)
						.build());
		kamere.getItems().add(
				CheckMenuItemBuilder.create().text("Show Camera 2").selected(true)
						.build());
		linijaMenija.getMenus().add(kamere);
		// Alarm
		Menu alarm = new Menu("Alarm");
		ToggleGroup tGroup = new ToggleGroup();
		RadioMenuItem soundAlarmItem = RadioMenuItemBuilder.create().toggleGroup(
				tGroup).text("Sound Alarm").build();
		RadioMenuItem stopAlarmItem = RadioMenuItemBuilder.create().toggleGroup(
				tGroup).text("Alarm Off").selected(true).build();
		alarm.getItems().add(soundAlarmItem);
		alarm.getItems().add(stopAlarmItem);
		Menu planZaHitneSlucajeve = new Menu("Contingent Plans");
		planZaHitneSlucajeve.getItems().add(
				new CheckMenuItem("Self Destruct in T minus 50"));
		planZaHitneSlucajeve.getItems().add(
				new CheckMenuItem("Turn off the coffee machine "));
		planZaHitneSlucajeve.getItems().add(new CheckMenuItem("Run for your lives! "));
		alarm.getItems().add(planZaHitneSlucajeve);
		linijaMenija.getMenus().add(alarm);
		linijaMenija.prefWidthProperty().bind(primarnaScena.widthProperty());
		koren.getChildren().add(linijaMenija);
		primarnaScena.setScene(scena);
		primarnaScena.show();
	}
}
