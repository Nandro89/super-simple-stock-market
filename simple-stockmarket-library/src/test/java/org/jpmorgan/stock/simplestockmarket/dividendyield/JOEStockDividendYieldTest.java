package org.jpmorgan.stock.simplestockmarket.dividendyield;

import static org.junit.Assert.*;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.impl.JOEStock;
import org.junit.Test;

public class JOEStockDividendYieldTest {

	@Test
	public void test() {
		Stock stock = new JOEStock();
		assertEquals(1.3d, stock.calculateDividendYield(10), 0d);
		assertEquals(0.65d, stock.calculateDividendYield(20), 0d);
		assertEquals(0.433333333d, stock.calculateDividendYield(30), 0.000000001d);
		assertEquals(0.0325d, stock.calculateDividendYield(400), 0d);
	}

}
