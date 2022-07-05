package standardOfJava.basicClassAndMethod.javaTimePackage;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Date;

public class javaTimePackage2 {
    public static <ZoneID> void main(String[] args) {
        Instant instant = Instant.now();
        Instant instant2 = Instant.ofEpochSecond(instant.getEpochSecond());
        Instant instant3 = Instant.ofEpochSecond(instant.getEpochSecond(), instant.getNano());
        System.out.println(instant.getEpochSecond());
        System.out.println(instant2);
        System.out.println(instant3);
        //Instant는 항상 UTC를 기준으로 하기 때문에 시간대를 고려해야할 경우 OffsetDateTime을 사용하자.
        // UTC는 Coordinated Universal Time의 약자로 셰계 협정시라고 부른다. GMT와 비슷하나 UTC가 더 정확하다.

        Date newDate = Date.from(instant);
        Instant instant4 = newDate.toInstant();
        // Instant는 Date를 대체하는 것이다. 각각 변경 가능.

        // localDate, localTime을 localDateTime으로 변환하는 여러가지 방법
        LocalDate localD = LocalDate.now();
        LocalTime localT = LocalTime.now();

        LocalDateTime localDT1 = LocalDateTime.of(localD, localT);
        LocalDateTime localDT2 = localD.atTime(localT);
        LocalDateTime localDT3 = localD.atTime(12, 45, 40, 0);
        LocalDateTime localDT4 = localT.atDate(localD);
        LocalDateTime localDT5 = localT.atDate(LocalDate.of(2022, 12, 13));

        // LocalDateTime을 LocalDate 및 LocalTime으로도 물론 가능하다.
        LocalDate localDate = localDT1.toLocalDate();
        LocalTime localTime = localDT1.toLocalTime();

        // ZoneId 가능 목록?
        System.out.println(ZoneId.getAvailableZoneIds());
        // ZoneId를 활용한 zonedDateTime 생성
        // Zoneid는 DST(일광 절약시간)을 처리해주기 때문에 TimeZone클래스보다 편리하다.
        ZoneId zoneId = ZoneId.of("Asia/Seoul");
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withZoneSameInstant(zoneId);
        ZonedDateTime zonedDateTime1 = LocalDate.now().atStartOfDay(zoneId);
        System.out.println("zonedDateTime : " + zonedDateTime);
        System.out.println("zonedDateTime1 : " + zonedDateTime1);
        // ZoneID를 이용해 특정 지역의 현재 시간 확인하기
        ZoneId zoneID2 = ZoneId.of("America/Cuiaba");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now().withZoneSameInstant(zoneID2);
        System.out.println(zonedDateTime2);

        // 시차 구하기
        ZoneOffset offset = ZonedDateTime.now().getOffset();
        System.out.println(offset);
        // 시차 초단위로 변경
        int offsetInSec = offset.get(ChronoField.OFFSET_SECONDS);
        System.out.println(offsetInSec);

        // Zone
        ZonedDateTime zdt = ZonedDateTime.now();
        OffsetDateTime odt = OffsetDateTime.now();
        // ZonedDateTime을 OffsetDateTime으로 변환
        // ZonedDateTime은 계절별로 시간이 변경되기 때문에 다른 시간대에 존재하는 컴퓨터간 통신에는 OffsetDateTime이 더 안정적이다.
        OffsetDateTime odt2 = zdt.toOffsetDateTime();

        // 다양한 변환 가능
        LocalDate date = odt2.toLocalDate();
        LocalDateTime ltd = zdt.toLocalDateTime();
        long EpochSecond = zdt.toEpochSecond();
        long EpochSecond2 = odt2.toEpochSecond();
        Instant instant1 = zdt.toInstant();

        // 예제
        LocalDateTime ltdEx = LocalDateTime.now();
        ZonedDateTime zdtEx = LocalDateTime.now().atZone(zoneId);
        OffsetDateTime odtEx = LocalDateTime.now().atOffset(offset);

        System.out.println("LocalDateTime : " + ltdEx);
        System.out.println("ZonedDateTime : " + zdtEx);
        System.out.println("OffsetDateTime : " + odtEx);
    }
}