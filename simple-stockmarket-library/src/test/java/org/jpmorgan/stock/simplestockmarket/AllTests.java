package org.jpmorgan.stock.simplestockmarket;

import org.jpmorgan.stock.simplestockmarket.dividendyield.DividendYieldTestSuite;
import org.jpmorgan.stock.simplestockmarket.peratio.PERatioTestSuite;
import org.jpmorgan.stock.simplestockmarket.recordtrade.RecordTradeTestSuite;
import org.jpmorgan.stock.simplestockmarket.volumeweightedstockprice.VolumeWeightedStockPriceTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DividendYieldTestSuite.class, PERatioTestSuite.class, VolumeWeightedStockPriceTestSuite.class, RecordTradeTestSuite.class })
public class AllTests {

}
