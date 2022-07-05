package standardOfJava.InputAndOutput;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class ioStudy17 {

    public static void main(String[] args) {
        final String PATH = "/Users/eunchanyang/Desktop/java/javaStudy";
        File file = new File(PATH);

        System.out.println("원하는 메뉴의 번호를 입력해주세요.");
        System.out.println("1.파일명 정렬(오름차순)");
        System.out.println("2.파일명 정렬(내림차순)");
        System.out.println("3.파일 용량순 정렬(오름차순)");
        System.out.println("4.파일 용량순 정렬(내림차순)");
        System.out.println("5.최종 수정일 정렬(오름차순) ");
        System.out.println("6.최종 수정일 정렬(내림차순)");
        System.out.println("7.원하는 키워드로 검색");
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();

        switch (input1) {
            case "1":
                printResult(file, 1);
                break;
            case "2":
                printResult(file, 2);
                break;
            case "3":
                printResult(file, 3);
                break;
            case "4":
                printResult(file, 4);
                break;
            case "5":
                printResult(file, 5);
                break;
            case "6":
                printResult(file, 6);
                break;
            case "7":
                System.out.println("원하는 키워드를 입력하세요.");
                String input2 = scanner.nextLine();
                searcher(input2, file);
                break;
            default:
                System.out.println("잘못된 요청");
                System.exit(0);
        }
        scanner.close();
    }

    // 정렬 후 결과 반환
    static void printResult(@NotNull File dir, int comp) {
        List<File> temp = Arrays.asList(dir.listFiles());
        ArrayList<File> files = new ArrayList<>();
        files.addAll(temp);
        String fileName = "";
        String pattern = "yyyy-MM-dd a HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        files.sort(sorter(comp));

        for (int i = 0; i < files.size(); i++) {
            String attribute = "";
            long fileSize = 0;
            File fileInArr = files.get(i);
            fileName = fileInArr.getName();
            if (fileInArr.isDirectory()) {
                attribute = "DIR";
            } else {
                if (fileInArr.canWrite()) {
                    attribute += "W";
                } // 읽고 쓸 수 있는지 체크
                if (fileInArr.canRead()) {
                    attribute += "R";
                }
                fileSize = fileInArr.length();
            }

            System.out.println(formatter.format(fileInArr.lastModified()) + " " + fileName + " " + attribute + " "
                    + ((fileSize > 0) ? fileSize + "byte" : ""));
            // 파일만 파일 사이즈 표기
        }
    }

    // 키워드 검색
    static void searcher(String keyword, File dir) {
        File[] temp = dir.listFiles();
        List<File> temp2 = Arrays.asList(temp);
        ArrayList<File> files = new ArrayList<>();
        files.addAll(temp2);
        ArrayList<File> searchList = new ArrayList<>();

        for (int i = 0; i < files.size(); i++) {
            File f = files.get(i);
            if (f.isDirectory()) {
                searcher(keyword, f);
            } else {
                if (f.getName().contains(keyword)) {
                    searchList.add(f);
                }
            }
        }

        System.out.println("[" + dir + "] 에서 " + searchList.size() + "개의 파일을 찾음.");

        for (File file : searchList) {
            System.out.println(file.getName());
        }
    }

    // 정렬
    static Comparator sorter(int comp) {
        Comparator comparator = new Comparator() {
            int result = 0;

            @Override
            public int compare(Object o1, Object o2) {
                String fileName1 = ((File) o1).getName();
                String fileName2 = ((File) o2).getName();

                long fileSize1 = ((File) o1).length();
                long fileSize2 = ((File) o2).length();

                long lastModified1 = ((File) o1).lastModified();
                long lastModified2 = ((File) o2).lastModified();

                switch (comp) {
                    case 1:
                        result = fileName1.compareTo(fileName2);
                        break;
                    case 2:
                        result = fileName2.compareTo(fileName1);
                        break;
                    case 3:
                        if (fileSize1 - fileSize2 > 0) {
                            result = 1;
                        }
                        if (fileSize1 - fileSize2 < 0) {
                            result = -1;
                        }
                        break;
                    case 4:
                        if (lastModified1 - lastModified2 < 0) {
                            result = 1;
                        }
                        if (lastModified1 - lastModified2 > 0) {
                            result = -1;
                        }
                        break;
                    case 5:
                        if (fileSize1 - fileSize2 < 0) {
                            result = 1;
                        }
                        if (fileSize1 - fileSize2 > 0) {
                            result = -1;
                        }
                        break;
                    case 6:
                        if (lastModified1 - lastModified2 > 0) {
                            result = 1;
                        }
                        if (lastModified1 - lastModified2 < 0) {
                            result = -1;
                        }
                        break;
                }
                return result;
            }
        };
        return comparator;
    }
}