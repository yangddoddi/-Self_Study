package javaPractice;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyStorage {
    public static Map<String, Integer> products = new HashMap<>();

    // 메뉴 션택
    static void selectMenu(Scanner scanner) {
        System.out.print("원하는 기능의 번호를 입력하세요.");
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1":
                prod_input(scanner);
                break;
            case "2":
                prod_remove(scanner);
                break;
            case "3":
                prod_amount_add(scanner);
                break;
            case "4" :
                prod_amount_decrease(scanner);
                break;
            case "5" :
                prod_search();
                break;
            case "6" :
                exit();
                break;
            default:
                break;
        }
        showMenu();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        welcome();

        while (true) {
            selectMenu(scanner);
        }
    }

    public static void welcome() {
        System.out.println("[Item_Storage_V3]\n" +
                "------------------------------\n" +
                "[System] 점장님 어서오세요.\n" +
                "[System] 해당 프로그램의 기능입니다.\n" +
                "1. 물건 정보(제품명) 등록하기\n" +
                "2. 물건 정보(제품명) 등록 취소하기\n" +
                "3. 물건 넣기 (제품 입고)\n" +
                "4. 물건 빼기 (제품 출고)\n" +
                "5. 재고 조회\n" +
                "6. 프로그램 종료\n" +
                "------------------------------");
    }

    // 전체 메뉴 보이기
    public static void showMenu() {
        System.out.println(
                "------------------------------\n" +
                "1. 물건 정보(제품명) 등록하기\n" +
                "2. 물건 정보(제품명) 등록 취소하기\n" +
                "3. 물건 넣기 (제품 입고)\n" +
                "4. 물건 빼기 (제품 출고)\n" +
                "5. 재고 조회\n" +
                "6. 프로그램 종료\n" +
                "------------------------------");
    }

    // 상품 등록
    public static void prod_input(Scanner scanner) {
        prod_search();
        System.out.print("[System] 제품 등록을 원하는 제품명을 입력하세요 : ");
        String userInput = scanner.nextLine();
        products.put(userInput, 0);
        prod_search();
    }

    // 상품 삭제
    public static void prod_remove(Scanner scanner) {
        prod_search();
        System.out.print("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
        String userInput = scanner.nextLine();
        if (products.getOrDefault(userInput, null) != null) {
            products.remove(userInput);
            System.out.println("[System] 제품 취소가 완료됬습니다.");
        } else {
            System.out.println("[System] 존재하지 않는 제품입니다.");
        }
    }

    // 상품 개수 추가
    public static void prod_amount_add(Scanner scanner) {
        prod_search();
        System.out.print("[System] 수량을 추가할 제품명을 입력하세요 : ");
        String userInput = scanner.nextLine();
        System.out.print("[System] 추가할 수량을 입력해주세요 : ");
        Integer userInputNum = Integer.parseInt(scanner.nextLine());
        if (products.getOrDefault(userInput, null) != null) {
            products.put(userInput, userInputNum);
            prod_search();
        } else {
            System.out.println("[System] 존재하지 않는 제품입니다.");
            prod_search();
        }
    }

    // 상품 출고
    public static void prod_amount_decrease(Scanner scanner) {
        prod_search();
        System.out.print("[System] 출고할 제품명을 입력하세요 : ");
        String userInput = scanner.nextLine();
        System.out.print("[System] 출고할 수량을 입력해주세요 : ");
        Integer userInputNum = Integer.parseInt(scanner.nextLine());
        if (products.getOrDefault(userInput, null) != null) {
            int origin = products.get(userInput);
            products.put(userInput, origin-userInputNum);
            prod_search();
        } else {
            System.out.println("[System] 존재하지 않는 제품입니다.");
            prod_search();
        }
    }

    // 재고 조회
    public static void prod_search() {
        System.out.println("[System] 현재 등록된 제품 및 수량 ▼");
        products.entrySet().iterator().forEachRemaining((e) ->
        {
            System.out.println("> " + e.getKey() + " : " + e.getValue() + "개");
        });
    }

    // 프로그램 종료
    public static void exit() {
        System.out.println("[System] 프로그램을 종료합니다.\n" +
                "[System] 감사합니다.");
        System.exit(0);
    }
}