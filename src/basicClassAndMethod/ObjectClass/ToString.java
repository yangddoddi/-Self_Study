package basicClassAndMethod.ObjectClass;

// toString 메서드의 기본형태는 다음과 같다
// public String toString() {  return getClass().getName()+"@"+Integer.toHexString(hashCode()); };
// 따라서 객체가 가지고 있는 값을 반환받고 싶다면 오버라이딩해야 한다.

// String 클래스의 경우 기본적으로 문자열을 리턴하도록 되어 있으며
// Date 클래스는 날짜를 반환하는 등 기본 클래스들도 toString을 오버라이딩해서 사용하는 형태이다.

class Student {
    String name;
    int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return  "name : " + this.name + ", age : " + this.age; }
}

public class ToString {
    public static void main (String[] args) {
        Student kim = new Student("킴", 17);
        System.out.println(kim);
    }
}
