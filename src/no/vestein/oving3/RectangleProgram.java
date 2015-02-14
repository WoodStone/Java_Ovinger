package no.vestein.oving3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RectangleProgram {
	
	private static Map<String, Rectangle> map = new HashMap<>();

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("new [rectangle]");
		System.out.println("[rectangle] + [command]");
		System.out.println("commands: add x y | contains x y | getminx | getmax | getminy | getmaxy | getheight | getwidth");
		System.out.println("commands2: addr [Rectangle] | intersects [Rectangle] | containsr [Rectangle]");
		System.out.println("commands3: intersection [Rectangle] [new Rectangle] | union [Rectangle] [new Rectangle]");
		while (scanner.hasNextLine()) {
			String[] input = scanner.nextLine().split(" ");
			
			if (input[0].equals("new")) {
				map.put(input[1], new Rectangle());
			} else {
				try {
					Rectangle rect = map.get(input[0]);
					doCommand(rect, input);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
				}
			}
		}
		scanner.close();
	}

	private static void doCommand(Rectangle rect, String[] input) {
		
		String command = input[1].toLowerCase();
		
		if (command.equals("add")) {
			rect.add(Integer.valueOf(input[2]), Integer.valueOf(input[3]));
		} else if (command == "contains") {
			System.out.println(rect.contains(Integer.valueOf(input[2]), Integer.valueOf(input[3])));
		} else if (command.equals("addr")) {
			rect.add(map.get(input[2]));
		} else if (command.equals("intersects")) {
			System.out.println(rect.intersects(map.get(input[2])));
		} else if (command.equals("containsr")) {
			System.out.println(rect.contains(map.get(input[2])));
		} else if (command.equals("intersection")) {
			Rectangle newRect = rect.intersection(map.get(input[2]));
			map.put(input[3], newRect);
		} else if (command.equals("union")){
			Rectangle newRect = rect.union(map.get(input[2]));
			map.put(input[3], newRect);
		} else if (command.equals("getminx")) {
			System.out.println(rect.getMinX());
		} else if (command.equals("getmaxx")) {
			System.out.println(rect.getMaxX());
		} else if (command.equals("getminy")) {
			System.out.println(rect.getMinY());
		} else if (command.equals("getmaxy")) {
			System.out.println(rect.getMaxY());
		} else if (command.equals("getheight")) {
			System.out.println(rect.getHeight());
		} else if (command.equals("getwidth")) {
			System.out.println(rect.getWidth());
		}
	}
	
}
