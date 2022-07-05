package standardOfJava.InputAndOutput;


// InputStreamReader, OutputStreamWriter
// 바이트 기반 스트림을 문자열 스트림으로 연결시켜주는 역할
// 바이트 기반의 데이터를 지정된 인코딩 문자 데이터로 변경

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ioStudy13 {
    public static void main(String[] args) {
        String line = "";

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.println("사용 중인 OS의 인코딩 ? " + isr.getEncoding());

            do {
                System.out.print("문장을 입력하세요(종료 q) >>");
                line = br.readLine();
                System.out.println("입력된 문자열 : " + line);
            } while (!line.equalsIgnoreCase("q"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // System.in 같은 표준 입출력 프로그램은 굳이 닫지 않아도 된다.
        // Scanner가 생겼기 때문에 거의 사용할 일이 ㅇ벗다.
    }
}
