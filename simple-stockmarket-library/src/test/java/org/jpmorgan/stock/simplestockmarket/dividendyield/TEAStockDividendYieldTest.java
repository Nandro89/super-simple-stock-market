package org.jpmorgan.stock.simplestockmarket.dividendyield;

import static org.junit.Assert.*;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.impl.TEAStock;
import org.junit.Test;

public class TEAStockDividendYieldTest {

	@Test
	public void test() {
		Stock stock = new TEAStock();
		assertEquals(0d, stock.calculateDividendYield(10), 0d);
		assertEquals(0d, stock.calculateDividendYield(20), 0d);
		assertEquals(0d, stock.calculateDividendYield(30), 0d);
		assertEquals(0d, stock.calculateDividendYield(400), 0d);
	}

}
