package Generics;


import java.util.ArrayList;

public class GenericsBasic2 {
    public static void main(String[] args) {
        // 1. 제네릭 타입 <-> 로우 타입 형변환?
        Zoo zoo = null;
        Zoo<Animal> typeZoo = null;

        zoo = (Zoo)typeZoo; // 제네릭 타입 -> 원시 타입 ? 가능
        typeZoo = (Zoo<Animal>)zoo; // 원시 타입 -> 제네릭 타입? 가능


        // 2. 제네릭 타입 <-> 제네릭 타입 형변환?
        Zoo<Animal> animalZoo = new Zoo<>();
        Zoo<Lion> lionZoo = new Zoo<>();

//        animalZoo = (Zoo<Animal>) lionZoo; // 에러
//        lionZoo = (Zoo<Lion>) animalZoo; // 에러

        // 3. 와일드 카드 사용 시 형변환?
        Zoo<? super Lion> superLion = new Zoo<>();
        superLion = animalZoo; // 위에서 선언한 Zoo<Animal> animalZoo는 ? super Lion에 포함되므로 가능

        Zoo<Rabbit> rabbitZoo = new Zoo<>();
//        superLion = rabbitZoo;  에러. Rabbit은 Lion의 부모가 아니다.

        // 5. 형변환이 되긴 하는데..
        Zoo<? extends Animal> zoo1 = new Zoo<>();
        Zoo<? extends Lion> zoo2 = new Zoo<>();
        zoo1 = (Zoo<? extends Animal>) zoo2;
        zoo2 = (Zoo<? extends Lion>) zoo1; // 이런 경우에 가능은 하다.


    }
}
// 4. 예제
final class Optional<T> {
    private static final Optional<?> EMPTY = new Optional<>(); // ?는 ? extends Object와 같다.
    // 왜 굳이 Object가 아닌 ?를 채택하고 있을까?
    private final T value;
    Optional() {
        value = null;
    }
    public static <T> Optional<T> empty() {
        Optional<T> t = (Optional<T>)EMPTY;
        // empty 메서드에서 Optional<T>로 형변환을 해줘야 하는데
        // 타입을 Object로 명시하면 형변환이 불가능하기 때문이다.
        return t;
    }
}



class Zoo<T extends Animal> {
    ArrayList<T> animalList = new ArrayList<>();
    void add(T animal) { animalList.add(animal); }
    ArrayList<T> getList() { return animalList; }
}

class Animal {
    String name;
    int weight;

    public Animal(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    Animal() {
        this("미등록",0);
    }
}

class Carnivore extends Animal {
    Carnivore(String name, int weight) {
        super(name,weight);
    }
}
class Herbivore extends Animal {
    Herbivore(String name, int weight) {
        super(name,weight);
    }
}

class Lion extends Carnivore implements unTouchable {
    Lion(int weight) {
        super("사자",weight);
    }
}

class Rabbit extends Herbivore implements touchable {
    Rabbit(int weight) {
        super("토끼",weight);
    }
    public void touch() {}
}

interface touchable {
    public void touch();
}
interface unTouchable {
}