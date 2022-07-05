package standardOfJava.basicClassAndMethod.StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizer3 {
    public static void main(String[] args) {
        System.out.println(ChangeToNumFromKorean("오천삼백이십삼만이천백십이"));
    }

    public static long ChangeToNumFromKorean(String koreanString) {
        long result = 0;
        long tempResult = 0;
        long num = 0;

        final String NUMBER = "영일이삼사오육칠팔구";
        final String UNIT = "십백천만억조";
        final long[] UNIT_NUM = {10,100,1000,10000,(long)1e8,(long)1e12};

        StringTokenizer StringToken = new StringTokenizer(koreanString, UNIT, true); // 단위를 구분자로 나눈다

        while (StringToken.hasMoreTokens()) {
            String token = StringToken.nextToken();
            int check = NUMBER.indexOf(token);
            if (check == -1) {
                if (!"만억조".contains(token)) {
                tempResult += (num == 0 ? 1 : num ) * UNIT_NUM[UNIT.indexOf(token)];}
                else {
                    tempResult += num;
                    result += (tempResult==0? 1 : tempResult) * UNIT_NUM[UNIT.indexOf(token)];
                    tempResult = 0;
                }
                num = 0;
            } else {
                num = NUMBER.indexOf(token);
            }
        }
        return result + tempResult + num;
    }
}
