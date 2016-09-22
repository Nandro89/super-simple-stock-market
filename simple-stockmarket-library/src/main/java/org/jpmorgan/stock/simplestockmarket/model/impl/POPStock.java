package org.jpmorgan.stock.simplestockmarket.model.impl;

import org.jpmorgan.stock.simplestockmarket.model.CommonStock;

/**
 * This class describs a stock whose symbol is POP
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
public class POPStock extends CommonStock {
	public POPStock() {
		super.setLastDividend(8);
		super.setParValue(100);
	}
}
