package standardOfJava.Array;

import java.util.Arrays;

public class copyArr2 {
    public static void main(String[] args) {
        int[] originArr = { 1,2,3,4,5 };
        int[] copyArr = new int[originArr.length*2];

        System.arraycopy(originArr,0,copyArr,0,originArr.length);
        System.out.println(Arrays.toString(copyArr));
        System.out.println(Arrays.toString(originArr));
    }
}
