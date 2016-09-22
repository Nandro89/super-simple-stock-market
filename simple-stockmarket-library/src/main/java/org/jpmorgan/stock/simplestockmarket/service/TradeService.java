package org.jpmorgan.stock.simplestockmarket.service;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.Trade;

/**
 * This interface describes the methods the trade services need to implement
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
public interface TradeService {
	/**
	 * Given an input Trade, this method registers it
	 * 
	 * @param trade Input trade to register
	 * @return Returns a boolean. {@code true} if the operation was successful, {@code false} otherwise
	 */
	public abstract boolean registerTrade(final Trade trade);

	public abstract double calculateVolumeWeightedStockPriceInThePreceedingXTime(final Stock stock, final int amount, final int dateFieldToManipulate);
}
