package standardOfJava.CollectionFramework.ArrayList;

public class ArrayListEX {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(20);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        System.out.println(list.contains(2));

        list.set(2, 4);
        System.out.println(list);

        list.add(2, 5);
        System.out.println(list);

        list.remove(0);
        System.out.println(list);
    }
}
