package no.vestein.oving4.sokoban;

import no.vestein.oving4.sokoban.eventhandler.EventTextField;
import no.vestein.oving4.sokoban.eventhandler.GameState;
import no.vestein.oving4.sokoban.map.Level;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SokobanFX extends Application{

	public static Pane shapesPane;
	public static EventTextField eventText = new EventTextField();
	
	@Override
	public void start(Stage stage) throws Exception {
		
//		Pane root = new Pane(); // Root of the scene graph
		BorderPane root = new BorderPane();
		
		shapesPane = new Pane();
		shapesPane.setPrefSize(300, 300);

		EventTextField.init();
		Level.init();
		GameState.init();
		
		root.setCenter(shapesPane);
		
		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.setTitle("Sokoban");
		stage.show();
	}

	public static void main(String[] args) {
    	launch(SokobanFX.class, args);
    }
	
}
