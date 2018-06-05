package filesprocessor.parse;

import com.sun.istack.internal.NotNull;
import filesprocessor.factory.FilterFactory;
import filesprocessor.factory.OrderFactory;
import filesprocessor.filter.BadFilterExcdeption;
import filesprocessor.filter.Filter;
import filesprocessor.filter.subfilters.All;
import filesprocessor.order.BadOrderException;
import filesprocessor.order.Order;
import filesprocessor.order.suborders.Abs;
import filesprocessor.section.BadSectionException;
import filesprocessor.section.RawSection;
import filesprocessor.section.Section;

public class Parser {

	public static final Filter DEFAULT_FILTER = new All();
	public static final Order DEFAULT_ORDER = Abs.getInstance();

	/*
	**
	 */

	public static Section parseSection(@NotNull RawSection rawSection) throws BadSectionException {
		if (!rawSection.lines[0].equals("FILTER") || !rawSection.lines[2].equals("ORDER")) {
			throw new BadSectionException();
		}
		Section section = new Section();
		Filter filter;
		try {
			filter = FilterFactory.create(rawSection.lines[1]);
		} catch (BadFilterExcdeption e) {
			filter = DEFAULT_FILTER;
			section.warnings.add(rawSection.startLine + 1);
		}
		Order order;
		if (rawSection.lines.length == 3) {
			order = DEFAULT_ORDER;
		} else if (rawSection.lines.length == 4) {
			try {

				order = OrderFactory.create(rawSection.lines[3]);
			} catch (BadOrderException e) {
				order = DEFAULT_ORDER;
				section.warnings.add(rawSection.startLine + 3);
			}
		} else {
			throw new BadSectionException();
		}
		section.filter = filter;
		section.order = order;
		return section;
	}
}
