package filesprocessor.filter;

import filesprocessor.InvalidArgumentsException;
import filesprocessor.parse.Parser;
import filesprocessor.utils.ArrayUtils;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Filter {

	public static final String booleanRegex = "#(?:YES|NO)$";
	public static final String strRegex = "#.*$";
	public static final String doubleRegex = "#\\d*\\.?(?:\\d+)?";

	public static final int BYTES_TO_KBYTES = 1024;

	public boolean not;
	/**
	 * Checks if the file is legal
	 * @param file The file to check
	 * @return true if the file is legal
	 */
	public abstract boolean isLegal(File file);

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
		return ArrayUtils.filterFilesList(files, file -> not != isLegal(file));
	}

	/**
	 * Gets the arguments for the filter
	 * @param line The line to ..
	 */
	public abstract void getArgs(String line) throws InvalidArgumentsException;

	/**
	 *
	 * filter.not = checkNot(line); <- factory and removes #NOT from the line
	 * @param line
	 * @return
	 */
	public boolean checkNot(String line) {
		return line.endsWith("#NOT");
	}

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}


	public static double parseOneDouble(String line) throws InvalidArgumentsException {
		Pattern pattern = Pattern.compile(doubleRegex);  // TODO 06/06/2018 Make pattern magic
		Matcher matcher = pattern.matcher(line);
		try {
			String stringNumber = matcher.group().substring(1);
			return Double.parseDouble(stringNumber);
		} catch(NumberFormatException e) {
			throw new InvalidArgumentsException();
		}
	}

	public static String parseString(String line) {
		Pattern pattern = Pattern.compile(strRegex);  // TODO 06/06/2018 Make pattern magic
		Matcher matcher = pattern.matcher(line);
		matcher.find();
		return matcher.group().substring(1);
	}

	public static boolean parseBoolean(String line) {
		Pattern pattern = Pattern.compile(booleanRegex);  // TODO 06/06/2018 Make the pattern magic
		Matcher matcher = pattern.matcher(line);
		matcher.find();
		return matcher.group().equals("#YES");
	}
}
