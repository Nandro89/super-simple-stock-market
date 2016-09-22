package org.jpmorgan.stock.simplestockmarket.model;

import org.jpmorgan.stock.simplestockmarket.model.impl.ALEStock;
import org.jpmorgan.stock.simplestockmarket.model.impl.GINStock;
import org.jpmorgan.stock.simplestockmarket.model.impl.JOEStock;
import org.jpmorgan.stock.simplestockmarket.model.impl.POPStock;
import org.jpmorgan.stock.simplestockmarket.model.impl.TEAStock;

public enum StockType {
	ALE(ALEStock.class, "ALE"), GIN(GINStock.class, "GIN"), JOE(JOEStock.class, "JOE"), POP(POPStock.class, "POP"), TEA(TEAStock.class, "TEA");
	
	private Class<? extends Stock> stockType;
	private String value;
	
	private StockType(final Class<? extends Stock> stockType, final String value) {
		this.stockType = stockType;
		this.value = value;
	}
	
	public Class<? extends Stock> getStockClass() {
		return stockType;
	}
	
	public String getStockSymbol() {
		return value;
	}
}
