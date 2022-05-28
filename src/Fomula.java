public class Fomula {
    static class formula {
        public static double getVat() {
            return Calculator.valueOfSupply * Calculator.vatRate;
        }
        public static double retailPrice() {
            return Calculator.valueOfSupply+getVat();
        }
        public static double costRate() {
            return Calculator.valueOfSupply * Calculator.expenseRate;
        }
        public static double income() {
            return Calculator.valueOfSupply - costRate();
        }
        public static double dividend(double magnification) {
            return income() * magnification;
        }
        public static void printResults() {
            System.out.println("공급가 : " + Calculator.valueOfSupply);
            System.out.println("부가세 : " + getVat());
            System.out.println("소비자가 : " + retailPrice());
            System.out.println("원가 : " + costRate());
            System.out.println("순익 : " + income());
            System.out.println("배당1 : " + dividend(0.5));
            System.out.println("배당2 : " + dividend(0.3));
            System.out.println("배당3 : " + dividend(0.2));
        }
    }
}
