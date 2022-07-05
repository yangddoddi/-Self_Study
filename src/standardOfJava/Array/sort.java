package standardOfJava.Array;

import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        int[] numArr = { 48,1,27,0,45,13};


        for ( int i=0; i<numArr.length-1; i++) {
            boolean isChanged = false;
            for ( int j=0; j<numArr.length-1-i; j++) {
                if ( numArr[j] > numArr[j+1] ) {
                    int temp = numArr[j+1];
                    numArr[j+1] = numArr[j];
                    numArr[j] = temp;
                    isChanged = true;
                }
            }
            if (!isChanged) break;
        }

        System.out.println(Arrays.toString(numArr));
    }
}
