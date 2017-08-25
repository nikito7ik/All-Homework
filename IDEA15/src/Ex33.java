import java.io.File;
import java.util.ArrayList;

/**
 * Output a list of files and directories of the selected directory on the disk
 */
public class Ex33 {

    private static ArrayList<File> arrayList = new ArrayList<>();

    public static void main(final String... args) {
        getListFiles("D:\\My projects\\IDEA");

        for (File f : arrayList) {
            System.out.println(f.getName());
        }

    }

    public static void getListFiles(String path) {

        File f = new File(path);

        for (File s : f.listFiles()) {
            if (s.isFile()) {
                arrayList.add(s);
            } else if (s.isDirectory()) {
                getListFiles(s.getAbsolutePath());
            }
        }
    }

}
