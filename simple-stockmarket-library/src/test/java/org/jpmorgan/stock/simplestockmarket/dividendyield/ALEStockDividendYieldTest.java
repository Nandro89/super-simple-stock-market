package org.jpmorgan.stock.simplestockmarket.dividendyield;

import static org.junit.Assert.*;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.impl.ALEStock;
import org.junit.Test;

public class ALEStockDividendYieldTest {

	@Test
	public void test() {
		Stock stock = new ALEStock();
		assertEquals(2.3d, stock.calculateDividendYield(10), 0d);
		assertEquals(1.15d, stock.calculateDividendYield(20), 0d);
		assertEquals(0.766666667d, stock.calculateDividendYield(30), 0.000000001d);
		assertEquals(0.0575d, stock.calculateDividendYield(400), 0d);
	}

}
