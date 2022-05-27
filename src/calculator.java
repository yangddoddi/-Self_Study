public class calculator {

    public static void main(String[] args) {

        double valueOfSupply = 35000;
        double vat = valueOfSupply * 0.1;
        double retailPrice = valueOfSupply+vat;
        double costRate = valueOfSupply * 0.3;
        double income = valueOfSupply - costRate;
        double dividend1 = income * 0.5;
        double dividend2 = income * 0.3;
        double dividend3 = income * 0.2;

        System.out.println("공급가 : " + valueOfSupply);
        System.out.println("부가세 : " + vat);
        System.out.println("소비자가 : " + retailPrice);
        System.out.println("원가 : " + costRate);
        System.out.println("순익 : " + income);
        System.out.println("배당1 : " + dividend1);
        System.out.println("배당2 : " + dividend2);
        System.out.println("배당3 : " + dividend3);
    }
}
