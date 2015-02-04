package no.vestein.oving3.rpncalc.operator;

import java.util.Stack;

public class OperatorDivision extends Operator{

	public OperatorDivision() {
		super('/');
	}
	
	@Override
	public void operation(Stack<Double> stack) {
		double n2 = stack.pop();
		double n1 = stack.pop();
		stack.push(n1 / n2);
	}
	
}
