package InputAndOutput;

import java.io.*;

public class ioStudy21 {
    public static void main(String[] args) {
        String mergeFileName = "3.txt";

        try {
            File tempFile = File.createTempFile("~mergetemp",".tmp");
            tempFile.deleteOnExit();

            FileOutputStream fos = new FileOutputStream(tempFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            BufferedInputStream bis = null;
            int num = 1;

            File f = new File( "3_" + num + ".txt");

            while(f.exists()) {
                f.setReadOnly();
                bis = new BufferedInputStream(new FileInputStream(f));

                int data=0;
                while((data=bis.read())!=-1) {
                    bos.write(data);
                }
            bis.close();
            f = new File(mergeFileName + "_." + ++num);}
            bos.close();
            File oldFile = new File(mergeFileName);
            if(oldFile.exists()) {oldFile.delete();}
            tempFile.renameTo(oldFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
