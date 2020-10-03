package rs.ac.bg.matf.oop_p.p2106.putanja;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcBuilder;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Working with the Scene Graph
 * 
 * @author cdea
 */
public class WorkingWithSceneGraph extends Application
{
	Path onePath = new Path();
	Point2D anchorPt;

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
		primaryStage.setTitle("Chapter 2-3 Working with the Scene Graph");
		final Group root = new Group();
		// add path
		root.getChildren().add(onePath);
		final Scene scene = SceneBuilder.create().root(root).width(300).height(250)
				.fill(Color.WHITE).build();
		RadialGradient gradient1 = new RadialGradient(0, .1, 100, 100, 20, false,
				CycleMethod.NO_CYCLE, new Stop(0, Color.RED), new Stop(1, Color.BLACK));
		// create a sphere
		final Circle sphere = CircleBuilder.create().centerX(100).centerY(100)
				.radius(20).fill(gradient1).build();
		// add sphere
		root.getChildren().addAll(sphere);
		// animate sphere by following the path.
		final PathTransition pathTransition = PathTransitionBuilder.create()
				.duration(Duration.millis(4000)).cycleCount(1).node(sphere).path(
						onePath).orientation(
						PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT).build();
		// once finished clear path
		pathTransition.onFinishedProperty().set(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event)
			{
				onePath.getElements().clear();
			}
		});
		// starting initial path
		scene.onMousePressedProperty().set(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event)
			{
				// clear path
				onePath.getElements().clear();
				// start point in path
				anchorPt = new Point2D(event.getX(), event.getY());
				onePath.setStrokeWidth(3);
				onePath.setStroke(Color.BLACK);
				onePath.getElements().add(new MoveTo(anchorPt.getX(), anchorPt.getY()));
			}
		});
		// dragging creates lineTos added to the path
		scene.onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event)
			{
				onePath.getElements().add(new LineTo(event.getX(), event.getY()));
			}
		});
		// end the path when mouse released event
		scene.onMouseReleasedProperty().set(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event)
			{
				onePath.setStrokeWidth(0);
				if (onePath.getElements().size() > 1)
				{
					pathTransition.stop();
					pathTransition.playFromStart();
				}
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}