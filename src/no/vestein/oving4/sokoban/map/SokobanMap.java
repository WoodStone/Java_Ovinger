package no.vestein.oving4.sokoban.map;

import java.util.HashMap;
import java.util.Map;

import no.vestein.oving4.sokoban.blocks.Block;
import no.vestein.oving4.sokoban.blocks.BlockGoal;
import no.vestein.oving4.sokoban.blocks.BlockGreenBox;
import no.vestein.oving4.sokoban.blocks.BlockPlayer;
import no.vestein.oving4.sokoban.blocks.BlockRedBox;
import no.vestein.oving4.sokoban.blocks.BlockWall;

public class SokobanMap {

	private int posX;
	private int posY;
	private Map<String, Block> map;
	
	public SokobanMap(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.map = generate();
	}
	
	public Map<String, Block> getMap() {
		return map;
	}
	
	public Map<String, Block> generate() {
		return generateObjects();
	}
	
	public Block getBlock(int x, int y) {
		return map.get(x + "." + y);
	}
	
	public BlockPlayer getPlayer() {
		return (BlockPlayer) map.get("player");
	}
	
	public void setPlayer(BlockPlayer player) {
		map.put("player", player);
	}
	
	Map<String, Block> generateObjects() {
		Map<String, Block> map = new HashMap<>();
		char[][] level = Levels.level;
		for (int i = 0; i < level.length; i++) {
			for (int j = 0; j < level.length; j++) {
				if (level[i][j] == '#') {
					BlockWall wall = new BlockWall(posX + (j * 20), posY + (i * 20));
					map.put(j + "." + i, wall);
				} else if (level[i][j] == '*') {
					BlockGreenBox box = new BlockGreenBox(posX + (j * 20), posY + (i * 20));
					map.put(j + "." + i, box);
				} else if (level[i][j] == '$') {
					BlockRedBox box = new BlockRedBox(posX + (j * 20), posY + (i * 20));
					map.put(j + "." + i, box);
				} else if (level[i][j] == '.') {
					BlockGoal goal = new BlockGoal(posX + (j * 20), posY + (i * 20));
					map.put(j + "." + i, goal);
				} else if (level[i][j] == '@') {
					BlockPlayer player = new BlockPlayer(posX + (j * 20), posY + (i * 20));
					map.put("player", player);
					System.out.println(j + "." + i);
				}
			}
		}
		return map;
	}
	
	
}
