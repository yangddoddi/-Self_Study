package standardOfJava.RecursiveCall;

public class Factorial {
    static long calculate(long num) {
        if (num == 0) return 0;
        if (num == 1) return 1;
        return num = num * calculate(--num);
    }

    public static void main(String[] args) {
        long result = calculate(5);
        System.out.println(result);

        for (int i=0; i<21; i++) {
            long result2 = calculate(i);
            System.out.println(i + "! = " + result2);
        }
    }
}
