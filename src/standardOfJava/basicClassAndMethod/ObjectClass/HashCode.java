package standardOfJava.basicClassAndMethod.ObjectClass;

// 32bit JVM에서 hashCode 메서드는 같은 값을 가질 수 없으나 64비트에서는 가능하다.
// 같은 객체의 같은 값을 비교하는 경우에는 hashCode도 equals와 같이 오버라이딩해야 한다.

public class HashCode {
    public static void main(String[] args) {
        String str1 = new String("저는 문자입니다.");
        String str2 = new String("저는 문자입니다.");

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        // String의 경우 값이 같으면 다른 객체여도 같은 해시 값을 가진다.
        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
        // 객체가 다르면 다른 해시값을 보장
    }
}
