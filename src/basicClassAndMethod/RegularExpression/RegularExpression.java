package basicClassAndMethod.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        String[] data = {"apple","smasung", "microsoft", "lenova", "lg", "shaomi", "google", "dell", "hansung"};
        Pattern p = Pattern.compile("s[a-z]*"); // s로 시작하는 모든 소문자 단어

        for(int i=0; i<data.length; i++) {
            Matcher m = p.matcher(data[i]);
            if(m.matches()) {
                System.out.println(data[i] + ", ");
            }
        }
    }
}
