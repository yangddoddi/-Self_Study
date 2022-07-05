package standardOfJava.basicClassAndMethod.javaTimePackage;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class javaTimePackage1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateAndTime = LocalDateTime.now();
        Instant instant = Instant.now();
        Year year = Year.now();
        YearMonth yearMonth = YearMonth.now();
        MonthDay monthDay = MonthDay.now();

        LocalDateTime customDate = LocalDateTime.of(LocalDate.of(1999,12,31),
                LocalTime.of(23,59,59));

        System.out.println("LocalDate : " + date);
        System.out.println("LocalTime : " + time);
        System.out.println("LocalDateTime : " + dateAndTime);
        System.out.println("Instant : " + instant);
        System.out.println("Year : " + year);
        System.out.println("YearMonth : " + yearMonth);
        System.out.println("MonthDay : " + monthDay);

        System.out.println("customDate : " + customDate);

        LocalDate parseDate = LocalDate.parse("2022-12-12");
        LocalTime parseTime = LocalTime.parse("10:20");

        System.out.println("parseDate : " + parseDate);
        System.out.println("parseTime : " + parseTime);

        LocalDateTime date2 = LocalDateTime.now();

        // getLong 메서드가 필요한 필드가 몇가지 있다, 해당 필드는 get메서드를 사용할 경우 예외 발생.
        // 해당 클래스가 지원하는 필드만 사용 가능. 지원하지 않는 필드 사용 시 UnsupportedTemporalTypeException 발생.
        System.out.println("date.getYear() : " + date.getYear());
        System.out.println("date.getDayOfMonth() : " + date.getDayOfMonth());
        System.out.println("date.getMonthValue() : " + date.getMonthValue());
        System.out.println("date.getChronology() : " + date.getChronology());
        System.out.println("date.getEra() : " + date.getEra());
        System.out.println("date.lengthOfMonth() : " + date.lengthOfMonth());
        System.out.println("date.lengthOfYear() : " + date.lengthOfYear());
        System.out.println("date.isLeapYear() : " + date.isLeapYear());
        System.out.println("date.get(ChronoField.AMPM_OF_DAY) : " + date2.get(ChronoField.AMPM_OF_DAY));
        System.out.println("date.get(ChronoField.CLOCK_HOUR_OF_AMPM) : " + date2.get(ChronoField.CLOCK_HOUR_OF_AMPM));
        System.out.println("date.getLong(ChronoField.PROLEPTIC_MONTH) : " + date2.getLong(ChronoField.PROLEPTIC_MONTH));
        System.out.println("date.get(ChronoField.YEAR_OF_ERA) : " + date2.get(ChronoField.YEAR_OF_ERA));
        System.out.println("date.getLong(ChronoField.MICRO_OF_SECOND) : " + date2.getLong(ChronoField.MICRO_OF_SECOND));
        System.out.println("date.getLong(ChronoField.NANO_OF_SECOND) : " + date2.getLong(ChronoField.NANO_OF_SECOND));
        System.out.println("date.getLong(ChronoField.NANO_OF_DAY) : " + date2.getLong(ChronoField.NANO_OF_DAY));
        System.out.println("date.getLong(ChronoField.MICRO_OF_DAY) : " + date2.getLong(ChronoField.MICRO_OF_DAY));
        System.out.println("date.getLong(ChronoField.EPOCH_DAY) : " + date2.getLong(ChronoField.EPOCH_DAY));
        // 해당 값의 범위를 알고 싶은 경우 필드값.range()메서드를 사용
        System.out.println("ChronoField.NANO_OF_DAY.range() : " + ChronoField.NANO_OF_DAY.range());

        date = date.withYear(1999);
        System.out.println("date = " + date);
        date = date.plusYears(1);
        System.out.println("date = " + date);
        date = date.withDayOfMonth(30);
        System.out.println("date = " + date);
        date = date.with(ChronoField.YEAR, 1000);
        System.out.println("date = " + date);

        LocalTime time2 = LocalTime.now();
        time2 = time2.truncatedTo(ChronoUnit.DAYS);
        System.out.println("time2 = " + time2);
        // 연,월,일에는 0이 없기 때문에 LocalDate에는 truncatedTo가 존재하지 않는다. 또한 해당 메서드는 ChronoUnit의 시간 관련 매개변수만 사용 가능하다.

        LocalTime time3 = LocalTime.now();
        System.out.println("time2.isBefore(time3) = " + time2.isBefore(time3));
        // isEqual은 LocalDate에만 존재한다. equals와의 차이는 오직 연월일만 비교한다는 것. 대부분의 경우에는 둘의 결과가 같다고 봐도 무방.
    }
}
