package javaPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class YoutubeSub {
    //TODO:
    //관리자 계정을 생성
    final static String ADMIN_ID = "admin123";
    final static String ADMIN_PASSWORD = "123";
    static HashMap<String,String> filteringMap = new HashMap<>();

    public static void main(String[] args) {
        // 사용자 계정 체크
        Scanner scanner = new Scanner(System.in);
        System.out.print("[시스템] 유튜브 계정의 아이디를 입력하세요 {Ex - admin} : ");
        String inputId = scanner.nextLine();
        System.out.print("[시스템] 유튜브 계정의 비밀번호를 입력하세요{Ex - 0000} : ");
        String inputPassword = scanner.nextLine();
        checkAdmin(inputId, inputPassword);

        // 사용자 메뉴 선택


        while(true) {
            System.out.printf("%n%n[시스템] 원하는 메뉴의 번호를 입력해주세요.%n");
            System.out.println("1. 현재 금지어, 대체어 리스트 확인 ");
            System.out.println("2. 새로운 금지어, 대체어 리스트 등록 ");
            System.out.println("3. 필터링 동작 확인 ");
            String inputSelect = scanner.nextLine();

            switch (inputSelect) {
                case "1":
                    viewFilterList();
                    break;
                case "2":
                    addFilter(scanner);
                    break;
                case "3":
                    testFilter(scanner);
                    break;
                default:
                    System.out.println("잘못된 입력 번호입니다. 다시 입력해주세요.");
                    System.exit(0);
            }
        }
    }

    // 계정 체크 메서드
    static void checkAdmin(String id, String password) {
        if ( !ADMIN_ID.equals(id) || !ADMIN_PASSWORD.equals(password) ) {
            System.out.println("잘못된 로그인 정보입니다. 시스템을 종료합니다.");
            System.exit(0);
        }
    }

    // 현재 금칙어 : 대체어 목록 조회
    static void viewFilterList() {
        System.out.println("[알림] 프로그램의 금칙어 : 대체어 리스트입니다.");
        int cnt = 0;
        for (Map.Entry<String,String> entrySet : filteringMap.entrySet()) {
            cnt++;
            String origin = entrySet.getKey();
            String filter = entrySet.getValue();
            System.out.println(cnt + ". [ 금칙어 : " + origin + ", 대체어 : " + filter + " ]");
        }
    }

    // 금칙어 : 대체어 등록
    static void addFilter(Scanner scanner) {
        System.out.println("[시스템] 새롭게 등록할 금지어를 입력해주세요.");
        String origin = scanner.nextLine();
        System.out.println("[시스템] 해당 금지어의 대체어를 입력해주세요.");
        String filter = scanner.nextLine();
        filteringMap.put(origin, filter);
    }

    // 필터링 기능 테스트
    static void testFilter(Scanner scanner) {
        System.out.println("[시스템] 필터링할 문자를 입력하세요.");
        String userInput = scanner.nextLine();
        String result = "";

        // map의 key(금칙어)와 같은 문자열이 있으면 value(대체어)로 변환
        String[] filtered = filteringMap.keySet().toArray(new String[0]);
        for (String str : filtered) {
            System.out.println(str);
            if (userInput.contains(str)) {
                userInput = userInput.replace(str, filteringMap.get(str));
            }
        }

        System.out.println("[시스템] 필터링 결과입니다.");
        System.out.println(userInput);
    }
}
