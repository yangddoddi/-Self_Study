package basicClassAndMethod.javaTimePackage;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class javaTimePackage3 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfNextYear = today.with(TemporalAdjusters.firstDayOfNextYear());
        LocalDate firstDayOfNextMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate firstDayOfYear = today.with(TemporalAdjusters.firstDayOfYear());
        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate LastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        LocalDate LastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate firstInMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate previousMonday = today.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        LocalDate thirdSaturdayInMonth = today.with(TemporalAdjusters.dayOfWeekInMonth(3,DayOfWeek.SATURDAY));

        System.out.println("today : " + today);
        System.out.println("firstDayOfNextYear : " + firstDayOfNextYear);
        System.out.println("firstDayOfNextMonth : " + firstDayOfNextMonth);
        System.out.println("firstDayOfYear : " + firstDayOfYear);
        System.out.println("firstDayOfMonth : " + firstDayOfMonth);
        System.out.println("LastDayOfYear : " + LastDayOfYear);
        System.out.println("LastDayOfMonth : " + LastDayOfMonth);
        System.out.println("firstInMonth : " + firstInMonth);
        System.out.println("previousMonday : " + previousMonday);
        System.out.println("nextMonday : " + nextMonday);
        System.out.println("thirdSaturdayInMonth : " + thirdSaturdayInMonth);

    }
}

class DayAfterTomorrow implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        return temporal.plus(2, ChronoUnit.DAYS);
        // 2일을 더한다
    }
}
