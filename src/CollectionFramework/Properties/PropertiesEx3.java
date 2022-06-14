package CollectionFramework.Properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx3 {
    public static void main(String[] args) {
        // 파일 쓰기 예제
        Properties prop = new Properties();

        prop.setProperty("이름","양모시기");
        prop.setProperty("나이","9세");
        prop.setProperty("성별","남성");
        prop.setProperty("소원","쾌변");

        try {
            prop.storeToXML(new FileOutputStream("PropertiesEx3.xml"), "예제");
            prop.store(new FileOutputStream("PropertiesEx3.txt"), "예제");
        } catch (IOException e) {
        }

        // 시스템 속성 읽기 예제
        Properties sysProp = System.getProperties();
        System.out.println("java version : " + sysProp.getProperty("java.version"));
        System.out.println("user.language : " + sysProp.getProperty("user.language"));
        sysProp.list(System.out);
    }
}