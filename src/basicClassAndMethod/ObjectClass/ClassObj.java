package basicClassAndMethod.ObjectClass;

import java.util.Arrays;

class Animal3 {
    String name;
    boolean carnivorous;
    boolean fly;

    Animal3(String name, boolean carnivorous, boolean fly) {
        this.name = name;
        this.carnivorous = carnivorous;
        this.fly = fly;
    }

    void fly() {
        if (fly) { System.out.println(name+"은 날았다!"); }
        if (!fly) { System.out.println(name+"은 날 수 없다!"); }
    }

    void hunt() {
        if (carnivorous) { System.out.println(name+"은 사냥 중입니다!"); }
        if (!carnivorous) { System.out.println(name+"은 잡초를 사냥 중입니다!"); }
    }
}

public class ClassObj {
    public static void main(String[] args) {
        Animal3 cheetah = new Animal3("치타",true,false);

        Class<? extends Animal3> obj = cheetah.getClass();
        System.out.println(obj.getName());
        System.out.println(Arrays.toString(obj.getDeclaredMethods()));
        System.out.println(Arrays.toString(obj.getDeclaredFields()));
        System.out.println(obj.getSuperclass());
    }
}
