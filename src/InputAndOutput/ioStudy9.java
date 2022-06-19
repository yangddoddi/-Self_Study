package InputAndOutput;

import java.io.*;

//Reader & Writer interface
//byte 배열 대신 char 배열을 쓴다는 것 외에 큰 차이는 없다
//문자열은 Reader나 Writer를 쓰는 것이 효율적이다.
public class ioStudy9 {
    public static void main(String[] args) {
        String str = "나는 즐겁다 ~ 나는 행복하다 ~ 나는 신난다 ~";

        try {
            FileWriter fw = new FileWriter("ioStudy9.txt");
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String str2 = "";
        int data = 0 ;

        try {
            FileReader fr = new FileReader("ioStudy9.txt");
            System.out.println(fr.ready());
            while ((data = fr.read()) != -1 ){
                if ( data != '\t' && data != ' ') { // 띄어쓰기 및 탭 모두 제거
                    str2 += (char) data;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(str2);
    }
}
