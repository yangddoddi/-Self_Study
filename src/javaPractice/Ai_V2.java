package javaPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class Ai_V2 {
    public static void main(String[] args) {
        /*
         * 인공지능 예측에 필요한 변수를 정의합니다.
         * a,b    : 예측에 필요한 요소
         * x_list : 예측에 필요한 광고비 배열
         * y      : 예측한 결과값(웹 페이지 방문자 수)
         * y_list :
         */

        //TODO:
        // 사용자의 입력을 받기 위한 Scanner 객체를 생성합니다.
        Scanner scanner = new Scanner(System.in);
        // 시스템 시작 안내 문구
        System.out.println("[인공지능 프로그램 V2]\n" +
                "==============================");
        System.out.println("[System] 예측에 영향을 주는 원인(광고비)의 값을 알려주세요 (단위 원)");
        System.out.println("[System] 원하는 광고비를 모두 입력하셨으면 0을 입력해주세요.");
        // 유저가 원하는 경우의 수(광고비) 모두 입력
        ArrayList<Double> x_list = new ArrayList<>();
        while (true) {
            double inputNum = Double.parseDouble(scanner.nextLine()) ;
            if (inputNum == 0) { break; }
            x_list.add(inputNum);
        }
        // 변수 a,b값 정의
        System.out.println("[System] a 값을 입력하여 주세요 :");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("[System] b 값을 입력하여 주세요 :");
        double b = Double.parseDouble(scanner.nextLine());

        // 반복문을 활용하여 광고비 배열을 출력
        System.out.println("[안내] 입력된 '광고비'는 다음과 같습니다.");
        for (int i=0; i<x_list.size(); i++) {
            System.out.println(i + 1 + " 번째) " + x_list.get(i) + "    ");
        }

        // 한 줄 띄기 및 예측 결과 안내 문구 출력
        System.out.printf("%n[안내] AI의 '웹 페이지 방문자' 예측 결과는 다음과 같습니다.%n");

        // 반복문을 활용해 다수의 광고비(x_list)를 호출하여 방문자 수 예측값을 연산합니다.
        for (int i=0; i<x_list.size(); i++) {
            double result = x_list.get(i) * a + b;
            System.out.printf("%d 번째 예측) %s회 방문%n",i+1,String.format("%.1f",result));
        }
    }
}