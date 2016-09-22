package org.jpmorgan.stock.simplestockmarket.peratio;

import static org.junit.Assert.*;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.impl.POPStock;
import org.junit.Test;

public class POPStockPERatioTest {

	@Test
	public void test() {
		Stock stock = new POPStock();
		assertEquals(12.5d, stock.calculatePERatio(10), 0d);
		assertEquals(50.0d, stock.calculatePERatio(20), 0d);
		assertEquals(112.5d, stock.calculatePERatio(30), 0d);
		assertEquals(20000.0d, stock.calculatePERatio(400), 0d);
	}

}
