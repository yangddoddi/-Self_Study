package OOP.Basic;


import java.io.File;
import java.util.Scanner;

public class ExceptionHandling3 {
    static File CreateFile(String filename) throws Exception {
        if ( filename == null || filename.equals("") ) {
            throw new Exception("유효하지 않은 파일명입니다.");
        }
        File file = new File(filename + ".txt");
        file.createNewFile();
        return file;
    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("생성할 파일명을 입력하세요.(확장자 제외)");
        String fileName = scanner.nextLine();
        try {
            File file = CreateFile(fileName);
        } catch (Exception e) {
            System.out.println(e.getMessage() + " 다시 입력해주세요.");
        }
    }
}
