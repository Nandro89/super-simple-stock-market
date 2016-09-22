package org.jpmorgan.stock.simplestockmarket.model.impl;

import org.jpmorgan.stock.simplestockmarket.model.CommonStock;

/**
 * This class describs a stock whose symbol is TEA
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
public class TEAStock extends CommonStock {
	public TEAStock() {
		super.setLastDividend(0);
		super.setParValue(100);
	}
}
