package org.jpmorgan.stock.simplestockmarket.peratio;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ALEStockPERatioTest.class, GINStockPERatioTest.class, JOEStockPERatioTest.class,
		POPStockPERatioTest.class, TEAStockPERatioTest.class })
public class PERatioTestSuite {

}
