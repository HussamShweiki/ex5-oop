package filesprocessor.section;

import java.util.Arrays;

public class RawSection {
	public String[] lines;
	public int startLine;

//	public RawSection(String[] lines, int startLine) {
//		this.lines = lines;
//		this.startLine = startLine;
//	}


	@Override
	public String toString() {
		return "Start: " + startLine + " - " + Arrays.toString(lines);
	}
}
