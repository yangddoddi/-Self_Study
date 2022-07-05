package standardOfJava.Array;

// 다차원 배열 합계 구하기
public class doubleArray {
    public static void main(String[] args) {
        int[][] arr = { {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}};
        int sum = 0;

        for ( int[] outer : arr) {
            for ( int inner : outer) {
                sum += inner;
            }
        }

        System.out.println(sum);
    }
}