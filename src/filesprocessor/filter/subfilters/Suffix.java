package filesprocessor.filter.subfilters;

import filesprocessor.filter.Filter;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Suffix extends Filter {
    private String ans;
    @Override
    public boolean isLegal(File file) {
        String fileName = file.getName();
        String filePrefix = fileName.replaceFirst("[.][^.]+$", "");
        String fileSuffix = fileName.replace(filePrefix,"");
        return fileSuffix.equals(ans);
    }

    @Override
    public void getArgs(String line) {
        String strRegex = "#.+$";
        Pattern pattern = Pattern.compile(strRegex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()){
            String answer = matcher.group().substring(1);
            String prefix =answer.replaceFirst("[.][^.]+$", "");
            ans = answer.replace(prefix,"");
            System.out.println(ans);
        }



    }
}