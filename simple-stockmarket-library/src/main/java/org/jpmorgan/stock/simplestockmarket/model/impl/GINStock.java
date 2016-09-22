package org.jpmorgan.stock.simplestockmarket.model.impl;

import org.jpmorgan.stock.simplestockmarket.model.PreferredStock;

/**
 * This class describs a stock whose symbol is GIN
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
public class GINStock extends PreferredStock {
	public GINStock() {
		super.setLastDividend(8);
		super.setFixedDividend(0.02d);
		super.setParValue(100);
	}
}
