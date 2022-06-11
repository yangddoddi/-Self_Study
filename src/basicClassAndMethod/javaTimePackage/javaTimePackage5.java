package basicClassAndMethod.javaTimePackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class javaTimePackage5 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String yyyymmdd = DateTimeFormatter.ISO_LOCAL_DATE.format(date);
        String yyyymmdd2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(yyyymmdd);
        System.out.println(yyyymmdd2);
    }
}
