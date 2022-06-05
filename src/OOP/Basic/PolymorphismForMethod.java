package OOP.Basic;

// 다형성을 활용하여 메서드를 일일히 하드코딩하지 않고 Product 타입을 적용함으로써 보다 간결하게 구현할 수 있다.
class Product {
    final int price;
    final int point;

    Product(int price) {
        this.price = price;
        this.point = this.price/10;
    }
}

class TV extends Product {
    TV() {
        super(400000);
    }
    public String toString() {
        return "TV";
    }
}

class Computer extends Product {
    Computer() {
        super(700000);
    }
    public String toString() {
        return "Computer";
    }
}

class Macbook extends Product {
    Macbook() {
        super(2000000);
    }
    public String toString() {
        return "Macbook";
    }
}

class Person {
    int money;
    int point;
    Person(int money) {
        this.money = money;
    }

    void buy(Product product) {
        if ( this.money + this.point < product.price ) {
            System.out.println("금액이 부족합니다.");
        } else if ( this.money < product.price && this.money + this.point >= product.price ) {
            this.money = this.money - product.price + this.point;
            this.point = product.point;
            System.out.println(product + "를 구매했습니다. 남은 소지금은 " + this.money + "이며, 적립된 포인트는 " + product.point + "입니다. 총 적립 포인트는 " + this.point + "입니다.");
        } else {
            this.money = this.money - product.price;
            this.point += product.point;
            System.out.println(product + "를 구매했습니다. 남은 소지금은 " + this.money + "이며, 적립된 포인트는 " + product.point + "입니다. 총 적립 포인트는 " + this.point + "입니다.");
        }
    }

    void check() {
        System.out.println("현재 소지금은 " + this.money + "입니다. 적립 포인트는 " + this.point + "입니다.");
    }
}


public class PolymorphismForMethod {
    public static void main(String[] args) {
        Product TV = new TV();
        Product Computer = new TV();
        Product Macbook = new Macbook();

        Person person = new Person(2000000);

        person.buy(Macbook);
        person.check();

        person.buy(TV);
    }
}
