package org.jpmorgan.stock.simplestockmarket.utils;

import java.sql.Timestamp;
import java.util.Comparator;

import org.jpmorgan.stock.simplestockmarket.model.Trade;

public class TradeDateComparator implements Comparator<Trade> {

	@Override
	public int compare(final Trade arg0, final Trade arg1) {
		Timestamp firstTradeComparator = arg0.getTradeDate();
		Timestamp secondTradeComparator = arg1.getTradeDate();
		return firstTradeComparator.compareTo(secondTradeComparator);
	}

}
