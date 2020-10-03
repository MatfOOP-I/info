package rs.ac.bg.matf.oop_p.p1807.sekvencaTastera;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.InnerShadowBuilder;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

/**
 * Background Processes
 * 
 * @author cdea
 */
public class KeyboardSequences extends Application
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
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Chapter 1-13 Associating Keyboard Sequences");
		Group root = new Group();
		Scene scene = new Scene(root, 530, 300, Color.WHITE);
		final StringProperty statusProperty = new SimpleStringProperty();
		InnerShadow iShadow = InnerShadowBuilder.create().offsetX(3.5f).offsetY(
				3.5f).build();
		final Text status = TextBuilder.create().effect(iShadow).x(100).y(50).fill(
				Color.LIME).font(Font.font(null, FontWeight.BOLD, 35)).translateY(50)
				.build();
		status.textProperty().bind(statusProperty);
		statusProperty.set("Keyboard Shortcuts \nCtrl-N, \nCtrl-S, \nCtrl-X");
		root.getChildren().add(status);
		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		root.getChildren().add(menuBar);
		Menu menu = new Menu("File");
		menuBar.getMenus().add(menu);
		MenuItem newItem = MenuItemBuilder.create().text("New").accelerator(
				new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN))
				.onAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event)
					{
						statusProperty.set("Ctrl-N");
					}
				}).build();
		menu.getItems().add(newItem);
		MenuItem saveItem = MenuItemBuilder.create().text("Save").accelerator(
				new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN))
				.onAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event)
					{
						statusProperty.set("Ctrl-S");
					}
				}).build();
		menu.getItems().add(saveItem);
		menu.getItems().add(new SeparatorMenuItem());
		MenuItem exitItem = MenuItemBuilder.create().text("Exit").accelerator(
				new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN))
				.onAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event)
					{
						statusProperty.set("Ctrl-X");
					}
				}).build();
		menu.getItems().add(exitItem);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}