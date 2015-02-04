package no.vestein.oving3.rpncalc.operator;

import java.util.Stack;

public class OperatorSwap extends Operator{

	public OperatorSwap() {
		super('~');
	}
	
	@Override
	public void operation(Stack<Double> stack) {
		double n2 = stack.pop();
		double n1 = stack.pop();
		stack.push(n2);
		stack.push(n1);
	}
	
}
