package standardOfJava.String;

// 문자열을 문자로, 문자를 문자열로
public class stringToChar {
    public static void main(String[] args) {
        String str = "I'm a genius.";
        char[] strArr = new char[str.length()];
        for ( int i = 0; i < str.length(); i++ ) {
            strArr[i] = str.charAt(i);
            System.out.println(i + "번째 글자 : " + strArr[i]);
        }

        String newStr = new String(strArr);
        char[] newArr = newStr.toCharArray();
        System.out.println(newStr);
        System.out.println(newArr);
        // char는 pritnln으로 출력해도 문자열처럼 이어져서 나옴.
    }
}
