package org.jpmorgan.stock.simplestockmarket.dividendyield;

import static org.junit.Assert.*;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.impl.POPStock;
import org.junit.Test;

public class POPStockDividendYieldTest {

	@Test
	public void test() {
		Stock stock = new POPStock();
		assertEquals(0.8d, stock.calculateDividendYield(10), 0d);
		assertEquals(0.4d, stock.calculateDividendYield(20), 0d);
		assertEquals(0.266666667d, stock.calculateDividendYield(30), 0.000000001d);
		assertEquals(0.02d, stock.calculateDividendYield(400), 0d);
	}

}
