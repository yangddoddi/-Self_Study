import javax.swing.*;

public class Calculator {
    public static double valueOfSupply;
    public static double vatRate = 0.1;
    public static double expenseRate = 0.3;

    public static void main(String[] args) {
        valueOfSupply = Double.parseDouble(JOptionPane.showInputDialog("공급가를 입력하세요"));
        Fomula.formula.printResults();
    }
}

