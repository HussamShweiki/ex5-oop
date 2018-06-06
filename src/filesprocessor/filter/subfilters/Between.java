package filesprocessor.filter.subfilters;

import filesprocessor.filter.Filter;

import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Between extends Filter {
    double[] valueList = new double[2];
    int kBytesToBytes = 1024;


    @Override
    public boolean isLegal(File file) {
        return (file.length()>valueList[0]&&file.length()<valueList[1]);


    }

    @Override
    public void getArgs(String line) {
        String doubleRegex =  "#\\d*\\.?(?:\\d+)?";
        Pattern pattern = Pattern.compile(doubleRegex);
        Matcher matcher = pattern.matcher(line);
        int i=0;
        while(matcher.find()){
            String value = matcher.group().substring(1);
            double number = Double.parseDouble(value);
            valueList[i] = number*kBytesToBytes;

            i++;
        }



    }
}