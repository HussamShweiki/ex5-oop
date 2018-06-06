package filesprocessor.factory;

import filesprocessor.order.BadOrderException;
import filesprocessor.order.Order;
import filesprocessor.order.suborders.Abs;

public class OrderFactory {

	/**
	 * Creates an order from the line or throws an exception
	 * @param line
	 * @return
	 */
	public static Order create(String line) throws BadOrderException {
		/*
		if (line.match(order1))
			return new order1;
		 */

//		throw new BadOrderException();
		return Abs.getInstance();

	}
}
