package org.jpmorgan.stock.simplestockmarket.volumeweightedstockprice;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.Trade;
import org.jpmorgan.stock.simplestockmarket.model.TradeType;
import org.jpmorgan.stock.simplestockmarket.model.impl.ALEStock;
import org.jpmorgan.stock.simplestockmarket.model.impl.GINStock;
import org.jpmorgan.stock.simplestockmarket.service.InMemoryTradeService;
import org.jpmorgan.stock.simplestockmarket.service.TradeService;
import org.jpmorgan.stock.simplestockmarket.utils.DateUtils;
import org.junit.Test;

public class GINStockVolumeWeightedStockPriceTest {

	@Test
	public void test() {
		TradeService service = new InMemoryTradeService();
		Stock aleStock = new ALEStock();
		Stock ginStock = new GINStock();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Trade trade = new Trade(aleStock, DateUtils.addAmountToTimestampField(ts, -1, Calendar.MINUTE), 1, TradeType.BUY, 23);
		service.registerTrade(trade);
		trade = new Trade(aleStock, DateUtils.addAmountToTimestampField(ts, -2, Calendar.MINUTE), 4, TradeType.BUY, 12);
		service.registerTrade(trade);
		trade = new Trade(aleStock, DateUtils.addAmountToTimestampField(ts, -3, Calendar.MINUTE), 6, TradeType.BUY, 65);
		service.registerTrade(trade);
		trade = new Trade(aleStock, DateUtils.addAmountToTimestampField(ts, -10, Calendar.MINUTE), 15, TradeType.BUY, 543);
		service.registerTrade(trade);
		trade = new Trade(aleStock, DateUtils.addAmountToTimestampField(ts, -21, Calendar.MINUTE), 75, TradeType.BUY, 544);
		service.registerTrade(trade);
		trade = new Trade(aleStock, DateUtils.addAmountToTimestampField(ts, -33, Calendar.MINUTE), 542, TradeType.BUY, 54354);
		service.registerTrade(trade);
		trade = new Trade(ginStock, DateUtils.addAmountToTimestampField(ts, -3, Calendar.MINUTE), 321, TradeType.SELL, 432);
		service.registerTrade(trade);
		trade = new Trade(ginStock, DateUtils.addAmountToTimestampField(ts, -2, Calendar.MINUTE), 43, TradeType.BUY, 432);
		service.registerTrade(trade);
		trade = new Trade(ginStock, DateUtils.addAmountToTimestampField(ts, -4, Calendar.MINUTE), 76, TradeType.SELL, 4543);
		service.registerTrade(trade);
		trade = new Trade(ginStock, DateUtils.addAmountToTimestampField(ts, -22, Calendar.MINUTE), 2, TradeType.BUY, 43);
		service.registerTrade(trade);
		trade = new Trade(ginStock, DateUtils.addAmountToTimestampField(ts, -1, Calendar.MINUTE), 21, TradeType.BUY, 654);
		service.registerTrade(trade);
		double volumeWeightedStockPrice = service.calculateVolumeWeightedStockPriceInThePreceedingXTime(ginStock, 15, Calendar.MINUTE);
		assertEquals(1119.848156d, volumeWeightedStockPrice, 0.000001d);
	}

}
