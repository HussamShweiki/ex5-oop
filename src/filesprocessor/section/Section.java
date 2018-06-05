package filesprocessor.section;

import filesprocessor.filter.Filter;
import filesprocessor.order.Order;

import java.util.ArrayList;
import java.util.Arrays;

public class Section {

	public Filter filter;
	public Order order;
	public ArrayList<Integer> warnings = new ArrayList<>();

	public Section() {}
	public Section(Filter filter, Order order) {
		this.filter = filter;
		this.order = order;
	}

	@Override
	public String toString() {
		return "Filter: " + filter + ", Order: " + order + ", warnings: " + Arrays.toString(warnings.toArray());
	}
}
