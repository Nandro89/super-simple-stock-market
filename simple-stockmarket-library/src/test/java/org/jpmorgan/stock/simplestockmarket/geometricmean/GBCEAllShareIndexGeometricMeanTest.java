package org.jpmorgan.stock.simplestockmarket.geometricmean;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.Trade;
import org.jpmorgan.stock.simplestockmarket.model.TradeType;
import org.jpmorgan.stock.simplestockmarket.model.impl.ALEStock;
import org.jpmorgan.stock.simplestockmarket.model.impl.GINStock;
import org.jpmorgan.stock.simplestockmarket.model.impl.JOEStock;
import org.jpmorgan.stock.simplestockmarket.model.impl.POPStock;
import org.jpmorgan.stock.simplestockmarket.service.InMemoryTradeService;
import org.jpmorgan.stock.simplestockmarket.service.TradeService;
import org.junit.Test;

public class GBCEAllShareIndexGeometricMeanTest {

	@Test
	public void test() {
		TradeService tradeService = new InMemoryTradeService();
		Stock stock = new ALEStock();
		Timestamp ts = new Timestamp(new Date().getTime());
		Trade trade = new Trade(stock, ts, 1, TradeType.BUY, 12);
		tradeService.registerTrade(trade);
		trade = new Trade(stock, ts, 3, TradeType.SELL, 44);
		tradeService.registerTrade(trade);
		trade = new Trade(stock, ts, 21, TradeType.SELL, 2);
		tradeService.registerTrade(trade);
		trade = new Trade(stock, ts, 432, TradeType.BUY, 43);
		tradeService.registerTrade(trade);
		stock = new GINStock();
		trade = new Trade(stock, ts, 321, TradeType.SELL, 3);
		tradeService.registerTrade(trade);
		trade = new Trade(stock, ts, 321, TradeType.BUY, 87);
		tradeService.registerTrade(trade);
		trade = new Trade(stock, ts, 12, TradeType.BUY, 4);
		tradeService.registerTrade(trade);
		stock = new JOEStock();
		trade = new Trade(stock, ts, 878, TradeType.BUY, 11);
		tradeService.registerTrade(trade);
		stock = new POPStock();
		trade = new Trade(stock, ts, 21323, TradeType.BUY, 44);
		tradeService.registerTrade(trade);
		trade = new Trade(stock, ts, 231, TradeType.SELL, 2);
		tradeService.registerTrade(trade);
		trade = new Trade(stock, ts, 21, TradeType.SELL, 4);
		tradeService.registerTrade(trade);
		trade = new Trade(stock, ts, 6, TradeType.SELL, 65);
		tradeService.registerTrade(trade);
		trade = new Trade(stock, ts, 4, TradeType.SELL, 2);
		tradeService.registerTrade(trade);
		trade = new Trade(stock, ts, 2, TradeType.SELL, 22);
		tradeService.registerTrade(trade);
		List<Trade> trades = tradeService.findAllTradesByStockSymbol(stock);
		assertEquals(11.257401d, tradeService.calculateGBCEAllShareIndexByGeometricMeanOnRegisteredTrades(), 0.000001d);
		assertEquals(10.011168d, tradeService.calculateGBCEAllShareIndexByGeometricMeanOnSpecificTrades(trades), 0.000001d);
	}

}
