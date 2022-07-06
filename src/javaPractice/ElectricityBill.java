package javaPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ElectricityBill {
    static final double KWH_100_Fee = 60.7;
    static final double KWH_200_Fee = 125.9;
    static final double KWH_300_Fee = 187.9;
    static final double KWH_400_Fee = 280.6;
    static final double KWH_500_Fee = 417.1;
    static final double KWH_500_UP_Fee = 670.6;


    public static void main(String[] args) throws IOException {
        System.out.println("=".repeat(25));
        System.out.println(" 주택용 전기요금(저압) 계산기 ");
        System.out.println("=".repeat(25));

        System.out.println("사용하신 전력량을 입력해주세요");
        System.out.print(">>");
        //TODO:
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double electricityUsage = Double.parseDouble(br.readLine());
        double amountBePaid = 0;
        if ( electricityUsage <= 100 ) {
            amountBePaid = less_than_100(electricityUsage);
        } else if ( electricityUsage <= 200 ) {
            amountBePaid = less_than_200(electricityUsage);
        } else if ( electricityUsage <= 300 ) {
            amountBePaid = less_than_300(electricityUsage);
        } else if ( electricityUsage <= 400 ) {
            amountBePaid = less_than_400(electricityUsage);
        } else if ( electricityUsage <= 500 ) {
            amountBePaid = less_than_500(electricityUsage);
        } else {
            amountBePaid = more_than_500(electricityUsage);
        }

        System.out.println("사용 전력량은 " + electricityUsage + "kwh, 예상 전기요금은 " + amountBePaid + "원 입니다.");
    }

    public static double less_than_100(double usage) {
        return usage * KWH_100_Fee;
    }

    public static double less_than_200(double usage) {
        if (usage % 100 == 0) {
            return less_than_100(100) + KWH_200_Fee * 100;
        } else {
            return less_than_100(100) + KWH_200_Fee * (usage % 100);
        }
    }

    public static double less_than_300(double usage) {
        if (usage % 100 == 0) {
            return less_than_100(100) + less_than_200(100) + KWH_300_Fee * 100;
        } else {
            return less_than_100(100) + less_than_200(100) + KWH_200_Fee * (usage % 100);
        }
    }

    public static double less_than_400(double usage) {
        if (usage % 100 == 0) {
            return less_than_100(100) + less_than_200(100) + less_than_300(100) + KWH_400_Fee * 100;
        } else {
            return less_than_100(100) + less_than_200(100) + less_than_300(100) + KWH_400_Fee * (usage % 100);
        }
    }

    public static double less_than_500(double usage) {
        if (usage % 100 == 0) {
            return less_than_100(100) + less_than_200(100) + less_than_300(100) + less_than_400(100) + KWH_500_Fee * 100;
        } else {
            return less_than_100(100) + less_than_200(100) + less_than_300(100) + less_than_400(100) + KWH_500_Fee * (usage % 100);
        }
    }

    public static double more_than_500(double usage) {
            return less_than_100(100) + less_than_200(100) + less_than_300(100) + less_than_400(100) + less_than_500(100) + KWH_500_UP_Fee * (usage-500);
    }

}
