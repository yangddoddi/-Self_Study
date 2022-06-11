package basicClassAndMethod.javaTimePackage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

// 시간 및 날짜 형식화
public class javaTimePackage5 {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String format1 = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        String format2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String format3 = ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        String format4 = time.format(DateTimeFormatter.ISO_TIME);

        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);
        System.out.println(format4);

        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        // 직접 포멧을 커스텀할 수도 있다.
        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("FormatStyle.FULL : " + zdt.format(formatter1));
        System.out.println("FormatStyle.LONG : " + zdt.format(formatter2));
        System.out.println("FormatStyle.MEDIUM : " + zdt.format(formatter3));
        System.out.println("FormatStyle.SHORT : " + zdt.format(formatter4));
        System.out.println("ofPattern(Custom) : " + zdt.format(formatter5));
    }
}
