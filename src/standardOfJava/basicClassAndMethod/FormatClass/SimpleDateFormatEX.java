package standardOfJava.basicClassAndMethod.FormatClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// DateFormat은 SimpleDateFormat의 조상인 추상 클래스이다.
// DateFormat의 인스턴스 생성을 위해 getInstance()를 사용하는 것이고, 이로 인해 반환되는 것은 SimpleDataFormat인스턴스이다.
public class SimpleDateFormatEX {
    public static void main (String[] args) {
        Calendar date = Calendar.getInstance();
        Date newDate = date.getTime();

        SimpleDateFormat format1,format2,format3,format4;

        format1 = new SimpleDateFormat("yyyy-MM-dd");
        format2 = new SimpleDateFormat("''yy년 MMM dd일 E");
        format3 = new SimpleDateFormat("yyyy.MM.dd E aHH:mm:ss.S");
        format4 = new SimpleDateFormat("오늘은 올해의 w번째 주에 속하는 D번째 날입니다");

        System.out.println(format1.format(newDate));
        System.out.println(format2.format(newDate));
        System.out.println(format3.format(newDate));
        System.out.println(format4.format(newDate));
    }
}
