package standardOfJava.CollectionFramework.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedList1 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(2000000);
        LinkedList<Integer> ll = new LinkedList<>();

        System.out.println("====== 시작부터 추가");
        System.out.println("ArrayList : " + add1(al));
        System.out.println("LinkedList : " + add1(ll));
        System.out.println("====== 중간부터 추가");
        System.out.println("ArrayList : " + add2(al));
        System.out.println("LinkedList : " + add2(ll));
        System.out.println("====== 중간부터 삭제");
        System.out.println("ArrayList : " + remove2(al));
        System.out.println("LinkedList : " + remove2(ll));
        System.out.println("====== 순차적으로 삭제");
        System.out.println("ArrayList : " + remove1(al));
        System.out.println("LinkedList : " + remove1(ll));

        add1(al);
        add1(ll);

        System.out.println("====== 접근 속도");
        System.out.println("ArrayList : " + access(al));
        System.out.println("LinkedList : " + access(ll));

        // 결론 1 . 순차적으로 추가/제거하는 경우 ArraylList가 빠르다. (미리 공간이 확보되어 있었다는 가정하에)
        // 결론 2 . 중간부터 추가/제거하는 경우 LinkedList가 빠르다.
        // 결론 3 . 읽기 속도는 ArrayList가 빠르다.
        // => ArrayList : 읽기, 쓰기 속도가 빠르지만 중간부터 쓰는 속도는 느림, 메모리 사용 비효율적
        // => LinkedList : 쓰기 속도는 빠르지만 읽기 속도가 느림. 데이터가 많을수록 읽기 속도 저하가 더 심해짐.
    }

    public static long add1(List<Integer> list) {
        long start = System.currentTimeMillis();
        for(int i=0; i<1000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long add2(List<Integer> list) {
        long start = System.currentTimeMillis();
        for(int i=0; i<100000; i++) {
            list.add(500, i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remove1(List<Integer> list) {
        long start = System.currentTimeMillis();
        for(int i=list.size()-1; i>=0; i--) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long remove2(List<Integer> list) {
        long start = System.currentTimeMillis();
        for(int i=0; i<10000; i++) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long access(List<Integer> list) {
        long start = System.currentTimeMillis();
        for(int i=0; i<10000; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
