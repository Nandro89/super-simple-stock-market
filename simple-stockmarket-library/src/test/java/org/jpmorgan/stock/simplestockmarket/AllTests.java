package org.jpmorgan.stock.simplestockmarket;

import org.jpmorgan.stock.simplestockmarket.dividendyield.DividendYieldTestSuite;
import org.jpmorgan.stock.simplestockmarket.peratio.PERatioTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DividendYieldTestSuite.class, PERatioTestSuite.class })
public class AllTests {

}
