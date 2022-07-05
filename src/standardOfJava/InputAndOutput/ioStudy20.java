package standardOfJava.InputAndOutput;

import java.io.File;

public class ioStudy20 {
    public static void main(String[] args) {
        String currDir = System.getProperty("user.dir");

        File dir = new File(currDir);
        String str = "3_";

        delete(dir, str);
    }

    public static void delete(File dir, String str) {
        File[] files = dir.listFiles();

        for(int i=0; i<files.length; i++) {
            String file = files[i].getName();
            if(file.contains(str)) {
                files[i].delete();
            }
        }
    }
}