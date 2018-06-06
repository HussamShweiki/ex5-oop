package filesprocessor.order;

import filesprocessor.utils.ArrayUtils;

import java.io.File;

public abstract class Order {

	public boolean reversed;

	public Order(boolean reversed) {
		this.reversed = reversed;
	}
	/**
	 * Compares two files
	 * @param file1 file 1
	 * @param file2 file 2
	 * @return 0 if equal, 1 file1 > file2, -1 file1 < file2
	 */
	public abstract int compare(File file1, File file2);

	/**
	 * called by factory
	 * check if reversed
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
		return ArrayUtils.getFileListUtils().sort(files, (file1, file2) -> compare(file1, file2) * (reversed ? -1 : 1));
	}


	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
