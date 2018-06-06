package filesprocessor.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;

public class ArrayUtils<E> {
	private static final ArrayUtils<String> stringListUtils = new ArrayUtils<>();
	private static final ArrayUtils<File> fileListUtils = new ArrayUtils<>();

	public static ArrayUtils<String> getStringListUtils() {
		return stringListUtils;
	}
	public static ArrayUtils<File> getFileListUtils() {
		return fileListUtils;
	}

	public E[] sort(E[] list, Comparator<E> comparator) {
		int n = list.length;
		E[] newList = list.clone();
		E temp;
		for (int i = 0; i < n; i ++) {
			for (int j = 1;j < n-i;j++) {
				if (comparator.compare(newList[j - 1], newList[j]) > 0) {
					temp = newList[j - 1];
					newList[j - 1] = newList[j];
					newList[j] = temp;
				}
			}
		}
		return newList;
	}

	public static File[] filterFilesList(File[] list, FileFilter fileFilter) {
		ArrayList<File> newList = new ArrayList<>();
		for (File file : list) {
			if (fileFilter.accept(file))
				newList.add(file);
		}
		return newList.toArray(new File[0]);
	}


}
