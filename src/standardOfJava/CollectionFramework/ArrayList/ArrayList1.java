package standardOfJava.CollectionFramework.ArrayList;

import java.util.*;

// 기본 사용법
// 주의 -> Collection은 인터페이스고 Collections는 클래스임.
public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(20);
        list1.add("자");
        list1.add("마");
        list1.add("다");
        list1.add("나");
        list1.add("차");

        ArrayList<String> list2 = new ArrayList<>(list1.subList(1, 4)); // 지정된 인덱스에 있는 객체 반환
        System.out.println("list1 : " + list1);
        System.out.println("List2 : " + list2);

        Collections.sort(list1);
        // 지정된 정렬 기준으로 ArrayList 정렬
        System.out.println("Collections.sort(list1) ? " + list1);
        Collections.sort(list2);
        System.out.println("Collections.sort(list2) ? " +list2);

        System.out.println("list1.containsAll(list2) ? " + list1.containsAll(list2));
        // containsAll - 해당 List에 있는 모든 값을 가지고 있다면 true

        list1.add("A");
        list1.add("C");
        list1.add(6,"B");
        list2.set(0,"나천재");
        // add -> List의 마지막 인덱스 혹은 지정 인덱스에 객체 삽입
        // set -> 해당 인덱스의 객체를 지정 인덱스로 대체
        System.out.println(" list1.add(\"A\"), list1.add(\"B\"),list1.add(36,\"A\") => " + list1);
        System.out.println(" list2.set(0,\"나천재\") => " + list2);

        list1.retainAll(list2);
        // list1에서 list2와 같은 객체를 제외하고 모두 제거
        System.out.println("list1.retainAll(list2) => list1 : " + list1);
//
//        list2.removeAll(list1);
//        // list2에서 list1과 같은 객체 제외하고 모두 제거
//        System.out.println("list2.removeAll(list1) => list2 : " + list2);

        for (int i=list2.size()-1; i>=0; i--) {
            if (list1.contains(list2.get(i))) {
                list2.remove(i);
            }
        }
        // ArrayList는 중간에 객체가 삭제되면 앞으로 자료들이 당겨지기 때문에
        // 반복문으로 삭제시 뒤에서부터 연산해야함.
    }
}