package standardOfJava.Array;

import java.util.Scanner;

// 이차원 배열 빙고
public class NumberBingo {
    final private static int SIZE = 5;
    public static void main (String[] args) {
        int[][] bingoBoard = new int[SIZE][SIZE];

        // 배열 생성
        for ( int i=0; i<SIZE; i++) {
            bingoBoard[i][0] = i;
            for (int j=0; j<SIZE; j++) {
                bingoBoard[i][j] = (j+1) +(SIZE*i);
            }
        }

        // 배열 뒤섞기
        for ( int i=0; i<SIZE; i++) {
            for ( int j=0; j<SIZE; j++) {
                int RandomIndex = (int)(Math.random()*5);
                int temp = 0;
                temp = bingoBoard[i][j];
                bingoBoard[i][j] = bingoBoard[RandomIndex][RandomIndex];
                bingoBoard[RandomIndex][RandomIndex] = temp;
            }
        }

        // 게임 시작
        int chance = 15;
        while (chance > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("번호를 입력해주세요. 남은 기회는"+ chance +"번, 종료는 00번입니다.");
            int answer = scanner.nextInt();

            Loop : for ( int i=0; i<SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (answer == bingoBoard[i][j]) {
                        bingoBoard[i][j] = 0;
                        break Loop; // 찾으면 바로 반복문 탈출
                    }
                }
            }

            for (int i=0; i<SIZE; i++) {
                for (int j=0; j<SIZE; j++) {
                    System.out.printf("%5d",bingoBoard[i][j]);
                }
                System.out.println();
            }

            chance -= 1;
        }
    }
}