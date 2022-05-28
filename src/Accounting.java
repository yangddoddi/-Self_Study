class Accounting {
    public double valueOfSupply;
    public Accounting (double valueOfSupply) {
        this.valueOfSupply = valueOfSupply;
    }
    public double getVat() {
        return this.valueOfSupply * Calculator.vatRate;
    }
    public double retailPrice() {
        return this.valueOfSupply+ getVat();
    }
    public double costRate() {
        return this.valueOfSupply * Calculator.expenseRate;
    }
    public double income() {
        return this.valueOfSupply - costRate();
    }
    public double dividend(double magnification) {
        return income() * magnification;
    }
    public void printResults() {
        System.out.println("-------------------");
        System.out.println("공급가 : " + this.valueOfSupply);
        System.out.println("부가세 : " + getVat());
        System.out.println("소비자가 : " + retailPrice());
        System.out.println("원가 : " + costRate());
        System.out.println("순익 : " + income());
        System.out.println("배당1 : " + dividend(0.5));
        System.out.println("배당2 : " + dividend(0.3));
        System.out.println("배당3 : " + dividend(0.2));
        System.out.println("-------------------");
    }
}