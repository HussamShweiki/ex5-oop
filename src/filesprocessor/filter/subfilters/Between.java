package filesprocessor.filter.subfilters;

import filesprocessor.InvalidArgumentsException;
import filesprocessor.filter.Filter;

import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Between extends Filter {
   private double[] valueList;


    @Override
    public boolean isLegal(File file) {
    	double size = file.length() / BYTES_TO_KBYTES;
        return size >= valueList[0] && size <= valueList[1];  // TODO 06/06/2018 Check if =


    }

    @Override
    public void getArgs(String line) throws InvalidArgumentsException {
        Pattern pattern = Pattern.compile(Filter.doubleRegex);
        Matcher matcher = pattern.matcher(line);
        int i=0;
	    valueList = new double[2];
        while(matcher.find()){
        	try {
		        String value = matcher.group().substring(1);
		        double number = Double.parseDouble(value);
		        valueList[i] = number;
		        i++;
	        } catch (NumberFormatException e) {
		        throw new InvalidArgumentsException();
	        }
        }
        if (valueList[1] < valueList[0])
        	throw new InvalidArgumentsException();
    }
}