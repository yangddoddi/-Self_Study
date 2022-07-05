package standardOfJava.basicClassAndMethod.String;

import java.util.Arrays;
import java.util.StringJoiner;

public class StringBasic {
    public static void main(String[] args) {
        String a = "응애";
        String b = "응애";

        String A = new String("응애");
        String B = new String("응애");

        System.out.println("a == b ? " + (a==b));
        System.out.println("a.equals(b) ? " + (a.equals(b)));

        System.out.println("A == B ? " + (A==b));
        System.out.println("A.equals(B) ? " + (A.equals(B)));

        System.out.println("a == A ? " + (a==A));
        System.out.println("a.equals(A)? " + (a.equals(A)));

        char[] c = new char[0];
        String str = new String(c);
        System.out.println("str = " + str);

        // new standardOfJava.String(StringBuffer|standardOfJava.String|char[] str)
        char[] c2 = {'안','녕','하','세','요','.'};
        String str2 = new String(c2); // 주어진 문자열을 가진 standardOfJava.String 인스턴스 생성
        System.out.println("str2 = " + str2);

        // charAt(int index)
        char c3 = str2.charAt(3); // 문자열 인덱스에 해당하는 문자 반환
        System.out.println("str2.charAt(3) = " + c3);

        // compareTo(standardOfJava.String str)
        String s = "aa";
        String s2 = "bb";
        String s3 = "cc";
        System.out.println("\"aa\".compareTo(\"bb\") = " + s.compareTo(s2)); // 사전순으로 비교
        System.out.println("\"aa\".compareTo(\"cc\") = " + s.compareTo(s3));
        System.out.println("\"cc\".compareTo(\"bb\") = " + s3.compareTo(s2));

        // concat(standardOfJava.String str)
        String s4 = "Hello, ";
        String s5 = "World!";
        System.out.println("\"Hello, \".concat(\"World!\") = " + s4.concat(s5));

        //endWith(standardOfJava.String str)
        //startWith(standardOfJava.String str)
        String doc = "(충격)자바고수되는법ㄷㄷ.txt";
        System.out.println("doc.endWith(\"txt\") = " + doc.endsWith("txt"));
        System.out.println("doc.startWith(\"(충격)\") = " + doc.startsWith("(충격)"));

        //equals(Object obj)
        String same = "자.바.좋.아";
        String same2 = "자.바.좋.아";
        System.out.println("same.equals(same2) = " + same.equals(same2));

        //equalsIgnoreCase(standardOfJava.String str)
        String same3 = "I love JAVA";
        String same4 = "i love java";
        System.out.println("same3.equalsIgnoreCase(same4) = " + same3.equalsIgnoreCase(same4));

        //indexOf(int ch, int pos)
        //lastIndexOf(standardOfJava.String str)
        //index와 달리 뒤에서부터 찾는다
        String strIndex = "HTML은 프로그래밍 언어입니다.";
        System.out.println("strindex.indexOf(\"뿡\") =" + strIndex.indexOf("뿡")); // false가 아니라 -1
        System.out.println("strindex.indexOf(\"입\") =" + strIndex.indexOf("입")); // 몇 번째 인덱스인지
        System.out.println("strindex.indexOf(\"입\", 10) =" + strIndex.indexOf("입", 15));
        // 15번째 인덱스부터~
        System.out.println("strindex.indexOf(\"입니다\") =" + strIndex.indexOf("입니다"));

        //intern()
        String strIntern = new String("자바스크립트와 자바의 관계는 강아지와 땅강아지간의 관계와 같다.");
        String strIntern2 = new String("자바스크립트와 자바의 관계는 강아지와 땅강아지간의 관계와 같다.");
        String strIntern3 = "자바스크립트와 자바의 관계는 강아지와 땅강아지간의 관계와 같다.";
        System.out.println("strIntern == strIntern2 ? " + (strIntern == strIntern2));
        System.out.println("strIntern == strIntern3 ? " + (strIntern == strIntern3));
        System.out.println("strIntern.intern() == strIntern2.intern() ? " + (strIntern.intern() == strIntern2.intern()));
        System.out.println("strIntern.intern() == strIntern3 ? " + (strIntern.intern() == strIntern3));
        System.out.println("strIntern.intern() == strIntern3.intern() ? " + (strIntern.intern() == strIntern3.intern()));
        // HeapStack의 constant pool 등록된 문자열의 주소값을 반환하기 때문에..

        //length() => return int
        String length = "length";
        System.out.println("length.length() ? " + length.length());

        // replace(char||CharSequence old, char||CharSequence new)
        // replaceAll(standardOfJava.String regex, standardOfJava.String replacement) => 차이점은 정규식이 사용 가능함.
        // replaceFirst(standardOfJava.String regex, standardOfJava.String replacement) => 처음 만나는 문자열만 변경함
        String strReplacement = "자바는 정말 전설이다 ㄷㄷ";
        System.out.println("strReplacement.replace(\"자바\",\"자바스크립트\") = " + strReplacement.replace("자바","자바스크립트"));
        String strReplacement2 = "AABBCCBB";
        String strReplaceAll = "AABBCCBB";
        System.out.println("strReplacement2.replace(\"[ABC]\",\"DD\") = " + strReplacement2.replace("[ABC]","DD"));
        System.out.println("strReplacement2.replaceFirst(\"BB\",\"ZZ\") = " + strReplacement2.replaceFirst("BB","ZZ"));
        System.out.println("strReplaceAll.replaceAll(\"[ABC]\",\"DD\") = " + strReplaceAll.replaceAll("[ABC]","DD"));

        //split(standardOfJava.String regex, int limit) => return standardOfJava.String[]
        //join(standardOfJava.String str, standardOfJava.String[] arr) => return standardOfJava.String
        String strSplit = "자바,자바스크립트,러스트,GO";
        String[] strSplitArr = strSplit.split(",");
        String[] strSplitArr2 = strSplit.split(",", 3);
        System.out.println("strSplit.split(\",\") = " + Arrays.toString(strSplitArr));
        System.out.println("strSplit.split(\",\", 1) = " + Arrays.toString(strSplitArr2));
        System.out.println("strSplitArr2[2] = " + strSplitArr2[2]);
        String[] splitedStr = strSplit.split(",");
        String joinStr = String.join("-", splitedStr);
        System.out.println("standardOfJava.String.join(\"-\", splitedStr) = " + joinStr);

        StringJoiner stringJoiner = new StringJoiner("-","[","]");
        for ( String str10 : splitedStr ) {
            stringJoiner.add(str10);
        }
        System.out.println("new StringJoiner(\"-\",\"[\",\"]\").add(splitedStr 반복문) = " + stringJoiner);

        //standardOfJava.String substring(int begin, int end)
        //시작부터 끝으로 지정할 경우 시작 <= 결과 < 끝이다. 끝은 결과에 포함되지 않음을 주의.
        String subStringEx = "러스트가 주도하는 질서는 막을 수 없다";
        System.out.println("subStringEx.substring(10) = " +subStringEx.substring(10));
        System.out.println("subStringEx.substring(10, 15) = " +subStringEx.substring(10,15));

        // standardOfJava.String toLowerCase() | toUpperCase()
        String strCase = "I am Iron-man";
        System.out.println("strCase.toLowerCase() = " + strCase.toLowerCase());
        System.out.println("strCase.toUpperCase() = " + strCase.toUpperCase());

        // toString()
        String ToString = "toString";
        System.out.println("ToString.toString() = " + ToString.toString());

        // trim()
        String sideEmpty = "     xl지존x자바lx     ";
        System.out.println("sideEmpty.trim() = " + sideEmpty.trim());

        // standardOfJava.String.valueOf(boolean | char | int | long | float | double | Object all )
        // 지정 값을 문자열로 반환 (생략)
        // + 해당 값들을 다시 원래 값으로 반환하려면 ?
        // Boolean.valueOf , Integer.valueOf , Boolean.parseBoolean 등 ..
        // String으로 변환 시 값 + ""도 편리하게 사용 가능하나 성능은 valueOf보다 좋지 않다.
        // String을 값으로 재변환 시 공백이 있을 경우 예외가 발생할 수 있기 때문에 trim()을 같이 사용하면 좋다.
        // 숫자 변환 시 자료형에 의한 예외가 발생하기 쉽기 떄문에(ex ) Integer.parseInt("1.0F")) 예외 처리를 잘 해줘야함.

    }
}
