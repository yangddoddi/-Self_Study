package standardOfJava.basicClassAndMethod.RandomClass;

import java.util.Random;

public class RandomClass1 {
    public static void main(String[] args){
        Random randomNum = new Random(1);
        Random randomNum2 = new Random(1);

        for ( int i = 0; i < 5; i++ ) {
            System.out.println("randomNum = " + randomNum.nextInt());
        }
        System.out.println("=====================");

        for ( int j = 0; j < 5; j++ ) {
            System.out.println("randomNum2 = " + randomNum2.nextInt());
        }
    }
    // 종자 값이 같다면 항상 같은 값을 반환한다.
}
