package standardOfJava.Enums;

import static standardOfJava.Enums.Direction.EAST;

public class EnumsStudy {
    public static void main(String[] args) {
        Direction d1 = EAST;
        Direction d2 = Direction.valueOf("WEST");
        // valueOf로 문자열 상수에 대한 참조를 얻을 수 있다.
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);

        System.out.println("d1 == d2 ? " + (d1==d2));
        System.out.println("d1 == d3 ? " + (d1==d3));
        // 동등 연산자로 비교 가능하다.
        System.out.println("d1.equals(d3) ? " + d1.equals(d3));
        // 물론 equlas로도 가능하다.
        System.out.println("d1.compareTo(d2) ? " + d1.compareTo(d2));
        System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3));
        // 부등호로 비교는 불가하나 compareTo로 가능하다.

        switch(d1) {
            case EAST: // Direction.EAST라고 적을 수 없다. 무 조 건 상수명만 표기 가능하다.
                 System.out.println("The direction is East.");
                 break;
            case NORTH:
                System.out.println("The direction is North.");
                break;
            case WEST:
                System.out.println("The direction is WEST.");
                break;
            case SOUTH:
                System.out.println("The direction is SOUTH.");
                break;
        }

        Direction[] dirArr = Direction.values();
        // values() 메서드는 열거형의 모든 상수를 배열에 담아 반환해준다.

        for ( Direction dir : dirArr ) {
            System.out.println(dir + "(" + dir.ordinal() + ")");
        }
        //ordinal() 메서드는 열거형에서 해당 상수가 몇 번째인지 반환한다.
        //단 이것은 오직 내부적으로 사용되는 것일 뿐 값으로 사용해서는 안된다. (인덱스 넘버를 키값으로 주면 안되는 것고 같다.)

        System.out.println("d1.rotate(3) ? " + d1.rotate(3));
        System.out.println("d1.rotate(2) ? " + d1.rotate(1));
        System.out.println("d1.rotate(1) ? " + d1.rotate(-1));
        System.out.println("d1.rotate(0) ? " + d1.rotate(1));

        System.out.println("d1.getValue() = " + d1.getValue() + ", d1.getSymbole() = " + d1.getSymbole());
        System.out.println("Direction.of(3) ? " + Direction.of(3));
    }
}

enum Direction {
    EAST(1, "⬅️"), SOUTH(2,"⬇️"), NORTH(3,"⬆️"), WEST(4,"➡️"); // 문자만 열거할때와 달리 값을 추가하면 세미콜론이 필요하다

    private static final Direction[] DIR_ARR = Direction.values();
    private final int value;
    private final String symbole;
    // 값을 여러가지 주는 것도 가능하다.
    Direction(int value, String symbole) {
        this.value = value;
        this.symbole = symbole;
    } // 생성자로 값 지정

    public int getValue() { return this.value; }
    public String getSymbole() { return this.symbole; }

    public static Direction of(int num) {
        if ( num > 4 || num < 1 ) {
            throw new IllegalArgumentException("1부터 4까지의 수를 입력해주세요.");
        }
        return DIR_ARR[num-1];
    }

    public Direction rotate(int num) {
        if ( num > 4 || num < -4 || num == 0  ) {
            throw new IllegalArgumentException("0을 제외한 -4부터 4까지의 수를 입력해주세요.");
        }
        num = num%4;
        if ( num < 0 ) { num += 4; }
        return DIR_ARR[(num-1)%4];
    }
}