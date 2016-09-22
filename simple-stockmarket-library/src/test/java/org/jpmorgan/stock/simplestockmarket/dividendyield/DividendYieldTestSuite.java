package org.jpmorgan.stock.simplestockmarket.dividendyield;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ALEStockDividendYieldTest.class, GINStockDividendYieldTest.class, JOEStockDividendYieldTest.class,
		POPStockDividendYieldTest.class, TEAStockDividendYieldTest.class })
public class DividendYieldTestSuite {

}
