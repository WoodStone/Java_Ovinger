package no.vestein.oving4.sokoban.map;

import no.vestein.oving4.sokoban.SokobanFX;
import no.vestein.oving4.sokoban.blocks.Block;
import no.vestein.oving4.sokoban.blocks.BlockGoal;
import no.vestein.oving4.sokoban.blocks.BlockGreenBox;
import no.vestein.oving4.sokoban.blocks.BlockPlayer;
import no.vestein.oving4.sokoban.blocks.BlockRedBox;
import no.vestein.oving4.sokoban.blocks.BlockWall;

public class Movement {

	public static void checkCommand(String command) {
		if (command.toLowerCase().equals("s")) {
			movePlayer(0, 1);
		} else if (command.toLowerCase().equals("w")) {
			movePlayer(0, -1);
		} else if (command.toLowerCase().equals("a")) {
			movePlayer(-1, 0);
		} else if (command.toLowerCase().equals("d")) {
			movePlayer(1, 0);
		}
	}
	
	private static boolean moveBlock(int playerX, int playerY, int dirX, int dirY) {
		Block block = SokobanFX.level.getMap().getBlock(playerX + dirX, playerY + dirY);
		if (block instanceof BlockRedBox) {
			if (moveBlockRed(playerX, playerY, dirX, dirY)) return true;
		} else if (block instanceof BlockGreenBox) {
			if (moveBlockGreen(playerX, playerY, dirX, dirY)) return true;;
		}
		return false;
	} 
	
	private static boolean moveBlockRed(int playerX, int playerY, int dirX, int dirY) {
		BlockRedBox redbox = (BlockRedBox) SokobanFX.level.getMap().getBlock(playerX + dirX, playerY + dirY);
		Block block = SokobanFX.level.getMap().getBlock(playerX + (dirX * 2), playerY + (dirY * 2));
		if (block instanceof BlockRedBox || block instanceof BlockGreenBox || block instanceof BlockWall) {
			return false;
		} else if (block instanceof BlockGoal) {
			SokobanFX.shapesPane.getChildren().remove(redbox.getObject());
			BlockGreenBox greenbox = new BlockGreenBox((playerX + (dirX * 2)) * 20 + 50, (playerY + (dirY * 2)) * 20 + 50);
			SokobanFX.shapesPane.getChildren().add(greenbox.getObject());
			
			SokobanFX.level.getMap().getMap().put((playerX + (dirX * 2)) + "." + (playerY + (dirY * 2)), greenbox);
			SokobanFX.level.getMap().getMap().remove((playerX + dirX) + "." + (playerY + dirY));
		} else {
			SokobanFX.level.getMap().getMap().put((playerX + (dirX * 2)) + "." + (playerY + (dirY * 2)), redbox);
			SokobanFX.level.getMap().getMap().remove((playerX + dirX) + "." + (playerY + dirY));
			
			redbox.setXPosition(playerX + (dirX * 2));
			redbox.setYPosition(playerY + (dirY * 2));
		}
		return true;
	}
	
	private static boolean moveBlockGreen(int playerX, int playerY, int dirX, int dirY) {
		BlockGreenBox greenbox = (BlockGreenBox) SokobanFX.level.getMap().getBlock(playerX + dirX, playerY + dirY);
		Block block = SokobanFX.level.getMap().getBlock(playerX + (dirX * 2), playerY + (dirY * 2));
		if (block instanceof BlockRedBox || block instanceof BlockGreenBox || block instanceof BlockWall) {
			return false;
		} else  {
			SokobanFX.shapesPane.getChildren().remove(greenbox.getObject());
			SokobanFX.shapesPane.getChildren().remove(SokobanFX.level.getMap().getPlayer().getObject());
			
			BlockRedBox redbox = new BlockRedBox((playerX + (dirX * 2)) * 20 + 50, (playerY + (dirY * 2)) * 20 + 50);
			BlockGoal goal = new BlockGoal((playerX + dirX) * 20 + 50, (playerY + dirY) * 20 + 50);
			SokobanFX.level.getMap().setPlayer(new BlockPlayer((playerX + dirX) * 20 + 50, (playerY + dirY) * 20 + 50));
			
			SokobanFX.shapesPane.getChildren().add(redbox.getObject());
			SokobanFX.shapesPane.getChildren().add(goal.getObject());
			SokobanFX.shapesPane.getChildren().add(SokobanFX.level.getMap().getPlayer().getObject());
			
			SokobanFX.level.getMap().getMap().put((playerX + (dirX * 2)) + "." + (playerY + (dirY * 2)), redbox);
			SokobanFX.level.getMap().getMap().put((playerX + dirX) + "." + (playerY + dirY), goal);
		}
		return true;
	}
	
	private static void movePlayer(int dirX, int dirY) {
		int playerX = SokobanFX.level.getMap().getPlayer().getXPosition();
		int playerY = SokobanFX.level.getMap().getPlayer().getYPosition();
		try {
			Block block = SokobanFX.level.getMap().getBlock(playerX + dirX, playerY + dirY);
			if (block == null || block instanceof BlockGoal) {
				SokobanFX.level.getMap().getPlayer().setXPosition(playerX + dirX);
				SokobanFX.level.getMap().getPlayer().setYPosition(playerY + dirY);
			
				SokobanFX.level.getMap().getMap().remove(playerX + "." + playerY + "player");
				SokobanFX.level.getMap().getMap().put("player", SokobanFX.level.getMap().getPlayer());
			} else if (! (block instanceof BlockWall)) {
				if (moveBlock(playerX, playerY, dirX, dirY)) {
					SokobanFX.level.getMap().getPlayer().setXPosition(playerX + dirX);
					SokobanFX.level.getMap().getPlayer().setYPosition(playerY + dirY);
				
					SokobanFX.level.getMap().getMap().remove(playerX + "." + playerY + "player");
					SokobanFX.level.getMap().getMap().put("player", SokobanFX.level.getMap().getPlayer());
				}
			}
			
		} catch (NullPointerException e) {
			System.out.println(e);
		}		
		
	}
	
}
