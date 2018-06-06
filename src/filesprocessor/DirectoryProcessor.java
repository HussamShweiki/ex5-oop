package filesprocessor;

import filesprocessor.filter.Filter;
import filesprocessor.order.Order;
import filesprocessor.section.Section;

import java.io.File;

public class DirectoryProcessor {

	public static void main(String[] args) throws InterruptedException {
		File[] files = new File("test").listFiles(file -> !file.isDirectory());
		Filter filter = new Filter() {
			@Override
			public boolean isLegal(File file) {
				return file.getName().endsWith("txt");
			}

			@Override
			public void getArgs(String line) {

			}
		};
		filter.not = true;
		Section section = new Section();
		section.filter = filter;
		section.order = new Order() {
			@Override
			public int compare(File file1, File file2) {
				return file1.getName().compareTo(file2.getName());
			}
		};
		section.warnings.add(1);
		section.warnings.add(3);
		Processor.processSection(files, section);
	}
}
