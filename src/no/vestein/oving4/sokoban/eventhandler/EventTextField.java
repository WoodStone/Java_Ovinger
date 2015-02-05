package no.vestein.oving4.sokoban.eventhandler;

import no.vestein.oving4.sokoban.SokobanFX;
import no.vestein.oving4.sokoban.map.Movement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class EventTextField {

	private static TextField textField  = new TextField();
	
	public static void init() {
	    textField.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent arg0) {
	        	Movement.checkCommand(textField.getText());
	        	if (GameState.checkForWin()) {
					System.out.println("YEEY");
				}
	        }
	    });
	    SokobanFX.shapesPane.getChildren().add(textField);
	}
	
}
