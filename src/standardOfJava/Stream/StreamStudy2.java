package standardOfJava.Stream;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

// stream sorted() 활용 예제
public class StreamStudy2 {
    public static void main(String[] args) {

    List<Student> list = Arrays.asList(
            new Student("양만식", 3, 95),
            new Student("김바보", 1, 75),
            new Student("장뚝딱", 2, 87),
            new Student("이영재", 3, 45),
            new Student("마동석", 2, 100),
            new Student("오이남", 3, 72),
            new Student("남이오", 1, 95)
    );

    Stream<Student> studentStream = list.stream();
    studentStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Student::getScore).thenComparing(Student::getName)).forEach(System.out::println);
    } // 반별 정렬 -> 이름별 정렬 -> 점수별 정렬
}

class Student implements Comparable<Student> {
    int ban;
    int score;
    String name;

    Student(String name, int ban, int score) {
        this.name = name;
        this.ban = ban;
        this.score = score;
    }

    public int getBan() {
        return this.ban;
    }
    public int getScore() {
        return this.score;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student s) {
        return (this.name).compareTo(s.name);
    }

    public String toString() {
        return this.name + ", " + this.ban + "반, " + this.score + "점";
    }
}