package no.vestein.oving4.sokoban.eventhandler;

import no.vestein.oving4.sokoban.SokobanFX;
import no.vestein.oving4.sokoban.blocks.Block;
import no.vestein.oving4.sokoban.blocks.BlockGoal;
import no.vestein.oving4.sokoban.blocks.BlockGreenBox;

public class GameState {

	private static int numberOfBlocksRequired;
	
	public static void init() {
		for (Block entry : SokobanFX.level.getMap().getMap().values()) {
			if (entry instanceof BlockGreenBox || entry instanceof BlockGoal) numberOfBlocksRequired++;
		}
	}
	
	public static boolean checkForWin() {
		int n = 0;
		for (Block entry : SokobanFX.level.getMap().getMap().values()) {
			if (entry instanceof BlockGreenBox) n++;
		}
		return n == numberOfBlocksRequired;
	}
	
}
