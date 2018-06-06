package filesprocessor.utils;

import filesprocessor.section.BadSectionException;
import filesprocessor.section.RawSection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtils {
	public static String[] readFile(String path) {
		ArrayList<String> array = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(path)));
			String line;
			while ((line = reader.readLine()) != null) {
				array.add(line);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return array.toArray(new String[0]);
	}

	public static ArrayList<RawSection> readCommandFile(String path) throws BadSectionException {
		ArrayList<RawSection> array = new ArrayList<>();

		RawSection currentSection = new RawSection();
		ArrayList<String> current = new ArrayList<>();
		String[] lines = FileUtils.readFile("test/cmd.flt");
		for (int index = 0;index < lines.length;index++) {
			String line = lines[index];
			if (line.equals("FILTER") && current.size() == 0) {
				try {
					currentSection.startLine = index + 1;
					current.add(line);
					current.add(lines[++index]);
					current.add(lines[++index]);
					if (!lines[index + 1].equals("FILTER")) {
						current.add(lines[index + 1]);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					throw new BadSectionException();
				}
			} else if (line.equals("FILTER") && current.size() != 0) {
				currentSection.lines = current.toArray(new String[0]);
				array.add(currentSection);
				current = new ArrayList<>();
				currentSection = new RawSection();
				index--;
			}
		}
		if (current.size() != 0) {
			currentSection.lines = current.toArray(new String[0]);
			array.add(currentSection);
		}
		return array;
	}

//	public static String getType(File file) {
//		String name = file.getName();
//		if (!name.contains(".") || )
//	}
}
