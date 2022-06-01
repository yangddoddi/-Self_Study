package OOP.Basic;

class PokerCard {
    static int width = 100;
    static int height = 250;
    // 클래스 변수, 모든 인스턴스가 같은 변수를 참조.
    // 인스턴스 없이 호출 가능.

    String kind;
    int number;
    // 인스턴스 변수, 각각의 인스턴스가 다른 변수를 참조.
}

public class staticAndInstance {
    public static void main(String[] args) {
        System.out.println("카드들의 가로 길이는 "+PokerCard.width+"이고 세로 길이는 "+PokerCard.height+"입니다.");

        PokerCard spadeSeven = new PokerCard();
        PokerCard heartOne = new PokerCard();

        spadeSeven.kind = "spade";
        spadeSeven.number = 7;

        heartOne.kind = "heart";
        heartOne.number = 1;

        System.out.println("이 카드는 "+spadeSeven.kind+spadeSeven.number+"입니다.");
        System.out.println("이 카드는 "+heartOne.kind+heartOne.number+"입니다.");
        System.out.println(spadeSeven.width); // 가능하지만 PokerCard.width로 사용하자.
    }
}
