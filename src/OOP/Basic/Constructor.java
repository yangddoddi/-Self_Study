package OOP.Basic;

class Dog {
    String name;
    int age;
    Dog (String name, int age) {
        this.name = name;
        this.age = age;
        // this.name은 인스턴스 변수, 대입되는 name은 매개변수로 전달된 변수
    }
}

class Cat {
    String name;
    int age;
    String species;
    {
        System.out.println("나는 인스턴스 초기화 블럭이다!");
        species = "korean show hair";
    } // 인스턴스 초기화 블럭
    // 클래스가 생성될 때 한 번 수행된다.
    // 생성자에 공통된 내용이 있을 때 주로 사용한다.
    Cat () {
        this("돌돌이", 12);
    } // 매개변수가 없을 시 기본값
    Cat (String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Mongoose {
    String name;
    int age;
    Mongoose(String name, int age) {
        this.name = name;
        this.age = age;
    }
    Mongoose(Mongoose obj) {
        this(obj.name, obj.age);
    } // 같은 값을 가진 인스턴스 생성용
}

public class Constructor {
    static { System.out.println("나는 클래스 초기화 블럭이다!"); }

    public static void main(String[] args) {
        Dog mongmong = new Dog("돌돌이", 9);
        Cat meow = new Cat();
        Cat meowmeow = new Cat("야옹이", 3);
        // 인스턴스를 생성할 때 "나는 인스턴스 초기화 블럭이다!" 가 실행됨.
        Mongoose animal1 = new Mongoose("바보", 12);
        Mongoose animal2 = animal1;

        System.out.println("멍멍이 이름 : " + mongmong.name + ", 멍멍이 나이 : " + mongmong.age );
        System.out.println("고양이 이름 : " + meow.name + ", 고양이 나이 : " + meow.age + ", 품종 : "+ meow.species  );
        System.out.println("고양이 이름 : " + meowmeow.name + ", 고양이 나이 : " + meowmeow.age + ", 품종 : "+ meowmeow.species  );
        System.out.println("몽구스 이름 : " + animal1.name + ", 몽구스 나이 : " + animal1.age );
        System.out.println("복제 몽구스 이름 : " + animal2.name + ", 복제 멍멍이 나이 : " + animal2.age );
    }
}
