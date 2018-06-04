package filesprocessor.filter;

import java.io.File;

public abstract class Filter {

	public boolean not;
	/**
	 * Checks if the file is legal
	 * @param file The file to check
	 * @return true if the file is legal
	 */
	abstract boolean isLegal(File file);

//	/**
//	 * Checks if the line matches any filter
//	 * @param line The line to check
//	 * @return true if true and false if false
//	 */
//	public boolean checkLine(String line) {     moved to factory
//
//		return false;
//	}

	/**
	 * Filters the given list
	 * @param files the list to filter
	 * @return a new filtered list
	 */
	public File[] filterList(File[] files) {
		return new File[0];
	}

	/**
	 * Gets the arguments for the filter
	 * @param line The line to ..
	 */
	abstract void getArgs(String line);

	/**
	 *
	 * filter.not = checkNot(line); <- factory
	 * @param line
	 * @return
	 */
	public boolean checkNot(String line) {
		return false;
	}
}
