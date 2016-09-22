package org.jpmorgan.stock.simplestockmarket.utils;

import java.sql.Timestamp;
import java.util.Calendar;

public class DateUtils {
	public static Timestamp addAmountToTimestampField(final Timestamp ts, final int amount, final int field) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(ts.getTime());
		cal.add(field, amount);
		Timestamp returnValue = new Timestamp(cal.getTimeInMillis());
		return returnValue;
	}
}
