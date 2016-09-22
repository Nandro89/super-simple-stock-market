package org.jpmorgan.stock.simplestockmarket.restcontroller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jpmorgan.stock.simplestockmarket.model.Stock;
import org.jpmorgan.stock.simplestockmarket.model.StockType;
import org.jpmorgan.stock.simplestockmarket.model.Trade;
import org.jpmorgan.stock.simplestockmarket.model.TradeType;
import org.jpmorgan.stock.simplestockmarket.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stockMarket")
public class StockMarketRestController {
	@Autowired
	private TradeService tradeService;
	
	@RequestMapping("/calculateDividendYield")
	public Double calculateDividendYield(@RequestParam final String stockSymbol, @RequestParam final int stockPrice) throws InstantiationException, IllegalAccessException {
		Stock stock = StockType.valueOf(stockSymbol).getStockClass().newInstance();
		return stock.calculateDividendYield(stockPrice);
	}
	
	@RequestMapping("/calculatePERatio")
	public Double calculatePERatio(@RequestParam final String stockSymbol, @RequestParam final int stockPrice) throws InstantiationException, IllegalAccessException {
		Stock stock = StockType.valueOf(stockSymbol).getStockClass().newInstance();
		return stock.calculatePERatio(stockPrice);
	}
	
	@RequestMapping("/registerTrade")
	public Boolean registerTrade(@RequestParam final String stockSymbol, @RequestParam final String dateString, @RequestParam final int sharesQuantity, @RequestParam final String buyOrSell, @RequestParam final int tradedPrice) throws InstantiationException, IllegalAccessException, ParseException {
		Stock stock = StockType.valueOf(stockSymbol).getStockClass().newInstance();
		TradeType tradeType = TradeType.valueOf(buyOrSell);
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(dateString);
		Trade trade = new Trade(stock, new Timestamp(date.getTime()), sharesQuantity, tradeType, tradedPrice);
		tradeService.registerTrade(trade);
		return true;
	}
	
	@RequestMapping("/getAllTrades")
	public List<Trade> registerTrade(@RequestParam final String stockSymbol) throws InstantiationException, IllegalAccessException {
		return tradeService.findAllTradesByStockSymbol(StockType.valueOf(stockSymbol).getStockClass().newInstance());
	}
	
	@RequestMapping("/calculateVolumeWeightedStockPrice")
	public Double calculateVolumeWeightedStockPrice(@RequestParam final String stockSymbol, @RequestParam final int amountOfMinutesToConsider) throws InstantiationException, IllegalAccessException {
		Stock stock = StockType.valueOf(stockSymbol).getStockClass().newInstance();
		return tradeService.calculateVolumeWeightedStockPriceInThePreceedingXTime(stock, amountOfMinutesToConsider, Calendar.MINUTE);
	}
	
	@RequestMapping("/getGBCEAllShareIndexGeometricMean")
	public Double getGBCEAllShareIndexGeometricMean() throws InstantiationException, IllegalAccessException {
		return tradeService.calculateGBCEAllShareIndexByGeometricMeanOnRegisteredTrades();
	}
}
