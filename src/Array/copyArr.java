package Array;

import java.util.Arrays;

// 배열 복사
public class copyArr {
    public static void main(String[] args) {
        int[] originArr = { 1,2,3,4,5 };
        int[] copyArr = new int[originArr.length*2];

        for ( int i=0; i< originArr.length; i++) {
            copyArr[i] = originArr[i];
        }

        System.out.println(Arrays.toString(copyArr));
        System.out.println(Arrays.toString(originArr));
    }
    // originArr과 copyArr은 같은 배열을 참조하게 되고 기존의 { 1,2,3,4,5 } 배열은 사용할 수 없게 된다.
    // JVM의 가비지 컬렉터가 기존 배열은 메모리에서 삭제한다.
}
