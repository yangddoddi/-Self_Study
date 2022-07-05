package standardOfJava.basicClassAndMethod.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 정규식 grouping
public class RegularExpression3 {
    public static void main(String[] args) {
        String source = "HP:010-2295-2294, HOME:02-719-3394";
        String pattern = "(0\\d{1,2})-(\\d{3,4})-(\\d{4})";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);

        while (m.find()) {
            System.out.println( m.group() + " -> " + m.group(1) + ", " + m.group(2) + ", " + m.group(3));
        }
    }
}
