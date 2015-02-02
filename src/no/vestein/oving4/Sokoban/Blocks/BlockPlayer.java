package no.vestein.oving4.Sokoban.Blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class BlockPlayer extends BlockEllipse {
	
//	private Ellipse shape;

	public BlockPlayer(int x, int y) {
		super(x, y);
		super.shape = new Ellipse(x + 10, y + 10, 10, 10);
		super.shape.setFill(Color.YELLOW);
		//super.shape.setStroke(Color.AQUA);
	}
	
}
