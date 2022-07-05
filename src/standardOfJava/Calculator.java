package standardOfJava;

// 순수익 계산
public class Calculator {
    public static double vatRate = 0.1;
    public static double expenseRate = 0.3;

    public static void main(String[] args) {
        Accounting storeA = new Accounting(10000);
        storeA.printResults();

        Accounting storeB = new Accounting(75000);
        storeB.printResults();
    }
}

