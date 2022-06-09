package basicClassAndMethod.StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizer2 {
    public static void main(String[] args) {
        String source = "1,김응애,100,100,100|2,박응애,95,85,90|3,김바보,80,70,60";
        StringTokenizer strToken = new StringTokenizer(source,"|",false);
        while ( strToken.hasMoreTokens() ) { // | 을 기준으로 먼저 나눈다
            String token = strToken.nextToken();
            StringTokenizer strToken2 = new StringTokenizer(token,",", false);
            while (strToken2.hasMoreTokens()) {
                System.out.println(strToken2.nextToken());
            }
            System.out.println("---------");
        }
    }
}
