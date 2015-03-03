package no.vestein.oving6;

import java.util.Iterator;


public class StringGridImpl implements IStringGrid {

	private final boolean rowMajor;
	private final int rowCount;
	private final int coloumnCount;
	private String[][] grid;
	
	public StringGridImpl(int rowCount, int coloumnCount) {
		this(rowCount, coloumnCount, true);
	}
	
	public StringGridImpl(int rowCount, int coloumnCount, boolean rowMajor) {
		this.rowCount = rowCount - 1;
		this.coloumnCount = coloumnCount - 1;
		this.rowMajor = rowMajor;
		this.grid = new String[rowCount][coloumnCount];
	}
	
	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return coloumnCount;
	}

	public String getElement(int row, int column) {
		if (row < 0 || row > rowCount || column < 0 || column > coloumnCount)
			throw new IllegalArgumentException();
		return grid[row][column];
	}

	public void setElement(int row, int column, String element) {
		if (row < 0 || row > rowCount || column < 0 || column > coloumnCount)
			throw new IllegalArgumentException();
		grid[row][column] = element;
	}

	@Override
	public Iterator<String> iterator() {
		return new StringGridIterator(this, rowMajor);
	}

}
