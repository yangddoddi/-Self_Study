public class calculator {

    public static void main(String[] args) {

        double valueOfSupply = 10000.0;
        double vat = valueOfSupply * 0.1;
        double retailPrice = valueOfSupply+vat;
        double costRate = valueOfSupply * 0.3;
        double income = valueOfSupply - costRate;
        double dividend1 = income * 0.5;
        double dividend2 = income * 0.3;
        double dividend3 = income * 0.2;

    }
}
