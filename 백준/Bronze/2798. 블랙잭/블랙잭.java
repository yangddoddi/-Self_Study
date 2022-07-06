import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        // 제공되는 카드 수
        int cardDraw = Integer.parseInt(st.nextToken());
        // 최대값
        int baseValue = Integer.parseInt(st.nextToken());

        ArrayList<Integer> cardArr = new ArrayList<>();
        int max = 0;

        // 카드 목록
        st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()) {
            cardArr.add(Integer.parseInt(st.nextToken()));
        }

        for (int cardNum1 : cardArr) {
            for (int cardNum2 : cardArr) {
                for (int cardNum3 : cardArr) {
                    if (cardNum1==cardNum2 || cardNum1==cardNum3 || cardNum3==cardNum2) {
                        break;
                    }
                    int sum = cardNum1 + cardNum2 + cardNum3;
                    if ( sum <= baseValue ) {
                        if ( max < sum ) {
                            max = sum;
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}