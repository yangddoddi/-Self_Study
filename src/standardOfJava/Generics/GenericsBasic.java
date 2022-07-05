package standardOfJava.Generics;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericsBasic {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        Box<Apple> appleBox = new Box<>();
        Box<Banana> bananaBox = new Box<>();
//        Box<Toy> toyBox = new Box<>(); Fruit을 상속하고 Eatable을 구현해야 가능

        fruitBox.add(new Apple("사과",500)); // apple은 타입 Fruit의 상속 클래스이므로 가능
        fruitBox.add(new Banana("바나나",100));
        fruitBox.add(new Fruit("과일",1000));

        appleBox.add(new Apple("사과",300));
        appleBox.add(new Apple("사과",600));

        bananaBox.add(new Banana("바나나",200));
        bananaBox.add(new Banana("바나나",100));
//        bananaBox.add(new Apple()); 타입 불일치

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(bananaBox);

        System.out.println(Juicer.makeJuice(fruitBox));

        fruitBox.getList().sort(new FruitComp());
        appleBox.getList().sort(new FruitComp());
        bananaBox.getList().sort(new FruitComp());

        System.out.println(fruitBox);
        System.out.println(appleBox);
        System.out.println(bananaBox);


    }
}


class Box<T extends Fruit & Eatable> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item) { list.add(item); }
    T get(int i) { return list.get(i); }
    int size() { return list.size(); }
    public String toString() { return list.toString(); }
    ArrayList<T> getList() { return list; }
}
class FruitBox<T extends Fruit> extends Box<T> {}

class Juice {
    String name;

    Juice(String name) {
        this.name = name + " juice";
    }

    public String toString() {
        return this.name;
    }
}

class Juicer {
    public static Juice makeJuice(FruitBox<? extends Fruit> fruitBox) {
        StringBuilder temp = new StringBuilder();
        for (Fruit f : fruitBox.getList()) {
            temp.append(f).append(" ");
        }
        return new Juice(temp.toString());
    }
}

class Fruit implements Eatable {
    String name;
    int weight;

    Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    public String toString() { return "Fruit(" + this.weight + ")"; }
}


class Apple extends Fruit {
    Apple(String name, int weight) { super(name,weight); }
    public String toString() { return "Apple(" + this.weight + ")"; }}
class Banana extends Fruit {
    Banana(String name, int weight) { super(name,weight); }
    public String toString() { return "Banana(" + this.weight + ")"; }}
class Toy { public String toString() { return "Toy"; }}

// sort 메서드의 Comparator의 제네릭 타입은 <? super T>라고 되어 있다.
// 따라서 <Fruit>라고 작성하면 실제로는 <? super Fruit>이므로 Fruit의 자손 클래스가 계속 늘어나도 Comparator를 재사용 가능하다.
class FruitComp implements Comparator<Fruit> {
    @Override
    public int compare(Fruit o1, Fruit o2) {
        int weight1 = o1.weight;
        int weight2 = o2.weight;
        return weight2-weight1;
    }
}

interface Eatable{}