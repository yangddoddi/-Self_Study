package InputAndOutput;

import java.io.*;

// 큰 용량의 파일을 나누는 예제인데 용량을 잘못 지정해서 파일이 6572개가 생겨버렸다..
// 이제 지우는 걸 만들어보자..
public class ioStudy19 {
    public static void main(String[] args) {
        String fileName = "3.txt";
        final int VOLUME = 1000000;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream fos = null;
            BufferedOutputStream bos = null;

            int data = 0;
            int i = 0;
            int number = 0;

            while ((data = bis.read()) != -1) {
                if (i % VOLUME == 0) {
                    if (i != 0) {
                        bos.close();
                    }
                    fos = new FileOutputStream( "3_" + ++number + ".txt");
                    bos = new BufferedOutputStream(fos);
                }
                bos.write(data);
                i++;
            }
            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
