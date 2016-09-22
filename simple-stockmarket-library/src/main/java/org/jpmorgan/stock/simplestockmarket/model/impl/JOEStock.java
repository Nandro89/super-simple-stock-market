package org.jpmorgan.stock.simplestockmarket.model.impl;

import org.jpmorgan.stock.simplestockmarket.model.CommonStock;

/**
 * This class describs a stock whose symbol is JOE
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
public class JOEStock extends CommonStock {
	public JOEStock() {
		super.setLastDividend(13);
		super.setParValue(250);
	}
}
