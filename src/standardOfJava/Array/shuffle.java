package standardOfJava.Array;

import java.util.Arrays;

// 배열 값 뒤섞기
public class shuffle {
    public static void main (String[] args) {
        int[] arr = new int[10];
        for ( int i = 0; i < arr.length; i++ ) {
            arr[i] = i + 1;
        }
        System.out.println("초기 배열 값 : " + Arrays.toString(arr));

        for ( int i = 0; i < 100; i++ ) {
            int randomIndex = (int)(Math.random()*10);
            int temp = arr[0];
            arr[0] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
        System.out.println("셔플된 배열 값 : " + Arrays.toString(arr));
    }
}
