package rs.ac.bg.matf.oop_p.p2105.metronomPathTransition;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.GroupBuilder;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Metronome1Main extends Application
{
  Button startButton;
  Button pauseButton;
  Button resumeButton;
  Button stopButton;
  Ellipse ellipse = EllipseBuilder.create().centerX(100).centerY(50).radiusX(4)
      .radiusY(8).fill(Color.BLUE).build();
  Path path = PathBuilder
      .create()
      .elements(
          new MoveTo(100, 50),
          ArcToBuilder.create().x(300).y(50).radiusX(350).radiusY(350)
              .sweepFlag(true).build()).build();

  PathTransition anim = PathTransitionBuilder.create()
      .duration(new Duration(1000.0)).node(ellipse).path(path)
      .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
      .interpolator(Interpolator.LINEAR).autoReverse(true)
      .cycleCount(Timeline.INDEFINITE).build();

  public static void main(String[] args)
  {
    Application.launch(args);
  }

  @Override
  public void start(Stage stage)
  {
    Scene scene = SceneBuilder
        .create()
        .width(400)
        .height(500)
        .root(
            GroupBuilder
                .create()
                .children(
                    ellipse,
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
                                    new EventHandler<javafx.event.ActionEvent>()
                                    {
                                      @Override
                                      public void handle(
                                          javafx.event.ActionEvent e)
                                      {
                                        anim.playFromStart();
                                      }
                                    }).build(),
                            pauseButton = ButtonBuilder
                                .create()
                                .text("Pause")
                                .onAction(
                                    new EventHandler<javafx.event.ActionEvent>()
                                    {
                                      @Override
                                      public void handle(
                                          javafx.event.ActionEvent e)
                                      {
                                        anim.pause();
                                      }
                                    }).build(),
                            resumeButton = ButtonBuilder
                                .create()
                                .text("Resume")
                                .onAction(
                                    new EventHandler<javafx.event.ActionEvent>()
                                    {
                                      @Override
                                      public void handle(
                                          javafx.event.ActionEvent e)
                                      {
                                        anim.play();
                                      }
                                    }).build(),
                            stopButton = ButtonBuilder
                                .create()
                                .text("Stop")
                                .onAction(
                                    new EventHandler<javafx.event.ActionEvent>()
                                    {
                                      @Override
                                      public void handle(
                                          javafx.event.ActionEvent e)
                                      {
                                        anim.stop();
                                      }
                                    }).build()).build()).build()).build();
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