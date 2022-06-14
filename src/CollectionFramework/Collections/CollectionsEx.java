package CollectionFramework.Collections;

import java.util.*;

public class CollectionsEx {
    public static void main(String[] args) {
        // 동기화 필요할 때 사용
        // Vector와 Hashtable을 제외하면 비동기
        List list = Collections.synchronizedList(new ArrayList<>());

        // 싱글톤
        // 하나의 객체만 저장하고 싶을 때 사용
        Set set = Collections.singleton(new EmptyClass());

        // 한 종류의 객체만 저장하게 하고 싶을 때 사용
        // 호환성 문제로 제네릭 말고도 쓰일 때가 있다고 함
        ArrayList list2 = new ArrayList();
        List newList = Collections.checkedList(list2,String.class);

        // 변경 불가(읽기 전용) 으로 컬렉션을 만들고 싶을 때 사용
        // 여러 쓰레드가 하나의 컬렉션을 공유하다가 데이터가 손상되는 상황 방지
        Map map = Collections.unmodifiableMap(new TreeMap<>());

        LinkedList test = new LinkedList();

        // 한 번에 값 추가
        Collections.addAll(test, 1,2,3,4,5,6);
        System.out.println("Collections.addAll(test, 1,2,3,4,5,6) => " + test);
        // 우측으로 지정 값만큼 이동
        Collections.rotate(test, 2);
        System.out.println("Collections.rotate(test, 2) => " + test);
        // 지정 인덱스 값 뒤바꿈
        Collections.swap(test, 3, 4);
        System.out.println("Collections.swap(test, 3, 4) => " + test);
        // 랜덤 뒤섞기
        Collections.shuffle(test);
        System.out.println("Collections.shuffle(test) => " + test);
        // 정렬
        Collections.sort(test, Collections.reverseOrder());
        System.out.println("Collections.sort(test, Collections.reverseOrder()) => " + test);
        // 역순 정렬
        Collections.sort(test);
        System.out.println("Collections.sort(test) => " +test);
        // 이진 검색
        int index = Collections.binarySearch(list, 3);
        System.out.println("int index = Collections.binarySearch(list, 3) => " + index);
        // 최대값
        System.out.println("Collections.max(test) => " + Collections.max(test) );
        // 최소값
        System.out.println("Collections.min(test) => " + Collections.min(test) );
        // 최대값(의 반대) 근데 왜 굳이..?
        System.out.println("Collections.max(test, reverseOrder()) => " + Collections.max(test, Collections.reverseOrder()) );
        // 지정한 값으로 채움
        Collections.fill(test,9);
        System.out.println("Collections.fill(test,9) => " + test);
        // 새로운 컬렉션에 복사
        List newTest = new LinkedList(Collections.nCopies(test.size(), 3));
        System.out.println(" LinkedList newTest = Collections.nCopies(test.size(), 3) => newTest ? " + newTest);
        // 공통된 값이 전혀 없으면 true 있으면 false (서로소 집합)
        System.out.println("Collections.disjoint(test, newTest) => " + Collections.disjoint(test, newTest));
        // 컬렉션 값 복사
        Collections.copy(test, newTest);
        System.out.println("Collections.copy(test, newTest) => test ? " + test + " newTest ? " + newTest);
        // 컬렉션의 특정 값을 모두 대체
        Collections.replaceAll(test, 3, 9);
        System.out.println("Collections.replaceAll(test, 3, 9) => " + test);

        Enumeration e = Collections.enumeration(test);
        ArrayList<Object> test2 = Collections.list(e);
        System.out.println("test2 => " + test2);
    }
}

class EmptyClass{
    String hihi = "히히";
}