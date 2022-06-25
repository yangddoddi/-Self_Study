import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int roomNum = scan.nextInt();
        int count = 0;
        if (roomNum == 1) { System.out.println(1); }
        if (roomNum != 1) {
        while ( calculator(count) < roomNum ) {
            count++;
        }
        System.out.println(count); }
    }

    public static long calculator(int roomNum) {
        long num = (long)Math.pow(roomNum,2);
        return (3 * num) - (3L *roomNum) +1;
    }
}