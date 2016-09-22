package org.jpmorgan.stock.simplestockmarket.model;

public enum TradeType {
	BUY("BUY"), SELL("SELL");
	
	private String value;
	
	private TradeType(final String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
