package rs.ac.bg.matf.oop_p.p2104.metronomTransition;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.animation.TranslateTransitionBuilder;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Metronome1Main extends Application {
	Button startButton;
	Button pauseButton;
	Button resumeButton;
	Button stopButton;
	Circle circle = CircleBuilder.create().centerX(100).centerY(50).radius(4)
			.fill(Color.BLUE).build();
	TranslateTransition anim = TranslateTransitionBuilder.create()
			.duration(new Duration(1000.0)).node(circle).fromX(0).toX(200)
			.interpolator(Interpolator.LINEAR).autoReverse(true)
			.cycleCount(Timeline.INDEFINITE).build();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = SceneBuilder
				.create()
				.width(400)
				.height(500)
				.root(GroupBuilder
						.create()
						.children(
								circle,
								HBoxBuilder
										.create()
										.layoutX(60)
										.layoutY(420)
										.spacing(10)
										.children(
												startButton = ButtonBuilder
														.create()
														.text("Start")
														.onAction(
																new EventHandler<javafx.event.ActionEvent>() {
																	@Override
																	public void handle(
																			javafx.event.ActionEvent e) {
																		anim.playFromStart();
																	}
																}).build(),
												pauseButton = ButtonBuilder
														.create()
														.text("Pause")
														.onAction(
																new EventHandler<javafx.event.ActionEvent>() {
																	@Override
																	public void handle(
																			javafx.event.ActionEvent e) {
																		anim.pause();
																	}
																}).build(),
												resumeButton = ButtonBuilder
														.create()
														.text("Resume")
														.onAction(
																new EventHandler<javafx.event.ActionEvent>() {
																	@Override
																	public void handle(
																			javafx.event.ActionEvent e) {
																		anim.play();
																	}
																}).build(),
												stopButton = ButtonBuilder
														.create()
														.text("Stop")
														.onAction(
																new EventHandler<javafx.event.ActionEvent>() {
																	@Override
																	public void handle(
																			javafx.event.ActionEvent e) {
																		anim.stop();
																	}
																}).build())
										.build()).build()).build();
		startButton.disableProperty().bind(
				anim.statusProperty().isNotEqualTo(Animation.Status.STOPPED));
		pauseButton.disableProperty().bind(
				anim.statusProperty().isNotEqualTo(Animation.Status.RUNNING));
		resumeButton.disableProperty().bind(
				anim.statusProperty().isNotEqualTo(Animation.Status.PAUSED));
		stopButton.disableProperty().bind(
				anim.statusProperty().isEqualTo(Animation.Status.STOPPED));
		stage.setScene(scene);
		stage.setTitle("Metronome using TranslateTransition");
		stage.show();
	}
}