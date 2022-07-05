package standardOfJava.Array;

import java.util.Arrays;

public class LottoNumMaker {
    public static void main  (String[] args) {
        // 1~45 저장된 배열 생성
        int[] lotto = new int[45];
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = i+1;
        }
        System.out.println("처음 배열 : " + Arrays.toString(lotto));

        // 배열 뒤섞기
        for (int i = 0; i < lotto.length *10; i++) {
            int randomIndex = (int)(Math.random()*(lotto.length));
            int temp = lotto[0];
            lotto[0] = lotto[randomIndex];
            lotto[randomIndex] = temp;
        }
        System.out.println("뒤섞인 배열 : " + Arrays.toString(lotto));

        int[] winningNum = new int[6];

        // 랜덤하게 6자리 꺼내기
        for (int i = 0; i < winningNum.length; i++) {
            int randomIndex = (int)(Math.random()*(lotto.length));
            winningNum[i] = lotto[randomIndex];
        }
        System.out.println("행운의 번호 : " + Arrays.toString(winningNum));
    }
}
