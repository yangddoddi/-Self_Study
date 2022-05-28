package whileStudy;

public class doWhile2 {
    public static void main(String [] args) {
        int num = 0;
        for (int i=0; i<=100; i++) {
            System.out.printf("i=%d", i);
            num = i;

            do {
                if ( num%10 != 0 && num%10%3 == 0 ) {
                    System.out.print("짝");
                }
            } while ( (num=num/10) != 0);
            System.out.println("");
        }
    }
}
