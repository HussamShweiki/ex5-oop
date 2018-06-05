package filesprocessor.order.suborders;

import filesprocessor.order.Order;

import java.io.File;

public class Abs extends Order {

	private static final Order instance = new Abs();
	public static Order getInstance() {
		return instance;
	}

	/**
	 * Compares two files
	 *
	 * @param file1 file 1
	 * @param file2 file 2
	 * @return 0 if equal, 1 file1 > file2, -1 file1 < file2
	 */
	@Override
	public int compare(File file1, File file2) {
		return file1.getName().compareTo(file2.getName());
	}
}
