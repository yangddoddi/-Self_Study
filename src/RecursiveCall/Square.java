package RecursiveCall;

public class Square {
    public static long sum(int num, int n) {
        if ( n == 1 ) return num;
        return num * sum(num,--n);
    }
    // 제곱을 구하는 메소드

    public static void main(String[] args) {
        int n = 5;
        long result = 0;

        System.out.println(sum(2,5));

        for ( int i=1; i<n; i++) {
            result += sum(2,i);
            System.out.println(result);
        }
        // 2의 n제곱을 각각 더하는 반복문
    }
}
