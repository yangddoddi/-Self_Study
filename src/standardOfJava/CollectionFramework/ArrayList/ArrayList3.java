package standardOfJava.CollectionFramework.ArrayList;

import java.util.ArrayList;

public class ArrayList3 {
    public static void main (String[] args) {
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);

        print(arrList,10);
        arrList.trimToSize();
        print(arrList, 3);
        arrList.ensureCapacity(6);
        print(arrList, 6);
        arrList.clear();
        print(arrList, 6);
    }

    static void print(ArrayList<Integer> arrayList, int capacity) {
        System.out.println("arrList ? " + arrayList);
        System.out.println("size ? " + arrayList.size());
        System.out.println("capacity ? " + capacity);
    }
    // 중요
    // 객체를 삭제하거나 용량을 줄일 때는 문제가 없으나
    // 용량을 늘릴 때는 기존 배열을 복사해서 새로운 배열을 만들기 때문에 성능에 좋지 않다.
    // 처음부터 적당 용량을 계산해서 만들도록 하자.
}
