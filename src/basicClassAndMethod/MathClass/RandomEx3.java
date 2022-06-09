package basicClassAndMethod.MathClass;

// 랜덤 데이터 베이스 생성 예제
public class RandomEx3 {
    final static int RECORD_NUM = 10;
    final static String TABLE_NAME = "TEST_TABLE";
    final static String[] CODE1 = {"010","011","017","018","019"};
    final static String[] CODE2 = {"male","female"};
    final static String[] CODE3 = {"10대","20대","30대","40대","50대"};

    public static void main(String[] args) {
        for ( int i=0; i<RECORD_NUM; i++ ) {
            System.out.println(TABLE_NAME + " : " + " ( " + getRandomCode(CODE1) + ", " + getRandomCode(CODE2) + ", " + getRandomCode(CODE3) + ", " + getRandomNum(100, 200) + " ) ");
        }
    }

    // 매개변수로 들어온 배열의 랜덤 인덱스 값 반환
    public static String getRandomCode(String[] codeArr) {
        return codeArr[getRandomNum(0, codeArr.length-1)];
    }

    // from~to 사이의 정수를 랜덤하게 반환
    public static int getRandomNum(int from, int to) {
        return (int)(Math.random() * Math.abs(to-from+1) + Math.min(from, to));
    }
}
