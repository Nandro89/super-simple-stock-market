package org.jpmorgan.stock.simplestockmarket.peratio;

import static org.junit.Assert.*;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.impl.ALEStock;
import org.junit.Test;

public class ALEStockPERatioTest {

	@Test
	public void test() {
		Stock stock = new ALEStock();
		assertEquals(4.347826d, stock.calculatePERatio(10), 0.000001d);
		assertEquals(17.391304d, stock.calculatePERatio(20), 0.000001d);
		assertEquals(39.130434d, stock.calculatePERatio(30), 0.000001d);
		assertEquals(6956.521739d, stock.calculatePERatio(400), 0.000001d);
	}

}
