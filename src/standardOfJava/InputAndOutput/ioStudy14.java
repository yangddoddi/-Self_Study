package standardOfJava.InputAndOutput;


// 표준 입출력 (System.in(입력), System.out(출력), System.err(출력))은 콘솔을 통한 데이터 입출력을 의미한다.
// 이들은 자바 어플리케이션의 실행과 동시에 사용할 수 있게 자동적으로 생성되기 때문에 따로 스트림을 생성하지 않아도 된다.

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ioStudy14 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        PrintStream ps = null;
        int input = 0;

        try {
            fos = new FileOutputStream("ioStudy14.txt");
            ps = new PrintStream(fos);
            System.setOut(ps);
                // 콘솔 입력은 버퍼를 가지고 있기 때문에 한 번에 255자까지 입력하며 엔터 혹은 ^z를 입력 시 한 번에 입력된다.
        } catch(IOException e){
            System.err.println("에러");
        }
        System.out.println("순대 국밥 먹고 싶어요");
        // System.out의 대상이 ioStudy14.txt로 지정되어 있으므로 텍스트 파일에 저장된다.
    }
}