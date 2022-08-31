package algorithm;

import java.util.Arrays;

/*
*
* 버블 정렬
* 시간복잡도 : n^2
*
* */


public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{40,1000,50,20,10,0,100,40,120};
        AscendingSort(arr);

        int[] arr2 = new int[]{40,1000,50,20,10,0,100,40,120};
        DescendingSort(arr2);

        int[] arr3 = new int[]{40,1000,50,20,10,0,100,40,120};
        improvedBubbleSort(arr3);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }


    public static void AscendingSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length-i-1; j++) {
                if ( arr[j] > arr[j+1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void DescendingSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] < arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /*
     *
     * 한 번의 교환도 일어나지 않을 경우 정렬이 끝난 것이므로 반복문을 빠져나온다
     *
     * */

    private static void improvedBubbleSort(int[] arr) {
        boolean isChanged = false;
        for (int i=0; i< arr.length; i++) {
            isChanged = false;
            for (int j=0; j< arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isChanged = true;
                }
            }
            if (!isChanged) break;
        }
    }

}
