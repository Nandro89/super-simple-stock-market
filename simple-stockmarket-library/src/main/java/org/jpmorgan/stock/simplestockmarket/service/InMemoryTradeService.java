package org.jpmorgan.stock.simplestockmarket.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.Trade;
import org.jpmorgan.stock.simplestockmarket.utils.DateUtils;
import org.jpmorgan.stock.simplestockmarket.utils.TradeDateComparator;
import org.springframework.stereotype.Component;

/**
 * This class implements the basic interface for the trade services.
 * Every trade is kept and manipulated in memory when using this service.
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
@Component
public class InMemoryTradeService implements TradeService {
	private Map<Class<? extends Stock>, List<Trade>> trades = new HashMap<Class<? extends Stock>, List<Trade>>();

	@Override
	public boolean registerTrade(final Trade trade) {
		Class<? extends Stock> stockClass = trade.getStockTraded().getClass();
		List<Trade> tradesList;
		if(!trades.containsKey(stockClass)) {
			tradesList = new ArrayList<Trade>();
			trades.put(stockClass, tradesList);
		}
		tradesList = trades.get(stockClass);
		tradesList.add(trade);
		trades.put(stockClass, tradesList);
		return true;
	}
	
	private List<Trade> getStockTradesSinceADate(final Class<? extends Stock> stockClass, final Timestamp limitDate) {
		List<Trade> stockTrades = trades.get(stockClass);
		//I'm applying a reverse order before sorting so I get a descending date order
		Collections.sort(stockTrades, Collections.reverseOrder(new TradeDateComparator()));
		List<Trade> filteredTrades = new ArrayList<Trade>();
		
		for(Trade trade : stockTrades) {
			/*being the list ordered by trade date, I can go through it and break when the traded date is before the limit date I
			  need to reach*/
			if(trade.getTradeDate().before(limitDate)) {
				break;
			}
			filteredTrades.add(trade);
		}
		return filteredTrades;
	}

	@Override
	public double calculateVolumeWeightedStockPriceInThePreceedingXTime(final Stock stock, final int amount, final int dateFieldToManipulate) {
		Timestamp now = new Timestamp(new Date().getTime());
		Timestamp xTimeAgo = DateUtils.addAmountToTimestampField(now, (amount * -1), dateFieldToManipulate);
		List<Trade> trades = getStockTradesSinceADate(stock.getClass(), xTimeAgo);
		double volumeWightedStockPrice = 0d;
		int tradedPriceQuantitySum = 0;
		int quantitySum = 0;
		for(Trade trade : trades) {
			quantitySum += trade.getSharesQuantity();
			tradedPriceQuantitySum += trade.getTradedPrice() * trade.getSharesQuantity();
		}
		volumeWightedStockPrice = (double)tradedPriceQuantitySum/quantitySum;
		return volumeWightedStockPrice;
	}

	@Override
	public List<Trade> findAllTradesByStockSymbol(final Stock stock) {
		return trades.get(stock.getClass());
	}

	@Override
	public double calculateGBCEAllShareIndexByGeometricMeanOnRegisteredTrades() {
		List<Trade> allTrades = new ArrayList<Trade>();
		for(Class<? extends Stock> key : trades.keySet()) {
			allTrades.addAll(trades.get(key));
		}
		return calculateGBCEAllShareIndexByGeometricMeanOnInputTrades(allTrades);
	}

	@Override
	public double calculateGBCEAllShareIndexByGeometricMeanOnSpecificTrades(final List<Trade> trades) {
		return calculateGBCEAllShareIndexByGeometricMeanOnInputTrades(trades);
	}
	
	private double calculateGBCEAllShareIndexByGeometricMeanOnInputTrades(final List<Trade> trades) {
		long total = 1;
		for(Trade trade : trades) {
			total *= trade.getTradedPrice();
		}
		return Math.pow((double)total, (1d/trades.size()));
	}
}
