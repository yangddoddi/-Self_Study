package standardOfJava.Array;

import java.util.Scanner;

// 단어 시험
public class VocabularyTest {
    public static void main(String[] args) {
        String[][] words = {
                {"apple", "사과"},
                {"banana", "바나나"},
                {"strawberry", "딸기"}
        };

        for(int i=0; i< words.length; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.printf("Q%d. %s의 뜻은 무엇인가요?%n", i+1, words[i][0]);
            String input = scanner.nextLine();
            if ( input.equals(words[i][1]) ) {
                System.out.println("훌륭합니다!");
            } else { System.out.println("더 공부하고 돌아오세요.");
            break;}

            if ( i == words.length-1 ) {
                System.out.println("시험 통과!");
            }
        }
    }
}
