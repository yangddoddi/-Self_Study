package standardOfJava.Basic;

import java.util.ArrayList;
import java.util.Arrays;

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

    ArrayList<Product> shoppingList = new ArrayList<Product>(10);
//  ArrayList의 메서드는 add(), remove(), isEmpty(), get(), size(), clear() 등이 있다.

    void buy(Product product) {
        if ( this.money + this.point < product.price ) {
            System.out.println("buy() : " + "금액이 부족합니다.");
        } else if ( this.money < product.price && this.money + this.point >= product.price ) {
            this.money = this.money - product.price + this.point;
            this.point = product.point;
            shoppingList.add(product);
            System.out.println("buy() : " + product + "를 구매했습니다. 남은 소지금은 " + this.money + "이며, 적립된 포인트는 " + product.point + "입니다. 총 적립 포인트는 " + this.point + "입니다.");
        } else {
            this.money = this.money - product.price;
            this.point += product.point;
            shoppingList.add(product);
            System.out.println("buy() : " + product + "를 구매했습니다. 남은 소지금은 " + this.money + "이며, 적립된 포인트는 " + product.point + "입니다. 총 적립 포인트는 " + this.point + "입니다.");
        }
    }

    void refund(Product product) {
        if(shoppingList.contains(product)) {
            shoppingList.remove(product);
            System.out.println("refund() : " + product + " 환불 완료!");
            this.money += product.price;
            this.point -= product.point;
        } else {
            System.out.println("refund() : 해당 물건을 구입하지 않았습니다!");
        }
    }

    void check() {
        System.out.println("check() : 현재 소지금은 " + this.money + "입니다. 적립 포인트는 " + this.point + "입니다.");
        int total = 0;
        String itemList = Arrays.toString(shoppingList.toArray());
        for( Product product : shoppingList) {
            total += product.price;
        }
        System.out.println("check() : 구매한 상품의 총 금액은 " + total + "이며, 구매한 상품의 총 개수는 " + shoppingList.size() + "입니다.");
        System.out.println("check() : 지금까지 구매한 상품 목록은 " + itemList + "입니다.");
    }
}


public class PolymorphismForMethod {
    public static void main(String[] args) {
        Product TV = new TV();
        Product Computer = new Computer();
        Product Macbook = new Macbook();

        Person person = new Person(5000000);

        person.buy(Macbook);
        person.buy(TV);
        System.out.println("==========================");
        person.check();
        System.out.println("==========================");
        person.refund(Macbook);
        person.refund(Computer);
        System.out.println("==========================");
        person.check();
    }
}
