package org.jpmorgan.stock.simplestockmarket.volumeweightedstockprice;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.Calendar;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.Trade;
import org.jpmorgan.stock.simplestockmarket.model.TradeType;
import org.jpmorgan.stock.simplestockmarket.model.impl.ALEStock;
import org.jpmorgan.stock.simplestockmarket.service.InMemoryTradeService;
import org.jpmorgan.stock.simplestockmarket.service.TradeService;
import org.jpmorgan.stock.simplestockmarket.utils.DateUtils;
import org.junit.Test;

public class ALEStockVolumeWeightedStockPriceTest {

	@Test
	public void test() {
		TradeService service = new InMemoryTradeService();
		Stock stock = new ALEStock();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Trade trade = new Trade(stock, DateUtils.addAmountToTimestampField(ts, -1, Calendar.MINUTE), 1, TradeType.BUY, 23);
		service.registerTrade(trade);
		trade = new Trade(stock, DateUtils.addAmountToTimestampField(ts, -2, Calendar.MINUTE), 4, TradeType.BUY, 12);
		service.registerTrade(trade);
		trade = new Trade(stock, DateUtils.addAmountToTimestampField(ts, -3, Calendar.MINUTE), 6, TradeType.BUY, 65);
		service.registerTrade(trade);
		trade = new Trade(stock, DateUtils.addAmountToTimestampField(ts, -10, Calendar.MINUTE), 15, TradeType.BUY, 543);
		service.registerTrade(trade);
		trade = new Trade(stock, DateUtils.addAmountToTimestampField(ts, -21, Calendar.MINUTE), 75, TradeType.BUY, 544);
		service.registerTrade(trade);
		trade = new Trade(stock, DateUtils.addAmountToTimestampField(ts, -33, Calendar.MINUTE), 542, TradeType.BUY, 54354);
		service.registerTrade(trade);
		double volumeWeightedStockPrice = service.calculateVolumeWeightedStockPriceInThePreceedingXTime(stock, 15, Calendar.MINUTE);
		assertEquals(331d, volumeWeightedStockPrice, 0d);
	}

}
