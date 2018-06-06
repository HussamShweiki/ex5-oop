package filesprocessor.factory;

import filesprocessor.filter.BadFilterExcdeption;
import filesprocessor.filter.Filter;

public class FilterFactory {

	/**
	 * Creates a filter from the line or throws an exception
	 * @param line
	 * @return
	 */
	public static Filter create(String line) throws BadFilterExcdeption {
		throw new BadFilterExcdeption();
//		return null;
	}
}