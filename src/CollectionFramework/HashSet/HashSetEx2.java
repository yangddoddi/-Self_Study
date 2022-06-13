package CollectionFramework.HashSet;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx2 {
    public static void main ( String[] args ) {
        Person person1 = new Person("김무명",22);
        Person person2 = new Person("김무명",22);

        HashSet<Person> hashSet = new HashSet<>(10);
        hashSet.add(person1);
        hashSet.add(person2);

        System.out.println(hashSet);
    }
}

class Person {
    String name;
    int age;

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person () {
        this.name = "noname";
        this.age = Integer.MAX_VALUE;
    }

    public String toString() {
        return this.name + ", " + this.age;
    }

    public boolean equals(Object obj) {
        if ( obj instanceof Person ) {
            return this.name.equals(((Person) obj).name) && this.age == ((Person) obj).age;
        }
        return false;
    }

    public int hashCode() {
//        return (this.name+this.age).hashCode();
        return Objects.hash(this.name+this.age);
        // 신문법을 씁시다 ^~^
    }
    // HashSet에서 중복 체크시 equals와 hashCode를 호출하기 때문에
    // 커스텀 클래스에서 사용 시 같은 값으로 인식하게 만들고 싶다면
    // 각 메서드를 오버라이딩해야 한다.
}