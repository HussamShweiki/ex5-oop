package filesprocessor.filter.subfilters;

import filesprocessor.filter.Filter;

import java.io.File;

public class Excecutable extends Filter {

	private boolean arg;

	/**
	 * Checks if the file is legal
	 *
	 * @param file The file to check
	 * @return true if the file is legal
	 */
	@Override
	public boolean isLegal(File file) {
		return file.canExecute() == arg;
	}

	/**
	 * Gets the arguments for the filter
	 *
	 * @param line The line to ..
	 */
	@Override
	public void getArgs(String line) {
		arg = Filter.parseBoolean(line);
	}
}
