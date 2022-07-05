package standardOfJava.CollectionFramework.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx {
    public static void main(String[] args) {
        HashMap<String, String> user = new HashMap<>();

        user.put("apple", "loveiphone123");
        user.put("samsung", "lovegalaxy123");
        user.put("lg", "hatephone123");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("아이디를 입력해주세요.");
            String id = scanner.nextLine();
            if ( !user.containsKey(id) ) {
                System.out.println("존재하지 않는 아이디입니다.");
                continue;
            }
            System.out.println("비밀번호를 입력해주세요.");
            String password = scanner.nextLine();
            if ( !password.equals(user.get(id)) ) {
                System.out.println("잘못된 패스워드입니다.");
                continue;
            }
            System.out.println("로그인 성공");
            break;
        }
    }
}
