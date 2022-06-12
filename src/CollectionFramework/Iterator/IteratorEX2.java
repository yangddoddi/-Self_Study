package CollectionFramework.Iterator;


import java.util.Iterator;

public class IteratorEX2 {
    public static void main(String[] args) {
        MyArrayList2<String> test = new MyArrayList2<>(20);
        for (int i = 0; i < 6; i++) {
            System.out.println(test.add(i+""));
        }
        System.out.println(test);

        Iterator it = test.iterator();
        while ( it.hasNext() ) {
            System.out.println(it.next());
        }

        Iterator it2 = test.iterator();
        while ( it.hasNext() ) {
            it.next();
            it.remove();
        }
        System.out.println(it2);
    }
}

