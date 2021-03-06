package filesprocessor.filter.subfilters;

import filesprocessor.filter.Filter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prefix extends Filter {
    private String ans;
    @Override
    public boolean isLegal(File file) {
    	return file.getName().startsWith(ans);
    }

    @Override
    public void getArgs(String line) {
        ans = Filter.parseString(line);
    }
}