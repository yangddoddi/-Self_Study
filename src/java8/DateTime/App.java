package java8.DateTime;

/*
*
* 왜 DateTime이 탄생했는가?
* 기존 Date는 굉장히 불편했음.
* enum으로 만들어서 월이 0부터 시작하거나.. Type-safe하지 않음
* 이상하고 쓸데없으며 실수할 확률이 많은 메서드도 많음
* mutable해서 Thread-Safe하지 않음
* 총체적 난국
*
*
*
* DateTime의 특징
* immutable
* -> LocalDate.plusYear(1)하면 기존 값이 바뀌는 게 아니라 새로운 Date가 생김(Immutable)
* 사람용 시간은 LocalDateTime, LocalDate, LocalTime
* 기계용은 Instant(기준시, GMT UTC)
*
* Calendar <-> DateTime <-> Instant 호환 가능능*
* */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) {

        Instant instant = Instant.now(); // 기계용 시간
        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault()); // 내 지역에 맞춘 시간

        LocalDateTime now = LocalDateTime.now(); // 현재 시각(로컬이라 내 시스템에 맞춤)
        LocalDateTime Christmas2020 = LocalDateTime.of(2020, Month.DECEMBER, 25, 0, 0, 0);
        // 특정 시간 지정

        ZonedDateTime koreaTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        // 특정 지역 시간

        Period between = Period.between(Christmas2020.toLocalDate(), koreaTime.toLocalDate());
        System.out.println(between.get(ChronoUnit.DAYS)); // 일까지만 비교
        long hehe = ChronoUnit.DAYS.between(Christmas2020.toLocalDate(), koreaTime.toLocalDate());
        System.out.println(ChronoUnit.DAYS.between(Christmas2020.toLocalDate(), koreaTime.toLocalDate()));// 전체 일수 비교
        // 각 날짜 차이 확인

        Duration.between(instant, zone.toInstant());
        // 기계용 시간 비교

        String f = now.format(DateTimeFormatter.BASIC_ISO_DATE);
        String f2 = now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(f);
        System.out.println(f2);
        // 날짜 포멧 지정

        LocalDateTime parse = LocalDateTime.parse(f);
        // 다시 파싣

        LocalDateTime plus = parse.plus(10, ChronoUnit.DAYS);
        // 새로운 인스턴스가 생성된다
    }
}
