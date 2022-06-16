package Enums;

public class EnumsStudy2 {
    public static void main(String[] args) {
        System.out.println("기본 요금 ? " + Transportation.BUS.BASIC_FARE);
        System.out.println("10km 추가일 경우 ? " + Transportation.BUS.fare(10));
    }
}

//enum Transportation {
//    BUS(100), TRAIN(150), SHIP(200), AIRPLANE(400);
//
//    private final int BASIC_FARE;
//
//    Transportation(int basicFare) {
//        this.BASIC_FARE = basicFare;
//    }
//}
// 위 열거형에 추상 메서드 추가하기

enum Transportation {
    BUS(100) { int fare(int distance) { return BASIC_FARE + distance * 10; }},
    TRAIN(150) { int fare(int distance) { return BASIC_FARE + distance * 20; }}
    , SHIP(200) { int fare(int distance) { return BASIC_FARE + distance * 30; }}
    , AIRPLANE(400) { int fare(int distance) { return BASIC_FARE + distance * 40; }};

    protected final int BASIC_FARE;

    Transportation(int basicFare) {
        this.BASIC_FARE = basicFare;
    }

    abstract int fare(int distance);
    // 위와 같이 추상 메서드를 정의해놓으면 각 열거형 상수가 이것을 구현해야 한다.
}