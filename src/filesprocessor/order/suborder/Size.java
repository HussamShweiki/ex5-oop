package filesprocessor.order.suborder;

import filesprocessor.order.Order;
import filesprocessor.order.suborder.Abs;

import java.io.File;

public class Size extends Order {
    /**
     * comapres files according to their size.
     * @param file1 file 1
     * @param file2 file 2
     * @return 0 if equals, 1 file1 > file2, -1 file1 < file2
     */
    @Override
    public int compare(File file1, File file2) {
        double size1 = file1.length();
        double size2 = file2.length();
        if (size1==size2){
            return Abs.DEAFULT_ORDER.compare(file1,file2);
        }else if (size1>size2){
            return 1;
        }
        return -1;
    }
}
