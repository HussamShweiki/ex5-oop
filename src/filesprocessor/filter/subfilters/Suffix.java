package filesprocessor.filter.subfilters;

import filesprocessor.filter.Filter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Suffix extends Filter {
    private String ans;
    @Override
    public boolean isLegal(File file) {
        /*String fileName = file.getName(); TODO move to Type order
        String filePrefix = fileName.replaceFirst("[.][^.]+$", "");
        String fileSuffix = fileName.replace(filePrefix,"");
        return fileSuffix.equals(ans);*/
        return file.getName().endsWith(ans);
    }

    @Override
    public void getArgs(String line) {
        ans = Filter.parseString(line);
    }
}