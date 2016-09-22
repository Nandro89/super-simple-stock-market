package org.jpmorgan.stock.simplestockmarket.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * This class describs a trade
 * 
 * @author Adriano Ascione
 * @version 1.0
 * @since 21/09/2016
 *
 */
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Trade {
	private Stock stockTraded;
	private Timestamp tradeDate;
	private int sharesQuantity;
	private TradeType buySellIndicator;
	private int tradedPrice;
}
