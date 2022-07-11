package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    // 메모이제이션으로 연산 속도 향상
    public static int[] memo;
    public static void main(String[] args) throws IOException {
        // 1단계. 프로그램 시작을 알리는 출력문 선언
        System.out.print("[안내]피보나치 수열 프로그램 시작.\n" +
                "원하는 수열의 개수를 입력해 주세요 : ");
        // 사용자의 입력값 받기.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        memo = new int[inputNum];


        // 3단계.
        // 결과 출력을 위한 안내 문구 출력 입니다.
        // 반복문을 통해 호출
        System.out.println("[피보나치 수열 출력]");
        for (int i=0; i<inputNum; i++) {
            System.out.println(printFibonacci(i));
        }
        System.out.println("[안내]프로그램을 종료합니다.");
    }

    // 2단계. 피보나치 수열 재귀 메서드
    public static int printFibonacci(int num) {
        if (num==0 || num==1) { return 1; }
        else if (memo[num]>0) {
            return memo[num]; }
        else {
            return memo[num] = printFibonacci(num - 1) + printFibonacci(num - 2);
        }
    }
}