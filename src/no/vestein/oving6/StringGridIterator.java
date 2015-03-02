package no.vestein.oving6;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String>{

	private final IStringGrid stringGrid;
	private final boolean rowMajor;
	private int rowPos = 0;
	private int coloumnPos = 0;
	
	public StringGridIterator(IStringGrid stringGrid, boolean rowMajor) {
		this.stringGrid = stringGrid;
		this.rowMajor = rowMajor;
	}
	
	@Override
	public boolean hasNext() {
		if (rowPos > stringGrid.getRowCount() || coloumnPos > stringGrid.getColumnCount()) return false;
		try {
			stringGrid.getElement(rowPos, coloumnPos);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	@Override
	public String next() {
		String element = stringGrid.getElement(rowPos, coloumnPos);;
		if (rowMajor) {
			coloumnPos++;
			if (coloumnPos > stringGrid.getColumnCount()) {
				coloumnPos = 0;
				rowPos++;
			}
		} else {
			rowPos++;
			if (rowPos > stringGrid.getRowCount()) {
				rowPos = 0;
				coloumnPos++;
			}
		}
		return element;
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
