package standardOfJava.basicClassAndMethod.ObjectClass;

class Animal {
    int size;
    Animal (int size) {
        this.size=size;
    }
    public String toString() {
        return "size : " + this.size;
    }
}

class Lion implements Cloneable {
    Animal size;
    Lion(Animal size) {
        this.size = size;
    }

    public Lion swallowCopy() {
        Object obj = null;
        try { obj = super.clone(); }
        catch(CloneNotSupportedException e) {}
        return (Lion)obj;
    }

    // 참조 객체를 새로 생성해야 깊은 복사
    public Lion deepCopy() {
        Object obj = null;
        try { obj = super.clone(); }
        catch(CloneNotSupportedException e) {}
        Lion cloneObj = (Lion)obj;
        cloneObj.size = new Animal(this.size.size);
        return cloneObj;
    }
}

public class Clone2 {
    public static void main(String[] args) {
        Lion lion = new Lion(new Animal(100));
        Lion lion2 = lion.swallowCopy();
        Lion lion3 = lion.deepCopy();

        System.out.println(lion.size);
        System.out.println(lion2.size);
        System.out.println(lion3.size);

        lion.size.size = 20;
        lion2.size.size = 30;
        lion3.size.size = 40;

        System.out.println(lion.size);
        System.out.println(lion2.size);
        System.out.println(lion3.size);
    }
}
