package filesprocessor.filter.subfilters;

import filesprocessor.filter.Filter;

import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class GreaterThan extends Filter {
    double value = 0;
    int kBytesToBytes = 1024;


    @Override
    public boolean isLegal(File file) {
        return (file.length()>value);


    }

    @Override
    public void getArgs(String line) {
        String doubleRegex =  "#\\d*\\.?(?:\\d+)?";
        Pattern pattern = Pattern.compile(doubleRegex);
        Matcher matcher = pattern.matcher(line);
        if(matcher.find()) {
            String stringNumber = matcher.group().substring(1);
            double number = Double.parseDouble(stringNumber);
            value = number*kBytesToBytes;


        }

    }
}
