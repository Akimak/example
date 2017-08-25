package pl.com.ak.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class FilePrinter implements Printer {
	private final FileWriter fileWriter;

	public FilePrinter(final File file) throws IOException {
		this.fileWriter = new FileWriter(file);
	}

	@Override
	public void print(final String msg) throws IOException {
		fileWriter.write(msg);
		fileWriter.flush();
	}

	@Override
	public void println(final String msg) throws IOException {
		print(msg + StringUtils.LF);
	}
}
