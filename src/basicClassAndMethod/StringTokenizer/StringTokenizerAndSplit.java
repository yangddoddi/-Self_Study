package basicClassAndMethod.StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizerAndSplit {
    public static void main (String[] args) {
        String data = "제가,,술,한잔,,했읍니다,,";
        String[] dataSplit = data.split(",");
        StringTokenizer tokenizer = new StringTokenizer(data,",",false);

        System.out.print("tokenizer 구분자 개수 : " + tokenizer.countTokens() + ", ");
        while(tokenizer.hasMoreTokens()) {
            System.out.print(tokenizer.nextToken() + ", ");
        }
        System.out.println();
        // 빈 문자열의 토큰은 체크하지 않는다.

        System.out.print("spite 구분자 개수 : " + dataSplit.length + ", ");
        for ( String str : dataSplit) {
            System.out.print(str + ", ");
        }
        // 빈 문자열도 토큰으로 인식하고 구분자를 남긴다.
    }
}
