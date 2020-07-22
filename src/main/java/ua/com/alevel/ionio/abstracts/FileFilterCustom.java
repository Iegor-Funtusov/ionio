package ua.com.alevel.ionio.abstracts;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Iehor Funtusov, created 21/07/2020 - 8:02 PM
 */

@FunctionalInterface
public interface FileFilterCustom extends FileFilter {

    boolean accept(File path);
}
