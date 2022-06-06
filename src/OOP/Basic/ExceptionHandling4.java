package OOP.Basic;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionHandling4 {
    static File CreateFile(String fileName) throws IOException {
       try {
           if ( fileName == null || fileName.equals("") ) {
               throw new Exception();
           }
       } catch (Exception e) {
           fileName = "제목 없음";
       } finally {
           File file = new File(fileName);
           file.createNewFile();
           return file;
       }
    }
    public static void main(String[] args) {
        System.out.println("원하는 파일명을 입력하세요. (확장자 제외)");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        scanner.close();
        try {
            CreateFile(fileName);
        } catch (IOException e) { // 메서드에서 예외처리를 모두 끝내는 예제를 만들려고 했으나
            e.printStackTrace(); // createNewFile 메서드가 예외를 필요로한다..
        }
    }
}
