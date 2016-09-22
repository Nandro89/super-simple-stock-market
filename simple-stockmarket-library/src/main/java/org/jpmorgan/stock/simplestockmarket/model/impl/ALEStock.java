package org.jpmorgan.stock.simplestockmarket.model.impl;

import org.jpmorgan.stock.simplestockmarket.model.CommonStock;

/**
 * This class describs a stock whose symbol is ALE
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
public class ALEStock extends CommonStock {
	public ALEStock() {
		super.setLastDividend(23);
		super.setParValue(60);
	}
}
