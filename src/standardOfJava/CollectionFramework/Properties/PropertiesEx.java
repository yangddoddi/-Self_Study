package standardOfJava.CollectionFramework.Properties;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx {
    public static void main(String[] args) {
        Properties p = new Properties();

        p.setProperty("이름","양모시기");
        p.setProperty("나이","세살");
        p.setProperty("소원","숙면하기");
        // key와 value를 String으로 가진다

        // Enumeration을 사용해서 반복문 사용 가능
      Enumeration e = p.propertyNames();
        while ( e.hasMoreElements() ) {
            String key = String.valueOf(e.nextElement());
            System.out.println(key + " : " + p.getProperty(key));
        }

        p.setProperty("이름","김모시기");
        System.out.println(p.getProperty("이름"));
        // 이렇게 변경 및 출력도 가능하다.

        p.list(System.out);
        // 콘솔창에 출력
    }
}
