package org.jpmorgan.stock.simplestockmarket.peratio;

import static org.junit.Assert.*;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.impl.GINStock;
import org.junit.Test;

public class GINStockPERatioTest {

	@Test
	public void test() {
		Stock stock = new GINStock();
		assertEquals(50.0d, stock.calculatePERatio(10), 0d);
		assertEquals(200.0d, stock.calculatePERatio(20), 0d);
		assertEquals(450.0d, stock.calculatePERatio(30), 0d);
		assertEquals(80000.0d, stock.calculatePERatio(400), 0d);
	}

}
