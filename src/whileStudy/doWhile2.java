package whileStudy;

// 각 자리의 수가 3의 배수를 가지고 있다면 짝
// ex > 13 짝 33 짝짝
public class doWhile2 {
    public static void main(String [] args) {
        int num = 0;
        for (int i=0; i<=100; i++) {
            System.out.printf("i=%d", i);
            num = i;

            do {
                if ( num%10 != 0 && num%10%3 == 0 ) { //
                    System.out.print("짝");
                }
            } while ( (num=num/10) != 0);
            System.out.println("");
        }
    }
}
