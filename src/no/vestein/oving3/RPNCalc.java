package no.vestein.oving3;

import java.util.ArrayList;

public class RPNCalc {

	private ArrayList<String> stack = new ArrayList<String>();
	
	public void push(double n) {
		stack.add(String.valueOf(n));
	}
	
	public double pop() {
		if (stack.size() == 0) return Double.NaN;
		double last = Double.parseDouble(stack.get(stack.size() - 1));
		stack.remove(stack.size() - 1);
		return last;
	}
	
	public double peek(int n) {
		try {
			return Double.parseDouble(stack.get(stack.size() - 1 - n));
		} catch (IndexOutOfBoundsException e) {
			return Double.NaN;
		}
	}
	
	public int getSize() {
		return stack.size();
	}
	
	public void performOperation(char operator) {
		double n1 = pop();
		double n2 = pop();
		if (Double.isNaN(n1) || Double.isNaN(n2)) {
			if (!Double.isNaN(n1)) {
				push(n1);
			} else {
				push(n2);
			}
		} else {
			if (operator == '+') {
				push(n2 + n1);
			} else if (operator == '-') {
				push(n2 - n1);
			} else if (operator == '*') {
				push(n2 * n1);
			} else if (operator == '/') {
				push(n2 / n1);
			} else if (operator == '~') {
				push(n1);
				push(n2);
			} else if (operator == 't') {
				
			}
		}
	}
	
	@Override
	public String toString() {
		return "RPNCalc [stack=" + stack + "]";
	}

	public static void main(String[] args) {
		RPNCalc test = new RPNCalc();
		test.push(10);
		test.push(5);
		test.push(3);
		test.push(8);
		System.out.println(test);
		test.performOperation('+');
		System.out.println(test);
		test.performOperation('*');
		System.out.println(test);
		test.performOperation('/');
		System.out.println(test);
		test.performOperation('/');
		System.out.println(test);
	}
	
}
