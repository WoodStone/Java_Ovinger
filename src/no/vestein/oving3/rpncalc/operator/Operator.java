package no.vestein.oving3.rpncalc.operator;

import java.util.Stack;

public class Operator implements IOperator {

	private char operator;
	
	public Operator(char operator) {
		this.operator = operator;
	}
	
	public char getOperator() {
		return operator;
	}
	
	public void operation(Stack<Double> stack) {
		
	}
	
}
