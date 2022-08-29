package algorithm;

// 최소공약수
// 최대공배수

public class Euclid {
    public static void main(String[] args) {
        System.out.println(euclid1(30,50));
        System.out.println(euclid2(30,50));
        System.out.println(euclid3(30,50));
    }

    // 최소 공약수1
    public static int euclid1(int a, int b) {

        while (a != b) {
            if ( a > b ) a-=b;
            else b-=a;
        }

        return a;
    }

    // 최소 공약수2
    // MOD 연산을 활용하여 연산 횟수가 줄어든다
    public static int euclid2(int a, int b) {
        while ( b != 0 ) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    // 최소 공배수
    // 유클리드 호제법과 아무 관계 없다. ㅎ 분류가 애매해서..
    // 최소 공배수 구하는 공식
    // == 서로소가 나올 때까지 공약수로 나눈 뒤, 공약수에 서로소를 곱한다
    public static int euclid3(int a, int b) {
        int result = 1;
        int max = Math.max(a,b);

        for (int i=2; i<max; i++) {
            while ( a%i == 0 && b%i == 0 ) {
                a /= i;
                b /= i;

                result *= i;
            }
        }

        return result * a * b;
    }
}


