package org.jpmorgan.stock.simplestockmarket.peratio;

import static org.junit.Assert.*;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.impl.JOEStock;
import org.junit.Test;

public class JOEStockPERatioTest {

	@Test
	public void test() {
		Stock stock = new JOEStock();
		assertEquals(7.692307d, stock.calculatePERatio(10), 0.000001d);
		assertEquals(30.769230d, stock.calculatePERatio(20), 0.000001d);
		assertEquals(69.230769d, stock.calculatePERatio(30), 0.000001d);
		assertEquals(12307.692307d, stock.calculatePERatio(400), 0.000001d);
	}

}
