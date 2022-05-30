package Array;

import java.util.Arrays;

// 다차원 배열 반복문 응용
public class doubleArray2 {
    public static void main(String[] args) {
        int[][] score = {
                {100, 90, 100},
                {70, 100, 80},
                {80, 70, 80},
                {40, 100, 90},
                {100, 100, 80},
        };
        int sum = 0;
        double avg = 0;

        System.out.println("=============================");
        System.out.println("  국어  수학  영어  총점  평균");

        for (int i = 0; i < score.length; i++) {
            for( int j = 0; j < score[0].length; j++) {
                System.out.printf("%5d",score[i][j]);
                sum += score[i][j];
            }
            avg = Math.round(sum / (double)score[0].length * 10 ) / 10.0;
            System.out.printf("%5d%5s%n",sum,avg);
            sum=0;
        }
        System.out.println("=============================");
    }
}