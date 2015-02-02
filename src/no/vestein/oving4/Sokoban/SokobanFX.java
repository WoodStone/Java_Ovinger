package no.vestein.oving4.Sokoban;

import java.util.Map;

import no.vestein.oving4.Sokoban.Blocks.Block;
import no.vestein.oving4.Sokoban.Blocks.BlockPlayer;
import no.vestein.oving4.Sokoban.Eventhandler.EventTextField;
import no.vestein.oving4.Sokoban.Eventhandler.GameState;
import no.vestein.oving4.Sokoban.Map.MapGen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SokobanFX extends Application{

	public static MapGen mapGen = new MapGen();
	public static Map<String, Block> map;
	public static Pane shapesPane;
	EventTextField eventText = new EventTextField();
	
	@Override
    public void start(Stage stage) throws Exception {
		
//        Pane root = new Pane(); // Root of the scene graph
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
		SokobanFX.map = map;
		for (Block value : map.values()) {
			if (! (value instanceof BlockPlayer)) {
				shapesPane.getChildren().add(value.getObject());
			}
		}
		shapesPane.getChildren().add(map.get(mapGen.getPlayerPosition()).getObject());
		
//		System.out.println(mapGen.getBlock(2, 1));
		
	}
	
	public MapGen getMapGen() {
		return mapGen;
	}
	
    public static void main(String[] args) {
        launch(SokobanFX.class, args);
    }
	
}
