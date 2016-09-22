package org.jpmorgan.stock.simplestockmarket.dividendyield;

import static org.junit.Assert.*;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.impl.GINStock;
import org.junit.Test;

public class GINStockDividendYieldTest {

	@Test
	public void test() {
		Stock stock = new GINStock();
		assertEquals(0.2d, stock.calculateDividendYield(10), 0d);
		assertEquals(0.1d, stock.calculateDividendYield(20), 0d);
		assertEquals(0.066666667d, stock.calculateDividendYield(30), 0.000000001d);
		assertEquals(0.005d, stock.calculateDividendYield(400), 0d);
	}

}
