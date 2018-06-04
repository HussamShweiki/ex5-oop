package filesprocessor;

import filesprocessor.filter.Filter;
import filesprocessor.order.Order;

public class Section {

	public Filter filter;
	public Order order;

	public Section(Filter filter, Order order) {
		this.filter = filter;
		this.order = order;
	}
}
