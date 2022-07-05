package standardOfJava.Basic;

class Card {
    static final int KIND_MAX = 4; // 카드 종류
    static final int NUM_MAX = 13; // 종류당 개수

    static final int SPADE = 4; // 각 카드의 인덱스 넘버
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;

    int kind;
    int number;

    Card() {
        this(SPADE,1);
    } // 기본값

    Card(int kind, int number){
        this.kind = kind;
        this.number = number;
    }

    public String toString() { // 참조 변수가 object일 경우 toString()이 작동한다.
        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers = "123456789XJQK";

        return "kind : " + kinds[this.kind] + ", number : " + numbers.charAt(this.number);
    }
}

class Deck {
    final int CARD_NUM = 52;
    Card[] cardArr = new Card[CARD_NUM]; // 카드 개수만큼 생성;

    Deck () {
        int i=0;
        for (int j=Card.KIND_MAX; j > 0; j--) {
            for (int k=0; k < Card.NUM_MAX; k++) {
                cardArr[i++] = new Card(j, k);
            }
        }
    }

    Card pick(int index) {
        return cardArr[index]; // 해당 인덱스에 해당하는 카드 뽑기
    }

    Card pick() { // 무작위 카드 한 장 뽑기
        int index = (int)(Math.random() * CARD_NUM);
        return pick(index);
    }

    void shuffle() { // 카드 뒤섞기
        for ( int i = 0; i<CARD_NUM; i++ ) {
            Card temp;
            int randomCard = (int)(Math.random()*CARD_NUM);
            temp = cardArr[i];
            cardArr[i] = cardArr[randomCard];
            cardArr[randomCard] = cardArr[i];
        }
    }
}

public class Composite {
    public static void main(String[] args) {
        Deck deck = new Deck(); // 기본 덱 생성
        deck.shuffle(); // 덱 뒤섞기
        
        Card[] myCard = new Card[10];
        for ( int i=0; i<myCard.length; i++ ) {
            myCard[i] = deck.pick(i);
            System.out.println(myCard[i]);
        }
    }
}
