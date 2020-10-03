package posiljke;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PosiljkeMain extends Application {

	private static List<Posiljka> posiljke = new ArrayList<Posiljka>();
	
	private TextArea pregledTA;
	private Button pregledBtn, pregledSortBtn;
	private RadioButton pismaBtn, paketiBtn, ekspresBtn;
	private Button otpremiBtn;
	private TextField brPosiljkeTF;
	private Button pronadjiBtn;
	private ToggleGroup tg = new ToggleGroup();
	
	public void start(Stage primaryStage) {
		try {
			VBox root = new VBox(10);
			Scene scene = new Scene(root, 550, 350);
			napraviGUI(root);
			
			primaryStage.setTitle("Postanske posiljke");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void napraviGUI(VBox root) {
		root.setSpacing(20);
		root.setPadding(new Insets(10));
		
		VBox top = new VBox(10);
		HBox topA = new HBox();
		topA.getChildren().addAll((pregledTA = new TextArea()));
		pregledTA.setEditable(false);
		HBox.setHgrow(pregledTA, Priority.ALWAYS);
		
		HBox topB = new HBox(50);
		pregledBtn = new Button("Pregledaj posiljke");
		pregledBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				StringBuilder sb = new StringBuilder();
				if(posiljke.isEmpty()) {
					try {
						List<String> linije = Files.readAllLines(Paths.get("posiljke.txt"));
						if(!linije.isEmpty()) {
							for(String linija : linije) {
								Posiljka p = null;
								try(Scanner scLinija = new Scanner(linija)) {								
									String primalac = scLinija.next() + " " + scLinija.next();
									int brojPoste = scLinija.nextInt();
									String tip = scLinija.next();
									if(tip.equals("PSM")) {
										boolean preporuceno = scLinija.hasNext();
										p = new Pismo(primalac, brojPoste, preporuceno);
									}
									else if(tip.equals("PAK")) {
										p = new Paket(primalac, brojPoste, scLinija.next());
									}
									else if(tip.equals("PE")) {
										String kada = scLinija.next().toUpperCase();
										if(kada.equals("SUTRA"))
											p = new Ekspres(primalac, brojPoste, EkspresUsluga.valueOf(kada + "_" + scLinija.next()));
										else 
											p = new Ekspres(primalac, brojPoste, EkspresUsluga.valueOf(kada));
									}
									posiljke.add(p);								
								}
								sb.append(p + "\n");
							}					
						}		
						else
							sb.append("Nema posiljki!");
						
						pregledTA.setText(sb.toString());				
					}
					catch(IOException e) {
						pregledTA.setText("Greska prilikom citanja datoteke posiljke.txt");
					}
				}
			}
		});
			
		HBox topR = new HBox(10);
		topR.setAlignment(Pos.CENTER);
		pregledSortBtn = new Button("Pregledaj uredjeno");
		pismaBtn = new RadioButton("Pisma");
		paketiBtn = new RadioButton("Paketi");
		ekspresBtn = new RadioButton("Ekspres");
		pismaBtn.setToggleGroup(tg);
		paketiBtn.setToggleGroup(tg);
		ekspresBtn.setToggleGroup(tg);
		topR.getChildren().addAll(pregledSortBtn, pismaBtn, paketiBtn, ekspresBtn);
		topB.getChildren().addAll(pregledBtn, topR);
		top.getChildren().addAll(topA, topB);
		
		pregledSortBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg0) {
				pregledTA.setText("");
				Collections.sort(posiljke);
				boolean pregled;
				for(Posiljka p : posiljke) {
					pregled = false;
					if(pismaBtn.isSelected()) {
						if(p instanceof Pismo)
							pregled = true;
					}
					else if(paketiBtn.isSelected()) {
						if(p instanceof Paket)
							pregled = true;
					}
					else if(ekspresBtn.isSelected()) {
						if(p instanceof Ekspres)
							pregled = true;
					}
					else pregled = true;
					
					if(pregled) 
						pregledTA.appendText(p + "\n");
				}
			}
		});

		otpremiBtn = new Button("Otpremi");
		otpremiBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				pregledTA.setText("");
				for(Posiljka p : posiljke) {
					if(p instanceof Ekspres) {
						if(((Ekspres)p).getTip() != EkspresUsluga.SUTRA_19)
							if(!p.isStatus())
								p.setStatus(true);
					}
					else if(p instanceof Pismo) {
						if(((Pismo)p).isPreporuceno())
							if(!p.isStatus())
								p.setStatus(true);
					}
					pregledTA.appendText(p + "\n");
				}
			}
		});
		
		HBox bottom = new HBox(new Label("Broj/id posiljke:"));
		bottom.setSpacing(10);
		bottom.setAlignment(Pos.BASELINE_LEFT);
		brPosiljkeTF = new TextField();
		pronadjiBtn = new Button("Pronadji");
		pronadjiBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				try {
					int id = Integer.parseInt(brPosiljkeTF.getText());
					pregledTA.clear();
					for(Posiljka p : posiljke)
						if(id == p.getId()) {
							pregledTA.appendText("-------------\n" + p);
							return;
						}
					pregledTA.appendText("-------------\nNema posiljke sa datim brojem!");
				}
				catch(NumberFormatException nfe) {
					brPosiljkeTF.setText("Niste uneli ceo broj!");
				}
			}
		});
		bottom.getChildren().addAll(brPosiljkeTF, pronadjiBtn);
		
		root.getChildren().addAll(top, otpremiBtn, bottom);
	}

		
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
