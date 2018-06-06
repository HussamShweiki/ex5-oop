package filesprocessor.order.suborder;

import filesprocessor.order.Order;

import java.io.File;

public class Abs extends Order {

    public static Abs DEAFULT_ORDER = new Abs();

    /**
     * comapres the files according to their absolute path.
     * @param file1 file 1
     * @param file2 file 2
     * @return 0 if equals, 1 file1 > file2, -1 file1 < file2
     */
    @Override
    public int compare(File file1, File file2) {
        return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
    }
}
