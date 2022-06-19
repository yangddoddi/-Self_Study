package InputAndOutput;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ioStudy4 {
    public static void main(String[] args) {
        byte[] inputSrc = { 1,2,3,4,5,6,7,8,9,10 };
        byte[] outputSrc = null;
        byte[] temp = new byte[4];

        ByteArrayInputStream input = new ByteArrayInputStream(inputSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        while (input.available() > 0) {
            try {
                int len = input.read(temp);
                // read 메서드는 읽어온 데이터로 배열을 채우고 가져온 데이터 수만큼 정수를 반환한다
                // 배열에 5678이 있는 상태에서 910이 남으면 91078이 되어 중복 데이터가 전송되는데
                // read의 반환값을 저장하는 변수를 만들어서 write()메서드의 lentgh 파라미터 자리에 인자로 넣어주면
                // 가져온 데이터 수 만큼만 전달한다.
                output.write(temp, 0, len);
                outputSrc = output.toByteArray();
                System.out.println("inputSrc : " + Arrays.toString(inputSrc) + ", outputSrc : " + Arrays.toString(outputSrc) + ", temp : " + Arrays.toString(temp));
            } catch (IOException e) {}
        }
    }
}
