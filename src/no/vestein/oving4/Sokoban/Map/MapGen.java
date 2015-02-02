package no.vestein.oving4.Sokoban.Map;

import java.util.HashMap;
import java.util.Map;

import no.vestein.oving4.Sokoban.Blocks.Block;
import no.vestein.oving4.Sokoban.Blocks.BlockGoal;
import no.vestein.oving4.Sokoban.Blocks.BlockGreenBox;
import no.vestein.oving4.Sokoban.Blocks.BlockPlayer;
import no.vestein.oving4.Sokoban.Blocks.BlockRedBox;
import no.vestein.oving4.Sokoban.Blocks.BlockWall;

public class MapGen {

	/*
	 * # = vegg
	 * 0 = tom rute
	 * . = målrute
	 * $ = boks
	 * * = boks på målrute
	 * @ = spiller
	 */
	
	private Map<String, Block> map = new HashMap<>();
	private final int mapX = 50;
	private final int mapY = 50;
	
	
	char[][] level = {
			{'#', '#', '#', '#', '#', '#', '#'},
			{'#', '.', '@', '0', '#', '0', '#'},
			{'#', '$', '*', '0', '$', '0', '#'},
			{'#', '0', '0', '0', '$', '0', '#'},
			{'#', '0', '.', '.', '0', '0', '#'},
			{'#', '0', '0', '*', '0', '0', '#'},
			{'#', '#', '#', '#', '#', '#', '#'}
			};
	
	public Map<String, Block> getMap() {
		return map;
	}
	
	public void generate() {
		Map<String, Block> blocks;
		blocks = generateObjects();
		map = blocks;
	}
	
	public Block getBlock(int x, int y) {
		return map.get(x + "." + y);
	}
	
	public String getPlayerPosition() {
		for (Map.Entry<String, Block> entry : map.entrySet()) {
			if (entry.getValue() instanceof BlockPlayer) {
				return entry.getKey();
			}
		}
		return "";
	}
	
	Map<String, Block> generateObjects() {
		Map<String, Block> map = new HashMap<>();
		for (int i = 0; i < level.length; i++) {
			for (int j = 0; j < level.length; j++) {
				if (level[i][j] == '#') {
					BlockWall wall = new BlockWall(mapX + (j * 20), mapY + (i * 20));
					map.put(j + "." + i, wall);
				} else if (level[i][j] == '*') {
					BlockGreenBox box = new BlockGreenBox(mapX + (j * 20), mapY + (i * 20));
					map.put(j + "." + i, box);
				} else if (level[i][j] == '$') {
					BlockRedBox box = new BlockRedBox(mapX + (j * 20), mapY + (i * 20));
					map.put(j + "." + i, box);
				} else if (level[i][j] == '.') {
					BlockGoal goal = new BlockGoal(mapX + (j * 20), mapY + (i * 20));
					map.put(j + "." + i, goal);
				} else if (level[i][j] == '@') {
					BlockPlayer player = new BlockPlayer(mapX + (j * 20), mapY + (i * 20));
					map.put(j + "." + i + "player", player);
					System.out.println(j + "." + i);
				}
			}
		}
		return map;
	}
	
}
