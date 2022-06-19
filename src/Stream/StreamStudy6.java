package Stream;
// 그룹화와 분할 - groupingBy(), partitioningBy()
// Collector groupingBy(Function classifier)
// Collector groupingBy(Function classifier, Collector downstream)
// Collector groupingBy(Function classifier, Supplier mapFactory, Collector downstream)

// Collector partitioningBy(Predicate predicate)
// Collector partitioningBy(Predicate predicate, Collector downstream)
// 스트림을 두개로 분할할 때 유리하다

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.*;
import java.util.Collections.*;

import static java.util.stream.Collectors.*;

public class StreamStudy6 {
    public static void main(String[] args) {

        Person[] personList = {
                new Person("이지훈", true, true, 2400, 28),
                new Person("서준일", true, false, 3000, 28),
                new Person("이지호", true, true, 2600, 30),
                new Person("황석사", true, false, 4400, 30),
                new Person("장박사", true, true, 3400, 32),
                new Person("김판사", true, false, 3000, 32),
                new Person("박검사", true, true, 4200, 32),
                new Person("양바보", true, false, 2800, 28),
                new Person("이경훈", true, true, 2800, 26),

                new Person("김지수", false, true, 2000, 20),
                new Person("이혜지", false, false, 2200, 22),
                new Person("김지혜", false, true, 3000, 29),
                new Person("이주현", false, false, 3200, 30),
                new Person("김주영", false, true, 6000, 36),
                new Person("추효정", false, false, 3700, 33),
                new Person("정인하", false, true, 2800, 30),
                new Person("한아름", false, false, 3200, 29),
                new Person("정아름", false, true, 4000, 30),
                new Person("서은아", false, false, 3600, 31)
        };

        Stream<Person> personStream = Stream.of(personList);
        Stream<Person> personStream2 = Stream.of(personList);
        Stream<Person> personStream3 = Stream.of(personList);
        Stream<Person> personStream4 = Stream.of(personList);
        Stream<Person> personStream5 = Stream.of(personList);
        Stream<Person> personStream6 = Stream.of(personList);
        Stream<Person> personStream7 = Stream.of(personList);
        Stream<Person> personStream8 = Stream.of(personList);
        Stream<Person> personStream9 = Stream.of(personList);


        // 1. 기본 분할
        // Boolean으로 나눠서 List<Person>으로 반환함.
        Map<Boolean, List<Person>> perBySex = personStream.collect(partitioningBy(Person::isMale));
        List<Person> personMale = perBySex.get(true);
        List<Person> personFemale = perBySex.get(false);

        //2 . 기본 분할 + 통계
        // Boolean으로 나눠서 Long으로 반환
        Map<Boolean, Long> perBySexCount = personStream2.collect(partitioningBy(Person::isMale, counting()));
        long personMaleCount = perBySexCount.get(true);
        long personFemaleCount = perBySexCount.get(false);
        System.out.println("남자 수 : " + personMaleCount + ", 여자 수 : " + personFemaleCount);
        //2-2. 기본 분할 + 통계
        Map<Boolean, Optional<Person>> perBySalary = personStream3.collect(partitioningBy(Person::isMale, maxBy(Comparator.comparing(Person::getSalary))));
        System.out.println(perBySalary.get(true)); // 남성 최고 연봉(Optional)
        System.out.println(perBySalary.get(false)); // 여성 최고 연봉(Optional)
        //2-3. 결과를 Optional이 아닌 String으로 받고 싶다면?
        Map<Boolean, Object> perBySalary2 = personStream4.collect(partitioningBy(Person::isMale, collectingAndThen(maxBy(Comparator.comparingInt(Person::getSalary)), Optional::get)));
        System.out.println(perBySalary2.get(true));
        System.out.println(perBySalary2.get(false));
        //2-4. 기본 분할 + 기본 분할
        Map<Boolean,Map<Boolean,List<Person>>> perBySalary3 = personStream5.collect(partitioningBy(Person::isMale, partitioningBy((p->p.salary>3000))));
        System.out.println(perBySalary3.get(true).get(true)); // 남성 중 연봉 3000 이상
        System.out.println(perBySalary3.get(false).get(true)); // 여성 중 연봉 3000 이상
        //2-5. 기본 분할 + 기본 분할
        Map<Boolean,Map<Boolean,List<Person>>> perByMariied = personStream6.collect(partitioningBy(Person::isMarried, partitioningBy(Person::isMale)));
        System.out.println(perByMariied.get(true).get(true)); // 기혼인 남성 목록
        System.out.println(perByMariied.get(true).get(false)); // 기혼인 여성 목록

        //3. groupingBy()를 통한 분류
        // 3-1. 등급별 집꼐
        Map<Object,List<Person>> perBySalary4 = personStream7.collect(groupingBy(
                (s) -> {
                    if (s.salary > 4000) {
                        return Person.Level.HIGH;
                    } else if (s.salary > 3000) {
                        return Person.Level.MIDDLE;
                    } else {
                        return Person.Level.LOW;
                    }
                }, toList()));
        System.out.println(perBySalary4);
        // 3-2. 다수준 그흡화
        Map<Integer, Map<Boolean, List<Person>>> pergroup1 = personStream8.collect(groupingBy(Person::getAge,groupingBy(Person::isMarried)));
        System.out.println(pergroup1); // 연령별 미혼 및 기혼 분류
        // 3-3. 연령별 최고 연봉
        Map<Integer, Object> pergroup2 = personStream9.collect(groupingBy(Person::getAge, collectingAndThen(maxBy(Comparator.comparingInt(Person::getSalary)), Optional::get )));
        System.out.println(pergroup2);

    }
}


class Person implements Comparable<Person> {
    String name;
    boolean isMarried;
    boolean isMale;
    int salary;
    int age;

    Person(String name, boolean isMale, boolean isMarried, int salary, int age) {
        this.name = name;
        this.isMale = isMale;
        this.isMarried = isMarried;
        this.salary = salary;
        this.age = age;
    }

    String getName() { return this.name; }
    boolean isMarried() { return this.isMarried; }
    int getSalary() { return this.salary; }
    int getAge() { return this.age; }
    boolean isMale() { return this.isMale; }

    public String toString() {
        return String.format("[ %s, %s, %d, %d, %s ]", name, isMale? "남":"여", age, salary, isMarried ? "기혼":"미혼");
    }

    @Override
    public int compareTo(Person p) {
        return p.salary - this.salary;
    }

    enum Level { HIGH, MIDDLE, LOW }
}