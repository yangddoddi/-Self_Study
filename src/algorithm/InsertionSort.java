package algorithm;

import java.util.Arrays;

/*
* 삽입 정렬
* 시간복잡도 : O(N^2)
* */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{40,90,30,10,100,50};
        sortAscending(arr);

        int[] arr2 = new int[]{40,90,30,10,100,50};
        sortDescending(arr2);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }


    /*
     *
     * 오름차순 정렬
     * 비교 대상을 temp에 저장
     * 만약 temp 앞의 숫자가 temp보다 크다면?
     * temp가 있던 위치에 앞의 숫자 넣고, 앞에는 temp 저장
     * 반복횟수를 늘려가며 정렬
     *
     * */

    public static void sortAscending(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int temp = arr[i];
            for (int j=i-1; j>=0; j--) {
                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                } else break;
            }
        }
    }

    /*
    *
    * 내림차순 정렬
    *
    * */

    public static void sortDescending(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int temp = arr[i];

            for (int j=i-1; j>=0; j--) {
                if (arr[j] < temp) {
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                } else break;
            }
        }
    }
}
