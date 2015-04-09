package no.vestein.oving8;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private String ticker;
	private double kurs;
	
	private List<IStockListener> stockListeners = new ArrayList<>();
	
	public Stock(String ticker, double kurs) {
		this.ticker = ticker;
		this.kurs = kurs;
	}
	
	public void setPrice(double kurs) {
		if (kurs <= 0) throw new IllegalArgumentException();
		for (IStockListener listener : stockListeners) {
			listener.stockPriceChanged(this, this.kurs, kurs);
		}
		this.kurs = kurs;
	}
	
	public String getTicker() {
		return ticker;
	}

	public double getPrice() {
		return kurs;
	}
	
	public void addStockListener(IStockListener stockListener) {
		if (! stockListeners.contains(stockListener)) stockListeners.add(stockListener);
	}
	
	public void removeStockListener(IStockListener stockListener) {
		stockListeners.remove(stockListener);
	}
	
}
