package org.jpmorgan.stock.simplestockmarket.model;

/**
 * This is an abstract class describing a common Stock
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
public abstract class CommonStock extends Stock {
	/**
	 * This method is the implementation of {@code calculateDividendYield(int)} method for common Stocks.
	 */
	@Override
	public double calculateDividendYield(final int price) {
		return (double)super.getLastDividend() / price;
	}
}
