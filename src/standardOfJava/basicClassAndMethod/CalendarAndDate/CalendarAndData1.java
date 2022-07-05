package standardOfJava.basicClassAndMethod.CalendarAndDate;

import sun.util.BuddhistCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarAndData1 {
    final static String[] weekdayNames = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
    public static void main(String[] args) {
//    Calendar car = new Calendar();
//    Calendar는 추상 클래스이기 때문에 직접 객체를 생성할 수 없고 메서드를 통해 인스턴스를 생성햐애 한다.
        Calendar cal1 = Calendar.getInstance();
        // getInstance를 사용하면 시스템 설정에 따라 자동으로 정해줌
        // getInstance가 스태틱인 이유 => Calendar는 추상 메서드이므로 인스턴스를 생성할 수 없어서 static 메서드만 사용 가능함.

        Calendar cal2 = new GregorianCalendar();
        // 전세계 공통 그레고리력
        Calendar cal3 = new BuddhistCalendar();
        // 태국은 태국력을 기준으로 한다.

        // Date <-> Calendar 변환
        // 1. Calendar -> Date;
        Calendar car5 = Calendar.getInstance();
        Date d = new Date(car5.getTimeInMillis());
        // 2. Date -> Calendar;
        Date d2 = new Date();
        Calendar cal6 = Calendar.getInstance();
        cal6.setTime(d2);

        System.out.printf("지금은 %d년 %d월 %d일 %d시 %d분 %d초 입니다.%n", cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH)+1, cal1.get(Calendar.DAY_OF_MONTH),
                cal1.get(Calendar.HOUR), cal1.get(Calendar.MINUTE), cal1.get(Calendar.SECOND));
        // 주의 : Calendar.MONTH는 0월부터 11월을 체크한다.. 대체 왜?
        System.out.printf("오늘은 %d월의 %d번째 %s입니다. %n", cal1.get(Calendar.MONTH), cal1.get(Calendar.DAY_OF_WEEK_IN_MONTH), weekdayNames[cal1.get(Calendar.DAY_OF_WEEK)-1]);

        Calendar today = Calendar.getInstance();
        Calendar dDay = Calendar.getInstance();
        dDay.set(2022,Calendar.DECEMBER,24, 0, 0);

        System.out.printf("지금은 %d년 %d월 %d일 %d시 %d분 %d초 입니다.%n", today.get(Calendar.YEAR), today.get(Calendar.MONTH)+1,today.get(Calendar.DAY_OF_MONTH),
                today.get(Calendar.HOUR), today.get(Calendar.MINUTE), today.get(Calendar.SECOND));

        System.out.printf("목표일은 %d년 %d월 %d일 %d시 %d분 입니다.%n", dDay.get(Calendar.YEAR), dDay.get(Calendar.MONTH), dDay.get(Calendar.DAY_OF_MONTH),
                dDay.get(Calendar.HOUR), dDay.get(Calendar.MINUTE));

        long diff = dDay.getTimeInMillis()- today.getTimeInMillis();
        System.out.println(dDay.getTimeInMillis() + "     " + today.getTimeInMillis());
        System.out.printf("목표일까지 남은 시간은 %d초이며 일로 환산하면 %d일입니다.%n", diff, (int)(diff/86400000+1));



    }
}
