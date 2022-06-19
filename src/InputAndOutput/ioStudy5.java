package InputAndOutput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ioStudy5 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(args[1]);
            int data = 0;
            // read가 한 번에 1byte씩 데이터를 읽어들이지만 데이터 범위가 0~255의 정수값이고
            // 읽을 수 없음을 알리는 값 (-1)도 들어갈 수 있어야하기 때문에 int에 데이터를 저장한다

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}