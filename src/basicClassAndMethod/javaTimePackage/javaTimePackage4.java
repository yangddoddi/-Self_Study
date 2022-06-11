package basicClassAndMethod.javaTimePackage;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.function.Supplier;

public class javaTimePackage4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime christmas = LocalDateTime.of(LocalDate.of(2027,12,25),
                LocalTime.of(0,0,0));

        LocalDate nowDay = now.toLocalDate();
        LocalDate christmasDay = christmas.toLocalDate();

        LocalTime nowTime = now.toLocalTime();
        LocalTime christmasTime = christmas.toLocalTime();

        Period pe = Period.between(nowDay, christmasDay);
        Duration du = Duration.between(nowTime, christmasTime);

        int years = pe.getYears();
        int months = pe.getMonths();
        int days = pe.getDays();
        System.out.println("남은 기간은 " + years +"년 " + months + "개월 " + days + "일 입니다.");

        long hours = du.getSeconds()/3600;
        long minutes = (du.getSeconds() - hours*3600) / 60;
        long seconds = (du.getSeconds() - hours*3600 - minutes*60)%60;
        System.out.println("남은 시간은 " + hours + "시간 " + minutes + "분 " + seconds + "초 입니다.");

        // duration은 LocalTime에 대입해서 구하는 게 더 편하다.
        LocalTime tempTime = LocalTime.of(0,0).plusSeconds(du.getSeconds());
        int hour = tempTime.getHour();
        int minute = tempTime.getMinute();
        int sec = tempTime.getSecond();
        System.out.println("남은 시간은 " + hour + "시간 " + minute + "분 " + sec + "초 입니다.");

        pe = pe.withYears(2);
        du = du.withSeconds(120);
        System.out.println("pe.getYears = " + pe.getYears());
        System.out.println("du.getSeconds = " + du.getSeconds());

        // Duration과 Period의 사칙연산 메서드
        pe = pe.minusYears(1).multipliedBy(2);
        du = du.plusSeconds(20000).dividedBy(60);
        du = du.abs(); // 부호 제거
        du = du.negated(); // 부호 반대로
        pe = pe.normalized(); // 12개월이 넘으면 1년으로 환산시킴

        System.out.println("pe.getYears = " + pe.getYears());
        System.out.println("du.getSeconds = " + du.getSeconds());

        // 단위 변경 메서드
        long totalMonth = pe.toTotalMonths(); // 일 단위는 무시하고 기간을 개월로 변경해서 반환
        long toDays = du.toDays(); // 일 단위로 변경해서 반환
        long toHours = du.toHours();
        long toMinutes = du.toMinutes();
        long toMillis = du.toMillis();
        long toNanos = du.toNanos();

        // 사실 굳이 Duration이나 Period를 사용하지 않아도 LocalDate는 toEpoch로 -연산
        // LocalTime은 toSecondOfDay 메서드를 이용해 시간 차를 계산할 수 있음
    }
}
