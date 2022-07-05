package standardOfJava.InputAndOutput;

// 문자 기반 보조 스트림
// BufferReader/ BufferWriter는 버퍼를 이용해서 입출력 효율을 높인다
// 효율이 비교할 수 없을 정도로 높아지니 거의 무조건 사용한다.

import java.io.*;

public class ioStudy12 {
    public static void main (String[] args) {

        try {
            FileWriter fw = new FileWriter("ioStudy12.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("안녕하세요.");
            bw.newLine();
            bw.write("돼지국밥보다 순대국밥이 맛있습니다.");
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int data = 0;

        try {
            FileReader fr = new FileReader("ioStudy12.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";

            for (int i=0; (line = br.readLine())!=null; i++) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
