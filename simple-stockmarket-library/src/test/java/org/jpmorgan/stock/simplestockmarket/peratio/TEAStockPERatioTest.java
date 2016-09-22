package org.jpmorgan.stock.simplestockmarket.peratio;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.impl.TEAStock;
import org.junit.Test;

public class TEAStockPERatioTest {
	private Stock stock;
	
	public TEAStockPERatioTest() {
		stock = new TEAStock();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPrice10Exception() {
		stock.calculatePERatio(10);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPrice20Exception() {
		stock.calculatePERatio(20);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPrice30Exception() {
		stock.calculatePERatio(30);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testPrice400Exception() {
		stock.calculatePERatio(400);
	}

}
