package OOP.Basic;

class Calculator {
    static int add(int a, int b) { return a + b; }
    static long add(long a, long b) { return a + b; }
    static long add(long a, int b) { return a + b; }
    static long add(int a, long b) { return a + b; }
    static int add(int[] a) {
        int sum = 0;
        for (int num : a) {
            sum += num;
        }
        return sum;
    }
}

public class OverLoading {
    static int[] numArr = {1,2,3,4,5,6};
    public static void main(String[] args) {
        System.out.println(Calculator.add(5, 5));
        System.out.println(Calculator.add(5L, 5));
        System.out.println(Calculator.add(5, 5L));
        System.out.println(Calculator.add(5L, 5L));
        System.out.println(Calculator.add(numArr));
    }
}