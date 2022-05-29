package Array;

import java.util.Arrays;

public class arrValueCounter {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] counter = new int[10];

        for ( int i=0; i < arr.length; i++ ) {
            arr[i] = (int)(Math.random()*10);
        }

        System.out.println(Arrays.toString(arr));

        for ( int i=0; i < arr.length; i++ ) {
            counter[arr[i]] += 1;
        }

        for ( int i=0; i < arr.length; i++ ) {
            System.out.println(i+"의 개수는 총 "+counter[i]+"개 입니다.");
        }
    }
}
