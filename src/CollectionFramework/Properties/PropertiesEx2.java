package CollectionFramework.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class PropertiesEx2 {
    public static void main(String[] args) {
        Properties p = new Properties();

        while(true) {
            System.out.println("불러올 파일명을 입력하세요");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            try {
                p.load(new FileInputStream(input));
            } catch (IOException e) {
                System.out.println("올바르지 않은 파일명입니다.");
                continue;
            }

            String name = p.getProperty("name");
            try {
                name = new String(name.getBytes("8859_1"), StandardCharsets.UTF_8);
            } catch (Exception e) {continue;} // 인코딩 변경해줘야 한글이 깨지지 않음
            String[] score = p.getProperty("score").split(",");
            int max = 0;
            int min = 0;
            int sum = 0;

            for (int i=0; i<score.length; i++) {
                int num = Integer.parseInt(score[i].trim()); // 구분자 외 공백 제거

                if ( i==0 ) { max = num; min = num; }
                if ( num < max ) {
                    max = num;
                } else if ( num > min ) {
                    min = num;
                }
                sum += num;
            }

            System.out.println("이름 = " + name);
            System.out.println("점수 기록 = " + Arrays.toString(score));
            System.out.println("최대 점수 = " + max);
            System.out.println("최저 점수 = " + min);
            System.out.println("총점 = " + sum);
        }
    }
}
