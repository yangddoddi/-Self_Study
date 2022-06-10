package basicClassAndMethod.FormatClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Scanner;

public class MessageFormatEX2 {
    public static void main (String[] args) throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File("MessageFormat.txt"));
        final String TABLE_NAME = "TEST_DATA_TABLE";
        String format = TABLE_NAME + " : " + "({0},{1},{2},{3})";
        String textFormat = "{0},{1},{2},{3}";
        MessageFormat messageFormat = new MessageFormat(textFormat);
        // 먼저 각 라인을 4등분한다.

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Object[] obj = messageFormat.parse(line);
            // 4등분해서 오브젝트 배열에 밀어넣고
            System.out.println(MessageFormat.format(format, obj));
            // 오브젝트 배열을 원하는 포멧에 맞춰서 출력
        }
    }
}
