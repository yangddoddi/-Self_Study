package CollectionFramework.Iterator;


import java.util.Iterator;

public class IteratorEX2 {
    public static void main(String[] args) {
        MyArrayList2<String> test = new MyArrayList2<>(20);
        for (int i = 0; i < 6; i++) {
            System.out.println(test.add(i+""));
        }
        System.out.println(test);

        Iterator it2 = test.iterator();
        it2.next();
        it2.remove();
        it2.next();
        it2.remove();
        System.out.println(it2);
    }
}

