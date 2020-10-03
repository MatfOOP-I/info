package primer01helloJavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/*
	Kako bi pokrenuli JavaFX aplikaciju, potrebno je da nasledimo klasu
	javafx.application.Application i implementiramo metod 'start'. On se
	poziva u funkciji 'main' tako sto se poziva funkcija 'launch'.
*/

public class ZdravoJavaFX extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		/*
		 	10 oznacava za koliko VBox razdvaja
		  	kontrole koje redja.
		*/
		VBox root = new VBox(10);

		/*
			Dodajmo 'padding', odnosno prostor sa strane kontrole.
		*/
		root.setPadding(new Insets(10, 10, 10, 10));
		
		// Instanciramo dva dugmeta.
		Button btKlikniMe = new Button("Klikni me!");
		Button btBrisi = new Button("Brisi!");
		
		// Instanciramo jednu labelu koja ce sluziti za prikaz teksta.
		Label lblTekst = new Label("");
		
		// Postavljamo da labela prikazuje tekst crvenom bojom.
		lblTekst.setTextFill(Color.RED);
		
		/*
			Pravimo nase stablo grafickih komponenti, ono postaje:
			VBox:
		 		Label 			<- lblTekst
		 		Button 			<- btKlikniMe
		 		Button 			<- btBrisi
		*/
		root.getChildren().addAll(lblTekst, btKlikniMe, btBrisi);
		
		/*
		 	Sintaksa koja pravi anonimnu klasu koja implementira
		  	interfejs 'EventHandler<ActionEvent>' i poseduje metod
			'handle' koji se izvrsava kada korisnik klikne na dugme.
		*/
		btKlikniMe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// Ako se izvrsava ovaj metod, znamo da je korisnik kliknuo
				// na dugme 'btKlikniMe' tako da korisniku ispisujemo poruku.
				
				// Na labelu postavljamo tekst.
				lblTekst.setText("Zdravo svete!");
			}
		});

		/*
			Mozemo napraviti anonimnu klasu i u sintaksi labda izraza.
		*/
		btBrisi.setOnAction(e -> {
				// Sa labele uklanjamo tekst.
				lblTekst.setText("");
		});
		
		/*
			Pravimo scenu dimenzija 200x200 kojoj prosledjujemo cvor stabla
			nasih grafickih komponenti.
		*/
		Scene scene = new Scene(root, 200, 200);
		
		// Napravljena scenu postavljamo na pozornicu.
		primaryStage.setScene(scene);
		
		// Dajemo nasoj predstavi ime.
		primaryStage.setTitle("Hello world");
		
		// Otvaramo zavesu.
		primaryStage.show();
	}
}
