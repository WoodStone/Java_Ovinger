package no.vestein.oving8;

public interface IStockListener {
	
	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice);

}
