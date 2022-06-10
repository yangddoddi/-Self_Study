package basicClassAndMethod.FormatClass;

import java.text.MessageFormat;

public class MessageFormatEX {
    public static void main(String[] args) {
        final String tableName = "TEST_CASE";
        String format = tableName + " : " + " (''{0}'',''{1}'',''{2}'',''{3}'') ";
        String[][] data = {{"양또띠","20세","남성","학생"},{"김바보","28세","남성","무직"}};


        for (int i=0; i<data.length; i++) {
            String result = MessageFormat.format(format, data[0][i]);
            System.out.println(result);
        }
    }
}
