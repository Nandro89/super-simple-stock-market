package org.jpmorgan.stock.simplestockmarket.recordtrade;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ALEStockRecordTradeTest.class, GINStockRecordTradeTest.class, VariousStocksRecordTradeTest.class })
public class RecordTradeTestSuite {

}
