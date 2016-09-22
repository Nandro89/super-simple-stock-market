package org.jpmorgan.stock.simplestockmarket.model;

import lombok.Getter;
import lombok.Setter;

/**
 * This is an abstract class describing a generic Stock
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
@Getter
@Setter
public abstract class Stock {
	private int lastDividend;
	private double fixedDividend;
	private int parValue;
	
	/**
	 * This method calculates the dividend yield based on the input price.
	 * Since the formula depends on stock type, this method is abstract and its implementation
	 * delegated to the specific types extending this class
	 * 
	 * @param price Input price to calculate the dividend upon
	 * @return Returns the calculated dividend
	 */
	public abstract double calculateDividendYield(final int price);

	/**
	 * This method calculates the P/E Ratio based on the input price.
	 * Unlike {@code calculateDividendYield(int)} method, this one is already implemented as
	 * its formula is unique and does not depend on stock type.
	 * The formula divides the output of {@code calculateDividendYield(int)} method, so if it's
	 * 0, an exception is thrown
	 * 
	 * @param price Input price to calculate P/E Ration upon
	 * @return Returns the calculated P/E Ratio
	 * @throws IllegalArgumentException This method throws an IllegalArgumentException if, based on the
	 *                                  input price, the calculatedDividendYield of this stock is 0
	 */
	public double calculatePERatio(final int price) throws IllegalArgumentException {
		double dividend = calculateDividendYield(price);
		if(dividend == 0d) {
			throw new IllegalArgumentException("Dividend cannot be 0");
		}
		return (double)price / dividend;
	}
}
