package InputAndOutput;

import java.io.File;
import java.io.FilenameFilter;

public class ioStudy18 {
    public static void main(String[] args) {


        String currDir = System.getProperty("user.dir");
        File dir = new File(currDir);
        final String pattern = "txt";

        //FilenameFilter를 이용한 필터링
        String[] files = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.contains(pattern);
            }
        });

        for (String str : files) {
            System.out.println(str);
        }

        File file = new File("1.txt");
        file.renameTo(new File(dir, "3.txt"));
        // renameTo를 이용한 파일명 변경
    }
}
