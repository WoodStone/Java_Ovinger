package no.vestein.oving3.rpncalc.operator;

import java.util.Stack;

public class OperatorAddition extends Operator {

	public OperatorAddition() {
		super('+');
	}
	
	@Override
	public void operation(Stack<Double> stack) {
		double n2 = stack.pop();
		double n1 = stack.pop();
		stack.push(n2 + n1);
	}
	
}
