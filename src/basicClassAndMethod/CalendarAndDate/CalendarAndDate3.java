package basicClassAndMethod.CalendarAndDate;

import java.util.*;

public class CalendarAndDate3 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int thisYear = calendar.get(Calendar.YEAR);
        int thisMonth = calendar.get(Calendar.MONTH);
        calendar.set(thisYear,11,1);
        System.out.println(calendar.getTime());

        while (true) {
            Scanner yearScanner = new Scanner(System.in);
            System.out.println("희망하는 해를 입력하세요.");
            int inputYear = yearScanner.nextInt();
//            yearScanner.close();
            Scanner monthScanner = new Scanner(System.in);
            System.out.println("희망하는 달을 입력하세요.");
            int inputMonth = monthScanner.nextInt();
            if ( inputMonth > 12 || inputMonth < 1) {
                System.out.println("잘못된 입력값입니다.");
                continue;
            }

            calendar.set(inputYear, inputMonth-1, 5);

            int firstDay = calendar.get(Calendar.DAY_OF_WEEK);
            int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println(firstDay);
            System.out.println(lastDay);

            System.out.printf(" %5d년 %5d월%n",inputYear,inputMonth);
            System.out.printf("  SU MO TU WE TH FR SA%n   ");
            for ( int j=1; j<firstDay; j++) {
                System.out.print("   ");
            }
            for ( int i=1, n=firstDay; i<=lastDay; i++, n++ ) {
                if ( n%7 == 0 ) {
                    System.out.println();
                    System.out.print(" ");
                }
                System.out.print( ( i >= 10 ? " " : "  " ) + i);
            }
            System.out.println();
        }
    }
}
