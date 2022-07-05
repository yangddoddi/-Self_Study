package standardOfJava.basicClassAndMethod.RegularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 정규식과 일치하는 부분의 start와 end를 알아낼 수 있다.
// m.appendReplacement(StringBuffer sb, standardOfJava.String replacment)로 변경 가능
public class RegularExpression4 {
    public static void main(String[] args) {
        String source = "(충격 실화) 자바 코드를 메모장에 작성해서 개발하는 사람이 있다? (충격 실화)";
        String pattern = "충격 실화";
        StringBuffer sb = new StringBuffer();

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        System.out.println("soucre:" + source);
        int i = 0;
        while (m.find()) {
            System.out.println( i++ + "번째 : " + m.start() + " ~ " + m.end() );
            m.appendReplacement(sb, "감동 실화");
        }
        m.appendTail(sb); // appendReplacement에서 수정한 부분 이후의 부분을 덧붙여서 완성한다.
        System.out.println("Replacement count : " + i);
        System.out.println("result:" + sb.toString());
    }
}
