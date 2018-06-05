package filesprocessor.filter.subfilters;

import filesprocessor.filter.Filter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hidden extends Filter {

	private boolean arg;

	/**
	 * Checks if the file is legal
	 *
	 * @param file The file to check
	 * @return true if the file is legal
	 */
	@Override
	public boolean isLegal(File file) {
		return false;
	}

	/**
	 * Gets the arguments for the filter
	 *
	 * @param line The line to ..
	 */
	@Override
	public void getArgs(String line) {
		String regex = "#(?:YES|NO)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			arg = matcher.group().equals("#YES");
		}
	}
}
