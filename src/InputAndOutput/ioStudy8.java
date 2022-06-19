package InputAndOutput;

// SequenceInputStream
// 여러개의 입력 스트림을 연속적으로 연결해서 하나의 스트림으로부터 데이터를 읽는 것처럼 처리해준다.
// 큰 파일 여러개의; 작은 파일로 나누었다가 합치는 등의 작업에 좋다.

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.Arrays;
import java.util.Vector;

public class ioStudy8 {
    public static void main(String[] args) {
        byte[] arr1 = {1,2,3};
        byte[] arr2 = {4,5,6};
        byte[] arr3 = {7,8,9};
        byte[] outSrc = null;

        Vector v = new Vector();
        v.add(new ByteArrayInputStream(arr1));
        v.add(new ByteArrayInputStream(arr2));
        v.add(new ByteArrayInputStream(arr3));

        try {
            SequenceInputStream sis = new SequenceInputStream(v.elements());
            ByteArrayOutputStream bao = new ByteArrayOutputStream();

            int data = 0;

            while ((data=sis.read())!=-1) {
                bao.write(data);
            }

            outSrc = bao.toByteArray();
            System.out.println(Arrays.toString(outSrc));

        } catch (IOException e) { e.printStackTrace(); }
    }
}
