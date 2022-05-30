package Array;

import javax.swing.*;
import java.util.Arrays;

// 다차원 배열 좌표 찍기
public class Coordinates {
    public static void main(String[] args) {
        // 행과 열을 1번부터 시작하게 하기 위해 게임판보다 행렬이 각각 1 크게 만든다.
        int size = 10;
        int x = 0;
        int y = 0;
        // 상대 게임판
        byte[][] shipBoard = {
                //1  2  3  4  5  6  7  8  9   //
                { 0, 0, 0, 0, 0, 0, 1, 0, 0 },// 1
                { 1, 1, 1, 1, 0, 0, 1, 0, 0 },// 2
                { 0, 0, 0, 0, 0, 0, 1, 0, 0 },// 3
                { 0, 0, 1, 0, 1, 0, 0, 0, 0 },// 4
                { 1, 1, 1, 1, 0, 0, 0, 0, 0 },// 5
                { 0, 1, 0, 0, 0, 1, 0, 0, 0 },// 6
                { 1, 0, 0, 0, 1, 0, 0, 1, 1 },// 7
                { 1, 0, 0, 0, 1, 0, 1, 0, 0 },// 8
                { 1, 0, 0, 0, 1, 0, 1, 0, 1 },// 9
        };
        // 정답 체크 보드
        char[][] board = new char[size][size];

        for (int i=1; i< size; i++) {
            board[0][i] = board[i][0] = (char)(i+'0');
        }

        // 처음 보여줄 게임판
        for (int i=0; i< board.length; i++){
            System.out.println(board[i]);
        }

        for (;;) {
            String input = JOptionPane.showInputDialog("원하시는 행과 열 번호를 입력하세요.(종료는 00)");

            // 문자를 숫자로 변환
            x = input.charAt(0) - '0';
            y = input.charAt(1) - '0';

            if (input.equals("00")) break;

            if (x > 9 || x < 1 || y > 9 || y < 1 || input.length()!=2) {
                    JOptionPane.showMessageDialog(null, "행과 열은 각각 1부터 9까지의 수만 입력 가능합니다.(ex>12)");
                    continue;
                }

            //내가 입력한 정답의 좌표에 1이 있다면 해당 인덱스에 O를, 없다면 X를 대입한다.
            if (shipBoard[x-1][y-1] == 1) {
                board[x][y] = 'O';
            } else { board[x][y] = 'X';
        }

            // 결과 출력
            for (int i=0; i< board.length; i++){
                System.out.println(board[i]);
            }
    }
}}
