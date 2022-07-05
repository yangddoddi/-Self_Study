package standardOfJava.CollectionFramework.ComparableAndComparator;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableAndComparable {
    public static void main(String[] args) {
        String[] strArr = { "b", "f", "d", "A", "C", "Z", "T"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));
        //[A, C, T, Z, b, d, f]
        //기본 정렬 방식이 Comparable 인터페이스에 의한 것
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(strArr));
        //[A, b, C, d, f, T, Z]
        Arrays.sort(strArr, new Reverse());
        System.out.println(Arrays.toString(strArr));
        //[f, d, b, Z, T, C, A]
        // 추가로 뒤에 조건이 붙으면 Comparator 인터페이스에 의한 것
    }
}

class Reverse implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if ( o1 instanceof Comparable || o2 instanceof Comparable ) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1;
            // 비교 결과에 음수를 곱해서 역순 정렬
        }
        return -1;
        // 비교 불가능하면 -1
    }
}
