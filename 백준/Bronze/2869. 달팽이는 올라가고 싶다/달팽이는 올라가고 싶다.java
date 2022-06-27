import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long up = scanner.nextInt();
        long down = scanner.nextInt();
        long tree = scanner.nextInt();
        long day = 0;

        if ( (tree-down) % (up-down) == 0 ) {
            day = (tree - down) / (up - down);
        } else { day = (tree - down) / (up - down) + 1 ; }
        System.out.println(day);
    }
}