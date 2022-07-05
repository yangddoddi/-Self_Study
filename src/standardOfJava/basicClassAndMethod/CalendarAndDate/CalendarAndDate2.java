package standardOfJava.basicClassAndMethod.CalendarAndDate;

import java.util.*;

public class CalendarAndDate2 {
    public static void main (String[] args) {
        Calendar date1 = Calendar.getInstance();
        date1.add(Calendar.MONTH,-8);
        System.out.println("8개월 전? " + toString(date1));
        date1.add(Calendar.MONTH, +8);
        System.out.println("rollBack " + toString(date1));
        date1.add(Calendar.HOUR, 200);
        System.out.println("200시간 후? " + toString(date1));
        date1.roll(Calendar.HOUR, 200000000);
        System.out.println("20000000시간 후?(roll) " + toString(date1));
        // 시간 외 다른 것은 변하지 않는다.
        date1.set(2022,Calendar.JANUARY, 30);
        System.out.println("현재 ? " + toString(date1));
        date1.roll(Calendar.MONTH,+1);
        System.out.println("1개월 후(roll) ? " + toString(date1));
        // 2월에 30일이 없으므로 2월 28일로 날짜까지 바뀐다.

    }

    public static String toString(Calendar cal) {
        return cal.get(Calendar.YEAR)+"년 "+(cal.get(Calendar.MONTH)+1)+"월 "+cal.get(Calendar.DAY_OF_MONTH)+" 일"+
                cal.get(Calendar.HOUR)+"시 "+cal.get(Calendar.MINUTE)+"분 ";
    }
}