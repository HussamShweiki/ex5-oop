package filesprocessor;

import filesprocessor.parse.Parser;
import filesprocessor.section.BadSectionException;
import filesprocessor.section.Section;

import java.io.File;

public class Processor {
	
	public static void process(File[] files, String filePath) throws BadSectionException, InterruptedException {
		//call section.sort
		// call section.filter
		// print results
		Section[] sections = Parser.parseSections(filePath);
		for (Section section : sections) {
			processSection(files, section);
		}
	}

	public static void processSection(File[] srcFiles, Section section) throws InterruptedException {
		File[] filteredList = section.filter.filterList(srcFiles);
		File[] sortedList = section.order.sortList(filteredList);
		Thread.sleep(10);
		for (int line : section.warnings)
			System.err.println("Warning in line " + line);
		Thread.sleep(10);
		for (File file : sortedList)
			System.out.println(file.getName());
	}
}
