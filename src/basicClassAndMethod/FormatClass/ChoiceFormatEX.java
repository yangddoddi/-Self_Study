package basicClassAndMethod.FormatClass;

import java.text.ChoiceFormat;
// 특정 범위에 속하는 값 문자열로 변환
public class ChoiceFormatEX {
    public static void main(String[] args) {
        double[] limits = { 60, 70, 80, 90 };
        String[] grade = { "F", "C", "B", "A"};
//        String pattern = "60#D|70#C|80<B|90#A";
//        ChoiceFormat format = new ChoiceFormat(pattern);
//        패턴으로도 가능하다
        int[] source = { 24,78,33,91,87,74,89,71,100};
        ChoiceFormat format = new ChoiceFormat(limits, grade);

        for ( int num : source ) {
            System.out.println(format.format(num) + " : " + num);
        }
    }
}
