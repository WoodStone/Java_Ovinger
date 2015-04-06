package no.vestein.oving9.observable;

import java.util.Scanner;

public class ObservableListProgram implements IObservableListListener {
	
	private ObservableHighscoreList list;
	
	public void init() {
		list = new ObservableHighscoreList(10);
		list.addObservableListListener(this);
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			list.addResult(scanner.nextInt());
		}
		scanner.close();
	}

	public void listChanged(ObservableList list, int n) {
		System.out.print(n + ": ");
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		ObservableListProgram program = new ObservableListProgram();
		program.init();
		program.run();
	}

}
