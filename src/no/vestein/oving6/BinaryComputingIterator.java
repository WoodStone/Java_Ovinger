package no.vestein.oving6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;

public class BinaryComputingIterator implements Iterator<Double> {

	private final Iterator<Double> iterator1;
	private final Iterator<Double> iterator2;
	private final Double default1;
	private final Double default2;
	private final BinaryOperator<Double> operator;
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, Double default1, Double default2, BinaryOperator<Double> operator) {
		this.iterator1 = iterator1;
		this.iterator2 = iterator2;
		this.default1 = default1;
		this.default2 = default2;
		this.operator = operator;
	}
	
	public BinaryComputingIterator(Iterator<Double> iterator1, Iterator<Double> iterator2, BinaryOperator<Double> operator) {
		this(iterator1, iterator2, null, null, operator);
	}

	@Override
	public boolean hasNext() {
		return
				(iterator1.hasNext() && iterator2.hasNext()) ||
				(!iterator1.hasNext() && default1 != null && iterator2.hasNext()) ||
				(!iterator2.hasNext() && default2 != null && iterator1.hasNext());
	}

	@Override
	public Double next() {
		if (! hasNext()) throw new NoSuchElementException();
		Double val1 = default1;
		Double val2 = default2;
		if (iterator1.hasNext()) val1 = iterator1.next();
		if (iterator2.hasNext()) val2 = iterator2.next();
		return operator.apply(val1, val2);
	}
	
}
