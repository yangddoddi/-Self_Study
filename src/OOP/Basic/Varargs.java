package OOP.Basic;

// 가변 인자 예제 실습
public class Varargs {
    static String DelimiterMaker(String delimiter, String ...args) {
        StringBuilder result = new StringBuilder();
        for ( String arg : args ) {
            result.append(arg).append(delimiter);
        }
        return result.toString();
    }
    static String DelimiterMaker(String delimiter, int ...args) {
        StringBuilder result = new StringBuilder();
        for ( int arg : args ) {
            result.append(arg).append(delimiter);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(DelimiterMaker(",", 1,2,3,4,5,6));
        System.out.println(DelimiterMaker("-", "나는","바보다","나는","천재다"));
    }
}
