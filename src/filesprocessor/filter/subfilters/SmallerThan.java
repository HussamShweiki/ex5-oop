package filesprocessor.filter.subfilters;

import filesprocessor.InvalidArgumentsException;
import filesprocessor.filter.Filter;

import java.io.File;

public class SmallerThan extends Filter {
    private double value;


    @Override
    public boolean isLegal(File file) {
    	double size = file.length() / BYTES_TO_KBYTES;
        return size < value;
    }

    @Override
    public void getArgs(String line) throws InvalidArgumentsException {
		value = Filter.parseOneDouble(line);

    }
}
