package org.jpmorgan.stock.simplestockmarket.model;

/**
 * This is an abstract class describing a preferred Stock
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
public abstract class PreferredStock extends Stock {
	/**
	 * This method is the implementation of {@code calculateDividendYield(int)} method for preferred Stocks.
	 */
	@Override
	public double calculateDividendYield(final int price) {
		return ((double)super.getFixedDividend() * super.getParValue()) / price;
	}
}
