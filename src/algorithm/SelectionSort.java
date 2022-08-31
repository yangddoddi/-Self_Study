package algorithm;

/*
*
* 선택정렬
* 시간 복잡도 = O(N^2)
*
* */

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = new int[]{40,90,30,10,100,50};
        sortAscending(arr);

        int[] arr2 = new int[]{40,90,30,10,100,50};
        sortDescending(arr2);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }

    public static void sortAscending(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int min = i;

            for (int j=1+i; j<arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void sortDescending(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            int max = i;

            for (int j=1+i; j<arr.length; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }

            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
    }
}
