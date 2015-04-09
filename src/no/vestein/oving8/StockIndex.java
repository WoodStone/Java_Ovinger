package no.vestein.oving8;

import java.util.ArrayList;
import java.util.List;

public class StockIndex implements IStockListener {
	
	private String name;
	private double index = 0;
	private List<Stock> stocks = new ArrayList<>();

	public StockIndex(String name, Stock... stocks) {
		this.name = name;
		for (Stock stock : stocks) {
			this.stocks.add(stock);
			stock.addStockListener(this);
			index += stock.getPrice();
		}
	}
	
	public void addStock(Stock stock) {
		if (! stocks.contains(stock)) {
			stocks.add(stock);
			stock.addStockListener(this);
			index += stock.getPrice();
		} 
	}
	
	public void removeStock(Stock stock) {
		if (stocks.contains(stock)) {
			stocks.remove(stock);
			stock.removeStockListener(this);
			index -= stock.getPrice();
		}
	}
	
	public double getIndex() {
		return index;
	}

	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice) {
		index += newPrice - oldPrice;
	}
	
}
