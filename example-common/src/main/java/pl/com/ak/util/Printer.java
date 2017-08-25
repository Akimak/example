package pl.com.ak.util;

import java.io.IOException;

public interface Printer {
	void print(String msg) throws IOException;
	void println(String msg) throws IOException;
}
