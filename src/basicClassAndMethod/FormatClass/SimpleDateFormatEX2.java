package basicClassAndMethod.FormatClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class SimpleDateFormatEX2 {
    public static void main (String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        Date date = null;

        System.out.println("'yyyy-MM-dd' 형식에 맞게 연월일을 작성해주세요.");
        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();
            try { date = format.parse(input);
            break;}
            catch (ParseException e) {
                System.out.println("ERROR! 'yyyy-MM-dd' 형식에 맞게 연월일을 작성해주세요. (ex> 2022-11-13)");
            }
        }

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        date1.setTime(Objects.requireNonNull(date));
        long dateDiff = Math.abs(date1.getTimeInMillis() - date2.getTimeInMillis());

        System.out.println("현재 시간으로부터 지정된 날짜까지 " + dateDiff/1000 + ("초 남았습니다."));
    }
}
