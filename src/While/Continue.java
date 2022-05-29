package While;

public class Continue {
    public static void main (String[] args) {

        for ( int i=0; i<100; i++ ) {
            if ( i%3 == 0 ) {
                continue; // 컨티뉴를 만나면 그 이후 코드를 실행하지 않음
            }
            System.out.println(i);
        }
    }
}
