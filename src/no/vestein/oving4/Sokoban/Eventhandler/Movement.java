package no.vestein.oving4.Sokoban.Eventhandler;

import no.vestein.oving4.Sokoban.SokobanFX;
import no.vestein.oving4.Sokoban.Blocks.Block;
import no.vestein.oving4.Sokoban.Blocks.BlockGoal;
import no.vestein.oving4.Sokoban.Blocks.BlockGreenBox;
import no.vestein.oving4.Sokoban.Blocks.BlockPlayer;
import no.vestein.oving4.Sokoban.Blocks.BlockRedBox;
import no.vestein.oving4.Sokoban.Blocks.BlockWall;

public class Movement {

	public static void checkCommand(String command) {
		BlockPlayer player = (BlockPlayer) SokobanFX.mapGen.getMap().get(SokobanFX.mapGen.getPlayerPosition());
		if (command.toLowerCase().equals("s")) {
			movePlayer(player, 0, 1);
		} else if (command.toLowerCase().equals("w")) {
			movePlayer(player, 0, -1);
		} else if (command.toLowerCase().equals("a")) {
			movePlayer(player, -1, 0);
		} else if (command.toLowerCase().equals("d")) {
			movePlayer(player, 1, 0);
		}

	}
	
	private static void movePlayer(BlockPlayer player, int dirX, int dirY) {
		int playerX = player.getXPosition();
		int playerY = player.getYPosition();
		
		try {
			Block block = SokobanFX.mapGen.getBlock(playerX + dirX, playerY + dirY);
			if (! (block instanceof BlockWall)) {
				if (block instanceof BlockRedBox) {
					BlockRedBox redbox = (BlockRedBox) block;
					block = SokobanFX.mapGen.getBlock(playerX + (dirX * 2), playerY + (dirY * 2));
					if (!(block instanceof Block) || block instanceof BlockGoal) {
						
						if (block instanceof BlockGoal) {
							SokobanFX.shapesPane.getChildren().remove(redbox.getObject());
							BlockGreenBox greenbox = new BlockGreenBox((playerX + (dirX * 2)) * 20 + 50, (playerY + (dirY * 2)) * 20 + 50);
							SokobanFX.shapesPane.getChildren().add(greenbox.getObject());
							
							
							SokobanFX.mapGen.getMap().put((playerX + (dirX * 2)) + "." + (playerY + (dirY * 2)), greenbox);
							SokobanFX.mapGen.getMap().remove((playerX + dirX) + "." + (playerY + dirY));
						} else {
							SokobanFX.mapGen.getMap().put((playerX + (dirX * 2)) + "." + (playerY + (dirY * 2)), redbox);
							SokobanFX.mapGen.getMap().remove((playerX + dirX) + "." + (playerY + dirY));
							
							redbox.setXPosition(playerX + (dirX * 2));
							redbox.setYPosition(playerY + (dirY * 2));
						}
					}
				} else if (block instanceof BlockGreenBox) {
					BlockGreenBox greenbox = (BlockGreenBox) block;
					block = SokobanFX.mapGen.getBlock(playerX + (dirX * 2), playerY + (dirY * 2));
					if (!(block instanceof Block)) {
						SokobanFX.shapesPane.getChildren().remove(greenbox.getObject());
						SokobanFX.shapesPane.getChildren().remove(player.getObject());
						
						BlockRedBox redbox = new BlockRedBox((playerX + (dirX * 2)) * 20 + 50, (playerY + (dirY * 2)) * 20 + 50);
						BlockGoal goal = new BlockGoal((playerX + dirX) * 20 + 50, (playerY + dirY) * 20 + 50);
						player = new BlockPlayer((playerX + dirX) * 20 + 50, (playerY + dirY) * 20 + 50);
						
						SokobanFX.shapesPane.getChildren().add(redbox.getObject());
						SokobanFX.shapesPane.getChildren().add(goal.getObject());
						SokobanFX.shapesPane.getChildren().add(player.getObject());
						
						SokobanFX.mapGen.getMap().put((playerX + (dirX * 2)) + "." + (playerY + (dirY * 2)), redbox);
						SokobanFX.mapGen.getMap().put((playerX + dirX) + "." + (playerY + dirY), goal);
					}
					
					
				}
				player.setXPosition(playerX + dirX);
				player.setYPosition(playerY + dirY);
					
				SokobanFX.mapGen.getMap().remove(playerX + "." + playerY + "player");
				SokobanFX.mapGen.getMap().put((playerX + dirX) + "." + (playerY + dirY) + "player", player);
			}
		} catch (NullPointerException e) {
			System.out.println(e);
			player.setXPosition(playerX + dirX);
			player.setYPosition(playerY + dirY);
			
			SokobanFX.mapGen.getMap().remove(playerX + "." + playerY + "player");
			SokobanFX.mapGen.getMap().put((playerX + dirX) + "." + (playerY + dirY) + "player", player);
		}
		
		
		
	}
	
}
