package filesprocessor.order.suborder;


import filesprocessor.order.Order;

import java.io.File;

public class Type extends Order {
    /**
     * compares files according to their extension type
     * @param file1 file 1
     * @param file2 file 2
     * @return 0 if equals, 1 file1 > file2, -1 file1 < file2
     */
    @Override
    public int compare(File file1, File file2) {
        String type1 = getSuffix(file1);
        String type2 = getSuffix(file2);
        if (type1.equals(type2)) {
            return Abs.DEAFULT_ORDER.compare(file1, file2);
        }
        return type1.compareTo(type2);
    }
    private String getSuffix(File file){
        String fileName = file.getName();
        String filePrefix = fileName.replaceFirst("[.][^.]+$", "");
        return fileName.replace(filePrefix,"");

    }
}

