package org.jpmorgan.stock.simplestockmarket.recordtrade;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.Trade;
import org.jpmorgan.stock.simplestockmarket.model.TradeType;
import org.jpmorgan.stock.simplestockmarket.model.impl.ALEStock;
import org.jpmorgan.stock.simplestockmarket.model.impl.GINStock;
import org.jpmorgan.stock.simplestockmarket.model.impl.JOEStock;
import org.jpmorgan.stock.simplestockmarket.service.InMemoryTradeService;
import org.jpmorgan.stock.simplestockmarket.service.TradeService;
import org.jpmorgan.stock.simplestockmarket.utils.DateUtils;
import org.junit.Test;

public class VariousStocksRecordTradeTest {

	@Test
	public void test() {
		TradeService service = new InMemoryTradeService();
		Stock aleStock = new ALEStock();
		Stock ginStock = new GINStock();
		Stock joeStock = new JOEStock();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Trade trade1 = new Trade(aleStock, DateUtils.addAmountToTimestampField(ts, -1, Calendar.MINUTE), 1, TradeType.BUY, 23);
		service.registerTrade(trade1);
		Trade trade2 = new Trade(aleStock, DateUtils.addAmountToTimestampField(ts, -15, Calendar.MINUTE), 22, TradeType.BUY, 22);
		service.registerTrade(trade2);
		Trade trade3 = new Trade(ginStock, DateUtils.addAmountToTimestampField(ts, -1, Calendar.MINUTE), 2354, TradeType.SELL, 2132);
		service.registerTrade(trade3);
		Trade trade4 = new Trade(ginStock, DateUtils.addAmountToTimestampField(ts, -15, Calendar.MINUTE), 2112, TradeType.BUY, 54532);
		service.registerTrade(trade4);
		Trade trade5 = new Trade(joeStock, DateUtils.addAmountToTimestampField(ts, -1, Calendar.MINUTE), 22, TradeType.BUY, 546);
		service.registerTrade(trade5);
		Trade trade6 = new Trade(joeStock, DateUtils.addAmountToTimestampField(ts, -15, Calendar.MINUTE), 184, TradeType.SELL, 22);
		service.registerTrade(trade6);
		Trade trade7 = new Trade(joeStock, DateUtils.addAmountToTimestampField(ts, -1, Calendar.MINUTE), 43323254, TradeType.BUY, 212123);
		service.registerTrade(trade7);
		Trade trade8 = new Trade(joeStock, DateUtils.addAmountToTimestampField(ts, -15, Calendar.MINUTE), 32, TradeType.BUY, 444);
		service.registerTrade(trade8);
		List<Trade> aleTrades = service.findAllTradesByStockSymbol(aleStock);
		assertEquals(2, aleTrades.size());
		assertEquals(trade1, aleTrades.get(0));
		assertEquals(trade2, aleTrades.get(1));
		assertNotEquals(trade7, aleTrades.get(1));
		assertEquals(23, aleTrades.get(0).getTradedPrice());
		assertEquals(TradeType.BUY, aleTrades.get(1).getBuySellIndicator());
		assertNotEquals(22, aleTrades.get(0).getSharesQuantity());
		List<Trade> ginTrades = service.findAllTradesByStockSymbol(ginStock);
		assertEquals(2, ginTrades.size());
		assertEquals(trade3, ginTrades.get(0));
		assertEquals(trade4, ginTrades.get(1));
		assertNotEquals(trade1, ginTrades.get(1));
		assertEquals(2132, ginTrades.get(0).getTradedPrice());
		assertEquals(TradeType.BUY, ginTrades.get(1).getBuySellIndicator());
		assertNotEquals(2112, ginTrades.get(0).getSharesQuantity());
		List<Trade> joeTrades = service.findAllTradesByStockSymbol(joeStock);
		assertEquals(4, joeTrades.size());
		assertEquals(trade5, joeTrades.get(0));
		assertEquals(trade6, joeTrades.get(1));
		assertEquals(trade7, joeTrades.get(2));
		assertEquals(trade8, joeTrades.get(3));
		assertNotEquals(trade4, joeTrades.get(1));
		assertNotEquals(trade1, joeTrades.get(3));
		assertEquals(546, joeTrades.get(0).getTradedPrice());
		assertEquals(TradeType.SELL, joeTrades.get(1).getBuySellIndicator());
		assertNotEquals(184, joeTrades.get(2).getSharesQuantity());
		assertNotEquals(ts, joeTrades.get(3).getTradeDate());
	}

}
