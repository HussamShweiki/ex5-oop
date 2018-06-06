package filesprocessor.filter.subfilters;

import filesprocessor.filter.Filter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Prefix extends Filter {
    private String ans;
    @Override
    public boolean isLegal(File file) {
        String fileName = file.getName();
        String filePrefix = fileName.replaceFirst("[.][^.]+$", "");
        return filePrefix.equals(ans);
    }

    @Override
    public void getArgs(String line) {
        String strRegex = "#.+$";
        Pattern pattern = Pattern.compile(strRegex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()){
            String answer = matcher.group().substring(1);
            ans =answer.replaceFirst("[.][^.]+$", "");
        }



    }
}