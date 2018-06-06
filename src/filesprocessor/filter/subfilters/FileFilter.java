package filesprocessor.filter.subfilters;

import filesprocessor.filter.Filter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFilter extends Filter {
    private String ans;

	public FileFilter(boolean not) {
		super(not);
	}

	@Override
    public boolean isLegal(File file) {
        return file.getName().equals(ans);
    }

    @Override
    public void getArgs(String line) {
       ans = Filter.parseString(line);
    }
}