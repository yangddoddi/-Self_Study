package InputAndOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ioStudy3 {
    public static void main(String[] args) {
        byte[] inputSrc = {1,2,3,4,5,6,7,8,9,10};
        byte[] outputSrc = null;
        byte[] temp = new byte[10];

        ByteArrayInputStream input = new ByteArrayInputStream(inputSrc);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        input.read(temp, 0, temp.length);
        // read(byte[] b, int off, int byte)로 한 번에 더 많은 데이터를 옮길 수 있다.
        // 배열을 통한 입출력이 작업의 효율을 증가시키기 때문에 입출력 대상에 따라 알맞은 크기의 배열을 활용하는 것이 좋다.
        System.out.println(Arrays.toString(temp));
        output.write(temp, 5, 5); // 5 ~ 5가 아니라 5번 인덱스부터 5Length다.

        outputSrc = output.toByteArray();

        System.out.println(Arrays.toString(inputSrc));
        System.out.println(Arrays.toString(outputSrc));
        System.out.println(Arrays.toString(temp));
    }
}
