package OOP.Basic;
// 자바는 단일 상속만 가능하나 상속과 포함 관계를 적절히 이용하면 한계를 어느 정도 극복 가능하다.

class Bird {
    String species;
    static {
        System.out.println("I love worm!");
    }
    Bird(String species) {
        this.species = species;
    }
    void fly() {};
    String peak(String name) {
        return name + "을 쪼았다!";
    };
}

class Puppy {
    String species;
    static {
        System.out.println("I love master!");
    }
    Puppy(String species) {
        this.species = species;
    }
    Puppy() {
        this("시고르자브종");
    }
    void run() {};
    String bite(String name) {
        return name +"을 물었다!";
    }
}

class PuppyBird extends Puppy {
    PuppyBird(String species) {
        this.species = species;
    }
    Bird bird = new Bird("참새");
    String peak(String name) {
        return bird.peak(name);
    }
    void fly() {
        bird.fly();
    }
}

public class SingleInheritance {
    public static void main(String[] args) {
        PuppyBird puppyBird = new PuppyBird("개새");
        String result = puppyBird.bite("사람");
        System.out.println(result);
        String result2 = puppyBird.peak("사람");
        System.out.println(result2);
    }
}
