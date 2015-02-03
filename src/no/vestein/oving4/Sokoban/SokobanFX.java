package no.vestein.oving4.sokoban;

import java.util.Map;

import no.vestein.oving4.sokoban.blocks.Block;
import no.vestein.oving4.sokoban.blocks.BlockPlayer;
import no.vestein.oving4.sokoban.eventhandler.EventTextField;
import no.vestein.oving4.sokoban.eventhandler.GameState;
import no.vestein.oving4.sokoban.map.MapGen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SokobanFX extends Application{

	public static MapGen mapGen = new MapGen();
	public static Pane shapesPane;
	EventTextField eventText = new EventTextField();
	
	@Override
	public void start(Stage stage) throws Exception {
		
//		Pane root = new Pane(); // Root of the scene graph
		BorderPane root = new BorderPane();
		
		shapesPane = new Pane();
		shapesPane.setPrefSize(300, 300);
		
		eventText.init();		
		shapesPane.getChildren().add(eventText.getTextField());
		
		genMap(shapesPane);
		root.setCenter(shapesPane);
		
		GameState.init();
		
		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.setTitle("Sokoban");
		stage.show();
	}
	
	private void genMap(Pane shapesPane) {
		mapGen.generate();
		Map<String, Block> map = mapGen.getMap();
		for (Block value : map.values()) {
			if (! (value instanceof BlockPlayer)) {
				shapesPane.getChildren().add(value.getObject());
			}
		}
		shapesPane.getChildren().add(mapGen.getPlayer().getObject());
		
	}
	
	public static MapGen getMapGen() {
		return mapGen;
	}
	
	public static void main(String[] args) {
    	launch(SokobanFX.class, args);
    }
	
}
