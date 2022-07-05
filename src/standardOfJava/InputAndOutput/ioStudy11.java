package standardOfJava.InputAndOutput;

// StringReader & StringWriter
// CharArrayReader/CharArrayWriter와 같이 입출력 대상이 메모리인 스트림이다.
// 내부의 StringBuffer에 저장되어 있다가 getBuffer()메서드를 호출하면 출력된다.

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class ioStudy11 {
    public static void main(String[] args) {
        String str = "순대국밥먹고싶다";
        StringReader sr = new StringReader(str);
        StringWriter sw = new StringWriter();
        int data = 0;

        try {
            while ((data=sr.read())!=-1) {
                sw.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer result = sw.getBuffer();
        System.out.println(result.toString());
    }
}
