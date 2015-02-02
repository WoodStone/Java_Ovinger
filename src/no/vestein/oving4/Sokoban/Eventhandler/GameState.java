package no.vestein.oving4.Sokoban.Eventhandler;

import no.vestein.oving4.Sokoban.SokobanFX;
import no.vestein.oving4.Sokoban.Blocks.Block;
import no.vestein.oving4.Sokoban.Blocks.BlockGoal;
import no.vestein.oving4.Sokoban.Blocks.BlockGreenBox;

public class GameState {

	private static int numberOfBlocksRequired;
	
	public static void init() {
		for (Block entry : SokobanFX.mapGen.getMap().values()) {
			if (entry instanceof BlockGreenBox || entry instanceof BlockGoal) numberOfBlocksRequired++;
		}
	}
	
	public static boolean checkForWin() {
		int n = 0;
		for (Block entry : SokobanFX.mapGen.getMap().values()) {
			if (entry instanceof BlockGreenBox) n++;
		}
		return n == numberOfBlocksRequired;
	}
	
}
