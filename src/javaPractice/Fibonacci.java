package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    // 메모이제이션으로 연산 속도 향상
    public static int[] memo;
    public static void main(String[] args) throws IOException {
        // 1단계 유저 입력값 받기
        int inputNum = getUserInput();
        memo = new int[inputNum];
        // 3단계. 결과 및 안내문구 출력
        printNumbers(inputNum);

    }
    
    // 1. 유저 입력값 받기
    private static int getUserInput() throws IOException {
        System.out.print("[안내]피보나치 수열 프로그램 시작.\n" +
                "원하는 수열의 개수를 입력해 주세요 : ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        return inputNum;
    }

    // 2단계. 피보나치 수열 계산
    public static int fibonacci(int num) {
        if (num==0 || num==1) { return 1; }
        else if (memo[num]>0) {
            return memo[num]; }
        else {
            return memo[num] = fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    private static void printNumbers(int inputNum) {
        System.out.println("[피보나치 수열 출력]");
        for (int i = 0; i< inputNum; i++) {
            System.out.println(fibonacci(i));
        }
        System.out.println("[안내]프로그램을 종료합니다.");
    }
}