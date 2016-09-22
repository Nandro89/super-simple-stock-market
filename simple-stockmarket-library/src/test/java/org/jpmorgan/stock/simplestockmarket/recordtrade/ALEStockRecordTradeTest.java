package org.jpmorgan.stock.simplestockmarket.recordtrade;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.Trade;
import org.jpmorgan.stock.simplestockmarket.model.TradeType;
import org.jpmorgan.stock.simplestockmarket.model.impl.ALEStock;
import org.jpmorgan.stock.simplestockmarket.service.InMemoryTradeService;
import org.jpmorgan.stock.simplestockmarket.service.TradeService;
import org.jpmorgan.stock.simplestockmarket.utils.DateUtils;
import org.junit.Test;

public class ALEStockRecordTradeTest {

	@Test
	public void test() {
		TradeService service = new InMemoryTradeService();
		Stock stock = new ALEStock();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Trade trade1 = new Trade(stock, DateUtils.addAmountToTimestampField(ts, -1, Calendar.MINUTE), 1, TradeType.BUY, 23);
		service.registerTrade(trade1);
		Trade trade2 = new Trade(stock, DateUtils.addAmountToTimestampField(ts, -15, Calendar.MINUTE), 22, TradeType.BUY, 22);
		service.registerTrade(trade2);
		List<Trade> trades = service.findAllTradesByStockSymbol(stock);
		assertEquals(2, trades.size());
		assertEquals(trade1, trades.get(0));
		assertEquals(trade2, trades.get(1));
		assertNotEquals(trade1, trades.get(1));
		assertEquals(23, trades.get(0).getTradedPrice());
		assertEquals(TradeType.BUY, trades.get(1).getBuySellIndicator());
		assertNotEquals(22, trades.get(0).getSharesQuantity());
	}

}
