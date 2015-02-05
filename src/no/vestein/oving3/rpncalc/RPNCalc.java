package no.vestein.oving3.rpncalc;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import no.vestein.oving3.rpncalc.operator.IOperator;
import no.vestein.oving3.rpncalc.operator.Operator;
import no.vestein.oving3.rpncalc.operator.OperatorAddition;
import no.vestein.oving3.rpncalc.operator.OperatorDivision;
import no.vestein.oving3.rpncalc.operator.OperatorMultiplication;
import no.vestein.oving3.rpncalc.operator.OperatorSubtraction;
import no.vestein.oving3.rpncalc.operator.OperatorSwap;

public class RPNCalc {

	private Stack<Double> numbers = new Stack<Double>();
	private List<IOperator> operators = Arrays.asList(
			new OperatorAddition(),
			new OperatorSubtraction(),
			new OperatorMultiplication(),
			new OperatorDivision(),
			new OperatorSwap()
			);

	public int getSize() {
		return numbers.size();
	}
	
	public void push(double n) {
		numbers.push(n);
	}
	
	public double pop() {
		return numbers.pop();
	}
	
	public double peek(int n) {
		try {
			return numbers.get(numbers.size() - 1 - n);
		} catch (IndexOutOfBoundsException e) {
			return Double.NaN;
		}
		
	}
	
	public void performOperation(char op) {
		for (int i = 0; i < operators.size(); i++) {
			Operator operator = (Operator) operators.get(i);
			if (op == operator.getOperator()) {
				operator.operation(numbers);
			}
		}
	}
}
