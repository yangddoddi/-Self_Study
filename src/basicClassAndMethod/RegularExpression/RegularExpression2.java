package basicClassAndMethod.RegularExpression;

import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression2 {
    public static void main (String[] args) {
        String[] data = {"kakao", "samsung", "hynix", "hyundai", "Honda", "apple", "tesla", "google", "Meta",
                "Naver", "tsmc", "lenova", "dell", "hi", "Hi22", "hello1", "hiHI"};
        String[] regex = {"h[a-z]", "h[a-z]*", "h[a-zA-Z]*", "h[a-zA-Z0-9]", "c\\d", ".*", "h.*", "h\\d", "[b|c].*", ".*a.*", ".*a.+",
        "[b|c].{2}","h\\."};

        for (int i=0; i<regex.length; i++) {
            System.out.print("Pattern : " + regex[i] + " 결과 : ");
            Pattern p = Pattern.compile(regex[i]);
            for (int j=0; j<data.length; j++) {
                Matcher m = p.matcher(data[j]);
                if (m.matches()) {
                    System.out.print(data[j] + ", ");
                }
            }
            System.out.println();
        }
    }
}
