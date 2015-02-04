package no.vestein.oving4.sokoban.map;

import javafx.scene.layout.Pane;
import no.vestein.oving4.sokoban.SokobanFX;
import no.vestein.oving4.sokoban.blocks.Block;
import no.vestein.oving4.sokoban.blocks.BlockPlayer;

public class Level {

	private static SokobanMap map;
	
	public static void init() {
		map = new SokobanMap(50, 50);
		genMap(SokobanFX.shapesPane, map);
	}
	
	public static SokobanMap getMap() {
		return map;
	}
	
	private static void genMap(Pane shapesPane, SokobanMap map) {
		map.generate();
		for (Block value : map.getMap().values()) {
			if (! (value instanceof BlockPlayer)) {
				shapesPane.getChildren().add(value.getObject());
			}
		}
		shapesPane.getChildren().add(map.getPlayer().getObject());	
	}
	
}
