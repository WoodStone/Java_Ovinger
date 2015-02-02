package no.vestein.oving4.Sokoban.Eventhandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class EventTextField {

	private TextField textField  = new TextField();
	
	public void init() {
	    textField.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent arg0) {
	        	Movement.checkCommand(textField.getText());
	        	if (GameState.checkForWin()) {
					System.out.println("YEEY");
				}
	        }
	    });
	}
	
	public TextField getTextField() {
		return textField;
	}
	
}
