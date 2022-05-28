import javax.swing.*;

public class calculator {
    public static double valueOfSupply;
    public static double vatRate = 0.1;
    public static double expenseRate = 0.3;
    public static double getVat() {
        return valueOfSupply * vatRate;
    }
    public static double retailPrice() {
        return valueOfSupply+getVat();
    }
    public static double costRate() {
        return valueOfSupply * expenseRate;
    }
    public static double income() {
        return valueOfSupply - costRate();
    }
    public static double dividend(double magnification) {
        return income() * magnification;
    }

    public static void printResults() {
        System.out.println("공급가 : " + valueOfSupply);
        System.out.println("부가세 : " + getVat());
        System.out.println("소비자가 : " + retailPrice());
        System.out.println("원가 : " + costRate());
        System.out.println("순익 : " + income());
        System.out.println("배당1 : " + dividend(0.5));
        System.out.println("배당2 : " + dividend(0.3));
        System.out.println("배당3 : " + dividend(0.2));
    }

    public static void main(String[] args) {
        valueOfSupply = Double.parseDouble(JOptionPane.showInputDialog("공급가를 입력하세요"));
        printResults();
    }
}
