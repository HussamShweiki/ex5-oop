package filesprocessor.order;

import filesprocessor.order.suborder.Abs;

import java.io.File;

public abstract class Order {
	public boolean inVersed = false;
	/**
	 * Compares two files
	 * @param file1 file 1
	 * @param file2 file 2
	 * @return 0 if equal, 1 file1 > file2, -1 file1 < file2
	 */
	public abstract int compare(File file1, File file2);

	/**
	 * called by factory
	 * check if inVersed
	 * @param line line
	 * @return kk
	 */
	boolean checkInverse(String line) {
		return false;
	}

	/**
	 * Sorts a list
	 * @param files list
 	 * @return sorted list
	 */
	public File[] sortList(File[] files) {
		return null;
	}


}
