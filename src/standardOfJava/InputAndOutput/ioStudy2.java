package standardOfJava.InputAndOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class ioStudy2 {
    public static void main(String[] args) {
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9,10};
        byte[] outSrc = null;

        ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;
        while ((data = input.read())!=-1) { // read() 메서드는 더이상 읽어올 값이 없으면 -1을 반환한다.
            output.write(data);
        }

        outSrc = output.toByteArray(); // 받아온 데이터를 byte 배열로 변환한다.
        System.out.println(Arrays.toString(inSrc));
        System.out.println(Arrays.toString(outSrc));
    }
}
