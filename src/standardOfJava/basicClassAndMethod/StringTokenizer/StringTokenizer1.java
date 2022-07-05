package standardOfJava.basicClassAndMethod.StringTokenizer;

import java.util.StringTokenizer;

public class StringTokenizer1 {
    public static void main(String[] args) {
        String str = "(충격 실화) 띄어쓰기를, 할, 때마다, 쉼표를, 적어야하는, 사람이, 있다?";
        StringTokenizer strToken = new StringTokenizer(str, "(),? ", false);
        while (strToken.hasMoreTokens()) {
            System.out.println(strToken.nextToken());
        }
    }
}
