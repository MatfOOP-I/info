package rs.ac.bg.matf.oop_p.p2103.metronom;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBuilder;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Metronome1Main extends Application {
	DoubleProperty startXVal = new SimpleDoubleProperty(100.0);
	Button startButton;
	Button pauseButton;
	Button resumeButton;
	Button stopButton;
	Line line;
	Timeline anim = TimelineBuilder
			.create()
			.autoReverse(true)
			.keyFrames(
					new KeyFrame(new Duration(0.0), new KeyValue(startXVal,
							100.0)),
					new KeyFrame(new Duration(1000.0), new KeyValue(startXVal,
							300.0, Interpolator.LINEAR)))
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
								line = LineBuilder.create().startY(50)
										.endX(200).endY(400).strokeWidth(4)
										.stroke(Color.BLUE).build(),
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
		line.startXProperty().bind(startXVal);
		startButton.disableProperty().bind(
				anim.statusProperty().isNotEqualTo(Animation.Status.STOPPED));
		pauseButton.disableProperty().bind(
				anim.statusProperty().isNotEqualTo(Animation.Status.RUNNING));
		resumeButton.disableProperty().bind(
				anim.statusProperty().isNotEqualTo(Animation.Status.PAUSED));
		stopButton.disableProperty().bind(
				anim.statusProperty().isEqualTo(Animation.Status.STOPPED));
		stage.setScene(scene);
		stage.setTitle("Metronome 1");
		stage.show();
	}
}