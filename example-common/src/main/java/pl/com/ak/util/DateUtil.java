package pl.com.ak.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

	private final static DateFormat DATE_WITH_TIME = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss.SSS");
	
	private DateUtil() {
	}
	
	public static DateFormat getDateWithTime() {
		return DATE_WITH_TIME;
	}

	public static String getDateTime() {
		return DateUtil.getDateWithTime().format(new Date());
	}
}
