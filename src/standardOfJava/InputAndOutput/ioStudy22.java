package standardOfJava.InputAndOutput;

// 직렬화(Serialization)
// 데이터를 스트림으로 만드는 것(직렬화) 스트림을 데이터로 만드는 것(역직렬화:deserialization)
// 객체 = 인스턴스 변수의 집합 (메서드는 공통된 정보이기 때문에 인스턴스마다 따로 저장되지 않는다.)
// ObjectInputStream(역직렬화->스트림을 객체로) ObjectOutputStream(직렬화->객체를 스트림으로)

import java.io.*;

public class ioStudy22 {
    public static void main (String[] args) {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        Child child = new Child(true,"민구",4,new Object(),new Object(),new Object());

        try {
            FileOutputStream fos = new FileOutputStream("objectFile.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(child);
            System.out.println("완료");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("objectFile.ser");
            ois = new ObjectInputStream(fis);
            Child child2 = (Child)ois.readObject();
            System.out.println(child2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Person {
    String name;
    Object obj= new Object();

    Person(String name, Object obj) {
        this.name = name;
        this.obj = obj;
    }

    Person() {
        this.name = "noname";
        this.obj = new Object();
    }
}
// 부모가 Serializable을 구현하지 않았다면 부모의 인스턴스는 직렬화되지 않는다.
class Parent extends Person implements Serializable {
    int age;
    transient Object obj2 = new Object();
// Object는 직렬화되지 않는다.
    Parent(String name, int age, Object obj, Object obj2) {
        super(name, obj);
        this.age = age;
        this.obj2 = obj2;
    }
}
// 부모가 Serializable을 구현하고 있으면 자손도 직렬화 가능.
class Child extends Parent {
    boolean isMale;
    transient Object obj3;

    Child(boolean isMale, String name, int age, Object obj, Object obj2, Object obj3) {
        super(name, age, obj, obj2);
        this.obj3 = obj3;
        this.isMale = isMale;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeInt(age);
        out.writeBoolean(isMale);
        out.defaultWriteObject();
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        age = in.readInt();
        isMale = in.readBoolean();
        in.defaultReadObject();
    }

    public String toString() {
        return this.name + " " + this.age + " " + this.isMale + " " + this.obj3;
    }
}