package standardOfJava.CollectionFramework.Iterator;
import java.util.*;

public class IteratorEX1 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        String str = "안녕하세요";
        for (int i=0; i<str.length(); i++) {
            al.add(String.valueOf(str.charAt(i)));
        }
        System.out.println(al);

        Iterator it = al.iterator();
        Enumeration en = Collections.enumeration(al);
        ListIterator lit = al.listIterator();

        while(it.hasNext()) {
            System.out.println("Iterator : " + it.next());
        }

        while(en.hasMoreElements()) {
            System.out.println("Enumeration : " + en.nextElement());
        }

        while(lit.hasNext()) {
            System.out.println("ListIterator : " + lit.next());
        }

        while(lit.hasPrevious()) {
            System.out.println("ListIterator는 이런 것도 되지롱 : " + lit.previous());
        }

        while (lit.hasNext()) {
            lit.next();
            lit.remove();
            // next로 읽어온 값을 삭제하는 것이기 때문에 remove 단독으로 사용할 수 없다.
        }

        // remove 예시
        ArrayList<Integer> origin = new ArrayList<>();
        ArrayList<Integer> copy1 = new ArrayList<>();
        ArrayList<Integer> copy2 = new ArrayList<>();

        for (int i=1; i<=10; i++) {
            origin.add(i);
        }

        ListIterator<Integer> iterator = origin.listIterator();

        System.out.println("============복사 예시=============");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            copy1.add((Integer) iterator.next());
        }
        System.out.println(origin); // [1,2,3,4,5,6,7,8,9,10]
        System.out.println(copy1); // [1,2,3,4,5,6,7,8,9,10]

        System.out.println("============재사용 불가능 예시=============");
        while(iterator.hasNext()) {
            copy2.add((Integer) iterator.next());
            iterator.remove();
        }
        System.out.println(origin); // [1,2,3,4,5,6,7,8,9,10]
        System.out.println(copy2); // []
        // Iterator 객체는 한 번 사용하면 새로 만들어야 한다
        // 이미 사용됐기 때문에 값의 변화 x

        ListIterator<Integer> iterator2 = origin.listIterator();

        System.out.println("============이동 예시=============");
        while(iterator2.hasNext()) {
            copy2.add((Integer) iterator2.next());
            iterator2.remove();
        }
        System.out.println(origin); // []
        System.out.println(copy2); // [1,2,3,4,5,6,7,8,9,10]
    }
}
