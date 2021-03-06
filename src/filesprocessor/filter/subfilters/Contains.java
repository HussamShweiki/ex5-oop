package filesprocessor.filter.subfilters;

import filesprocessor.filter.Filter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contains extends Filter {
    private String ans;
    @Override
    public boolean isLegal(File file) {
        return file.getName().contains(ans);
    }

    @Override
    public void getArgs(String line) {
        String strRegex = "#.+$";
        Pattern pattern = Pattern.compile(strRegex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()){
	        ans = matcher.group().substring(1);
        }




    }
}
