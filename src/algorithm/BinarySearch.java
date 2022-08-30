package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearch {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] array = new int[]{ 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80 };
        int result = binarysearch(input, array);
        System.out.println(result);
    }

    /*
    *
    * 선형탐색이였을 경우 시간 복잡도 O(N)에 의해 N=11
    * 이진탐색의 경우 시간 복잡도 O(log₂N)이므로 O(log₂11) = 4
    *
    * */

    public static int binarysearch(int num, int[] numArr) {

        int left = 0;
        int right = numArr.length;
        int count = 0;

        while ( left < right ) {
            System.out.println("탐색 횟수 = " + ++count);
            int middle = (right+left)/2;

            if ( numArr[middle] == num ) return numArr[middle];
            else if ( numArr[middle] < num ) left = middle;
            else if ( numArr[middle] > num ) right = middle;
        }

        return -1;
    }
}
