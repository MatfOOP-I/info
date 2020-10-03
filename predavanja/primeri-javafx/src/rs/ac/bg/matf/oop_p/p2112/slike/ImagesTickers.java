package rs.ac.bg.matf.oop_p.p2112.slike;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcBuilder;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;

/**
 * Creating Images
 * 
 * @author cdea
 */
public class ImagesTickers extends Application
{
	private List<String> imageFiles = new ArrayList();
	private int currentIndex = -1;

	public enum ButtonMove
	{
		NEXT, PREV
	};

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
		primaryStage.setTitle("Chapter 2-2 Images and tickers");
		Group root = new Group();
		Scene scene = new Scene(root, 551, 400, Color.BLACK);
		// image view
		final ImageView currentImageView = new ImageView();
		// maintain aspect ratio
		currentImageView.setPreserveRatio(true);
		// resize based on the scene
		currentImageView.fitWidthProperty().bind(scene.widthProperty());
		final HBox pictureRegion = new HBox();
		pictureRegion.getChildren().add(currentImageView);
		root.getChildren().add(pictureRegion);
		// Dragging over surface
		scene.setOnDragOver(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event)
			{
				Dragboard db = event.getDragboard();
				if (db.hasFiles())
				{
					event.acceptTransferModes(TransferMode.COPY);
				}
				else
				{
					event.consume();
				}
			}
		});
		// Dropping over surface
		scene.setOnDragDropped(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event)
			{
				Dragboard db = event.getDragboard();
				boolean success = false;
				if (db.hasFiles())
				{
					success = true;
					String filePath = null;
					for (File file : db.getFiles())
					{
						filePath = file.getAbsolutePath();
						currentIndex += 1;
						imageFiles.add(currentIndex, filePath);
						// absolute file name
						System.out.println("file: " + file);
						// the index in the list of file names
						System.out.println("currentImageFileIndex = " + currentIndex);
					}
					// set new image as the image to show.
					Image imageimage = new Image(filePath);
					currentImageView.setImage(imageimage);
				}
				event.setDropCompleted(success);
				event.consume();
			}
		});
		
		// create slide controls
		Group buttonGroup = new Group();
		// rounded rect
		Rectangle buttonArea = RectangleBuilder.create().arcWidth(15).arcHeight(20)
				.fill(new Color(0, 0, 0, .55)).x(0).y(0).width(60).height(30).stroke(
						Color.rgb(255, 255, 255, .70)).build();
		buttonGroup.getChildren().add(buttonArea);
		// left control
		Arc leftButton = ArcBuilder.create().type(ArcType.ROUND).centerX(12)
				.centerY(16).radiusX(15).radiusY(15).startAngle(-30).length(60).fill(
						new Color(1, 1, 1, .90)).build();
		leftButton.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me)
					{
						int indx = gotoImageIndex(ButtonMove.PREV);
						if (indx > -1)
						{
							String namePict = imageFiles.get(indx);
							final Image image = new Image(new File(namePict)
									.getAbsolutePath());
							currentImageView.setImage(image);
						}
					}
				});
		buttonGroup.getChildren().add(leftButton);
		// right control
		Arc rightButton = ArcBuilder.create().type(ArcType.ROUND).centerX(12)
				.centerY(16).radiusX(15).radiusY(15).startAngle(180 - 30).length(60)
				.fill(new Color(1, 1, 1, .90)).translateX(40).build();
		buttonGroup.getChildren().add(rightButton);
		rightButton.addEventHandler(MouseEvent.MOUSE_PRESSED,
				new EventHandler<MouseEvent>() {
					public void handle(MouseEvent me)
					{
						int indx = gotoImageIndex(ButtonMove.NEXT);
						if (indx > -1)
						{
							String namePict = imageFiles.get(indx);
							final Image image = new Image(new File(namePict)
									.getAbsolutePath());
							currentImageView.setImage(image);
						}
					}
				});
		// move button group when scene is resized
		buttonGroup.translateXProperty().bind(
				scene.widthProperty().subtract(buttonArea.getWidth() + 6));
		buttonGroup.translateYProperty().bind(
				scene.heightProperty().subtract(buttonArea.getHeight() + 6));
		root.getChildren().add(buttonGroup);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Returns the next index in the list of files to go to next.
	 * 
	 * @param direction
	 *          PREV and NEXT to move backward or forward in the list of pictures.
	 * @return int the index to the previous or next picture to be shown.
	 */
	public int gotoImageIndex(ButtonMove direction)
	{
		int size = imageFiles.size();
		if (size == 0)
		{
			currentIndex = -1;
		}
		else if (direction == ButtonMove.NEXT && size > 1
				&& currentIndex < size - 1)
		{
			currentIndex += 1;
		}
		else if (direction == ButtonMove.PREV && size > 1 && currentIndex > 0)
		{
			currentIndex -= 1;
		}
		return currentIndex;
	}

}