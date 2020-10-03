package predmeti;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	private PlanNastave plan = new PlanNastave();
	private static TextArea pregledTA;
	private Button ucitajBtn;
	private Button prikaziBtn;
	private RadioButton sviBtn, obavezniBtn, izborniBtn;
	private ToggleGroup tg = new ToggleGroup();
	private String opseg;
	
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox(10);
			Scene scene = new Scene(root, 460, 260);
			napraviGUI(root);
			
			primaryStage.setTitle("Nastavni predmeti");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void napraviGUI(VBox root) {
		root.setSpacing(20);
		root.setPadding(new Insets(10));
		
		HBox hboxA = new HBox(ucitajBtn = new Button("Ucitaj podatke iz datoteka"));
		HBox hboxB = new HBox(pregledTA = new TextArea());
		pregledTA.setEditable(false);
		HBox.setHgrow(pregledTA, Priority.ALWAYS);
		
		HBox hboxC = new HBox(30);
		prikaziBtn = new Button("Prikazi predmete");
		sviBtn = new RadioButton("Svi");
		obavezniBtn = new RadioButton("Obavezni");
		izborniBtn = new RadioButton("Izborni");
		sviBtn.setToggleGroup(tg);
		obavezniBtn.setToggleGroup(tg);
		izborniBtn.setToggleGroup(tg);
		sviBtn.setSelected(true);
		hboxC.getChildren().addAll(prikaziBtn, sviBtn, obavezniBtn, izborniBtn);
		hboxC.setAlignment(Pos.BASELINE_LEFT);
		
		ucitajBtn.setOnAction(s->{
			if(!plan.predmeti.isEmpty())
				return;
			
			if(!plan.ucitajPredmete("predmeti.txt")) 
				pregledTA.setText("Neuspesno otvaranje datoteke 'predmeti.txt'.");
			else if(!plan.ucitajUslovne("uslovni.txt")) 
				pregledTA.setText("Neuspesno otvaranje datoteke 'uslovni.txt'.");
			else 
				pregledTA.setText("Podaci o predmetima su uspesno ucitani.");
		});
		
		prikaziBtn.setOnAction(s->{
			if(plan.predmeti.isEmpty()) {
				pregledTA.setText("Nema podataka o predmetima.");
				return;
			}
			if(sviBtn.isSelected())
				opseg = "SVI";
			if(obavezniBtn.isSelected())
				opseg = "OBAVEZNI";
			if(izborniBtn.isSelected())
				opseg = "IZBORNI";
			pregledTA.setText(plan.ispisi(opseg));
		});
	
		root.getChildren().addAll(hboxA, hboxB, hboxC);
	}

		
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
