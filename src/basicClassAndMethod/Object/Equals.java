package basicClassAndMethod.Object;

// equals 메서드는 this == obj로 boolean을 반환한다.
// 즉 참조값을 기준으로 반환하기 때문에 값으로 반환하고 싶다면 Override하면 된다.
class myNum {
    int num;
    myNum(int num){ this.num = num; }

    public boolean equals (Object obj) {
        if ( obj instanceof myNum ) {
            return this.num == ((myNum) obj).num;
        } else { return false; }
    }
}

class Num {
    int num;
    Num(int num){ this.num = num; }
}

public class Equals {
    public static void main(String[] args) {
        Num num1 = new Num(10);
        Num num2 = new Num(10);

        myNum myNum1 = new myNum(10);
        myNum myNum2 = new myNum(10);

        System.out.println(num1.equals(num2));
        System.out.println(myNum1.equals(myNum2));
    }
}
