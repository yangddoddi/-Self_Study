package basicClassAndMethod;

class CloneClass implements Cloneable {
    int num;
    CloneClass(int num) {
        this.num = num;
    }

    @Override
    public CloneClass clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("실패");
        }
        return (CloneClass)obj;
    }
}

public class Clone {
    public static void main(String[] args) {
        CloneClass clone1 = new CloneClass(10);
        CloneClass clone2 = clone1.clone();

        System.out.println(clone1);
        System.out.println(clone2);

        System.out.println(System.identityHashCode(clone1));
        System.out.println(System.identityHashCode(clone2));

        clone1.num = 5;

        System.out.println(clone1.num);
        System.out.println(clone2.num);
    }
}
