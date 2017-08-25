package pl.com.ak.util;

import org.apache.commons.lang3.StringUtils;

public class ConsolePrinter implements Printer {
	
	public void print(final String msg) {
		System.out.print(msg);
	}

	@Override
	public void println(final String msg)  {
		print(msg + StringUtils.LF);
	}
}
