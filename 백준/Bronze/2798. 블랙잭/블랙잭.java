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

        for (int i=0; i<cardArr.size()-2; i++) {
            for (int j=i+1; j<cardArr.size()-1; j++) {
                for (int k=j+1; k<cardArr.size(); k++) {
                    int sum = cardArr.get(i) + cardArr.get(j) + cardArr.get(k);
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